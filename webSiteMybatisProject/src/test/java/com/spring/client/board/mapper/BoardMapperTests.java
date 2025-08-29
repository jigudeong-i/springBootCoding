package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void boardListTest(){
        Board board = null;
        boardMapper.boardList(board).stream().forEach(boardData -> log.info(boardData.toString()));
    }

    @Test
    public void BoardInsertTest(){
        Board board = Board.builder()
                .boardName("김철수")
                .boardTitle("용기가 필요할 때")
                .boardContent("도중에 포기하지 말라. 망설이지 말라. 최후의 성공을 거둘 때까지 밀고 나가자.")
                .boardPasswd("1234").build();

        int count = boardMapper.boardInsert(board);
        log.info("입력된 행의 수: {}", count);
    }
}
