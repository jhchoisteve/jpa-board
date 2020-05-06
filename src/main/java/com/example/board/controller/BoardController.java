package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String List() {
        return "board/list.html";
    }

    @GetMapping("/post")
    public String Write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public  String write(BoardDto boardDto) {

        Long id = boardService.savePost(boardDto);
        System.out.println(id);

        return "redirect:/";
    }
}
