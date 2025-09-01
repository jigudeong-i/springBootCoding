package com.spring.client.board.mapper;

import com.spring.client.board.vo.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

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

    @Test
    public void readCntUpdateTest(){
        int boardNumber = 1;
        int count = boardMapper.readCntUpdate(boardNumber);
        log.info("수정된 행의 수: {}", count);
    }

    @Test
    public void boardDetailTest(){
        int boardNumber = 1;
        Optional<Board> board = boardMapper.boardDetail(boardNumber);
        log.info("데이터 존재 여부: {}", board.isPresent());
        log.info("데이터 조회: {}", board.toString());
    }

    @Test
    public void boardUpdateTest(){
        //비밀번호 변경
        Board board = Board.builder()
                .boardTitle("용기가 필요한 때(수정)")
                .boardContent("당신이 할 수 있다고 믿는, 할 수 없다고 믿든, 믿는 대로 될 것이다.~")
                .boardPasswd("5555")
                .boardNumber(7).build();

        /*비밀번호 변경하지 않을 때
        Board board = Board.builder()
                .boardTitle("용기가 필요한 때 수정~")
                .boardContent("당신이 할 수 있다고 믿는, 할 수 없다고 믿든, 믿는 대로 될 것이다.~")
                .boardNumber(6).build();*/

        int count = boardMapper.boardUpdate(board);
        log.info("게시판 수정된 행의 수: {}", count);
    }

    @Test
    public void boardDeleteTest(){
        int boardNumber = 6; // 각자의 게시판 번호로 명시.
        log.info("게시판 삭제된 행의 수: {}", boardMapper.boardDelete(boardNumber));
    }
}
