package org.astro.aboard.controller;

import java.util.List;

import org.astro.aboard.dto.BoardDTO;
import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.PageResponseDTO;
import org.astro.aboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
@Log4j2
public class BoardController {
/////////////////////////////////////////////////////////////////////////////////////////////
    private final BoardService boardService;
    
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    // GET.
    // 리스트.
    @GetMapping("list")
    public void getList(PageRequestDTO pageRequestDTO, Model model) {

        //List<BoardDTO> list = boardService.getList();

        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.getList(pageRequestDTO);

        log.info("GET ||||| ----------LIST----------");

        //model.addAttribute("list", list);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
    }

    // 보기.
    @GetMapping("read/{bno}")
    public String getRead(@PathVariable("bno") int bno, Model model) {

        log.info("GET ||||| ----------READ----------");

        model.addAttribute("dto", boardService.getOne(bno));

        return "board/read";
    }

    // 등록.
    @GetMapping("regist")
    public void getRegist(BoardDTO boardDTO) {

        log.info("GET ||||| ----------REGIST----------");
    }

    // 수정.
    @GetMapping("modify/{bno}")
    public String getModify(@PathVariable("bno") int bno, Model model) {

        log.info("GET ||||| ----------MODIFY----------");

        model.addAttribute("dto", boardService.getOne(bno));

        return "board/modify";
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    // POST.
    // 등록.
    @PostMapping("/regist")
    public String postRegist(BoardDTO boardDTO) {

        log.info("POST ||||| ----------REGIST----------");

        boardService.insertOne(boardDTO);

        return "redirect:/board/list";
    }

    // 삭제.
    @PostMapping("delete/{bno}")
    public String postDelete(@PathVariable("bno") int bno) {

        log.info("POST ||||| ----------DELETE----------");

        boardService.deleteOne(bno);

        return "redirect:/board/list";
    }

    // 수정.
    @PostMapping("/modify/{bno}")
    public String postModify(@PathVariable("bno") int bno, BoardDTO boardDTO) {

        log.info("POST ||||| ----------MODIFY----------");

        boardService.modifyOne(boardDTO);

        return "redirect:/board/read/" + bno;
    }
    
}
