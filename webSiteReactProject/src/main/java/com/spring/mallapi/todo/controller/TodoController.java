package com.spring.mallapi.todo.controller;

import com.spring.common.dto.PageRequestDTO;
import com.spring.common.dto.PageResponseDTO;
import com.spring.mallapi.todo.domain.Todo;
import com.spring.mallapi.todo.dto.TodoDTO;
import com.spring.mallapi.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> ba67dafdb5f72ce3388b19ca2bc89c64c9c85c94
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable(name = "tno") Long tno){
        return todoService.get(tno);
    }

//    @GetMapping("/list")
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")  // 임시 권한 설정
//    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO){
//        return todoService.list(pageRequestDTO);
//    }

    @GetMapping("/list")
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")  // 임시 권한 설정
    @PreAuthorize("hasRole('ROLE_ADMIN')") // 임시 권한 설정
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO ) {
        return todoService.list(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO todoDTO){
        Long tno = todoService.register(todoDTO);
        return Map.of("TNO", tno);
    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable(name = "tno") Long tno, @RequestBody TodoDTO todoDTO){
        todoDTO.setTno(tno);
        todoService.modify(todoDTO);
        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove(@PathVariable(name = "tno") Long tno){
        todoService.remove(tno);
        return Map.of("RESULT", "SUCCESS");
    }


}
