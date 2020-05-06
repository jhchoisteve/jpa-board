package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String Hello() {
        return "hello unittest";
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
