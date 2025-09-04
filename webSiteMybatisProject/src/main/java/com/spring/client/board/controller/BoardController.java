package com.spring.client.board.controller;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/board/boardList";
    }

    @GetMapping("/{boardNumber}")
    public String boardDetail(@PathVariable int boardNumber, Model model){
        Board detail = boardService.boardDetail(boardNumber);
        model.addAttribute("detail", detail);
        return "client/board/boardDetail";
    }

    @GetMapping(value="/updateForm")
    public String updateForm(@ModelAttribute Board board, Model model){
        Board updateData = boardService.updateForm(board.getBoardNumber());
        model.addAttribute("updateData", updateData);
        return "client/board/updateForm";
    }

    /* 글수정 구현하기
    @param : Board
    참고 : RedirectAttributes 객체는 리다이렉트 시점(return "redirect:/경로")에
    한번만 사용되는 데이터를 전송할 수 있는 addFlashAttribute()라는 기능을 지원한다.
    addFlashAttribute() 메서드는 브라우저까지 전송되기는 하지만,
    URI상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
     */

    @PostMapping("/boardUpdate")
    public String boardUpdate(@ModelAttribute Board board){
        boardService.boardUpdate(board);
        return "redirect:/board/"+board.getBoardNumber();
    }

    @PostMapping(value="/boardDelete")
    public String boardDelete(@ModelAttribute Board board){
        boardService.boardDelete(board.getBoardNumber());
        return "redirect:/board/boardList";
    }
}


