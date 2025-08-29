package com.spring.client.board.controller;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(@ModelAttribute Board board, Model model){
        List<Board> boardList = boardService.boardList(board);
        model.addAttribute("boardList", boardList);
        return "client/board/boardList";
    }

    @GetMapping("/insertForm")
    public String insertForm(Board board){
        return "client/board/insertForm";
    }

    @PostMapping("/boardInsert")
    public String boardInsert(Board board){
        boardService.boardInsert(board);
        return"redirect:/board/boardList";
    }
}


