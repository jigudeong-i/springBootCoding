package com.spring.client.board.service;

import com.spring.client.board.mapper.BoardMapper;
import com.spring.client.board.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public List<Board> boardList(Board board){
        List<Board> boardList = boardMapper.boardList(board);
        return boardList;
    }

    @Override
    public int boardInsert(Board board){
        int result = boardMapper.boardInsert(board);
        return result;
    }
}
