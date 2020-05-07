package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String List(Model model)
    {
        List<BoardDto> boardDtoList = boardService.getBoardlist();
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }

    @GetMapping("/post")
    public String Write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {

        Long id = boardService.savePost(boardDto);
        System.out.println(id);

        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }
}
