package com.spring.mallapi.todo.service;

import com.spring.mallapi.todo.domain.Todo;
import com.spring.mallapi.todo.dto.TodoDTO;
import com.spring.mallapi.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(TodoDTO todoDTO){
        // todoDTO 객체를 Todo 클래스 타입으로 변환 (DTO -> Entity)
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo.getTno();
    }
}
