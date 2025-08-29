package com.spring.client.board.service;

import com.spring.client.board.vo.Board;

import java.util.List;

public interface BoardService {
    public List<Board> boardList(Board board);  /*검색 포함 리스트*/
    public int boardInsert(Board board);
}
