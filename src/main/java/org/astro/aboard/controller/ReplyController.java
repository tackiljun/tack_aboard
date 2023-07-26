package org.astro.aboard.controller;

import java.util.Map;

import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.PageResponseDTO;
import org.astro.aboard.dto.ReplyDTO;
import org.astro.aboard.service.ReplyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 의존성 주입.
    private final ReplyService replyService;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 리스트. 
    @GetMapping("{bno}/list")
    public PageResponseDTO<ReplyDTO> getRpList(@PathVariable("bno") long bno, PageRequestDTO pageRequestDTO) {

        return replyService.replyList(pageRequestDTO, bno);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 보기.
    @GetMapping("{rno}")
    public ReplyDTO readRp(@PathVariable("rno") long rno) {
        ReplyDTO replyDTO = replyService.readReply(rno);

        return replyDTO;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 등록.
    @PostMapping("{bno}/new")
    public Map<String, Long> insertRp(@PathVariable("bno") long bno, @RequestBody ReplyDTO replyDTO) {
        
        replyDTO.setBno(bno);

        Long rno = replyService.insertReply(replyDTO);

        return Map.of("RESULT", rno);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // 삭제.
    @DeleteMapping("{rno}")
    public Map<String, Integer> deleteRp(@PathVariable("rno") long rno) {

        int result = replyService.deleteReply(rno);

        return Map.of("RESULT", result);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // 수정.
    @PutMapping("modify")
    public Map<String, Integer> modifyRp(@RequestBody ReplyDTO replyDTO) {

        int result = replyService.modifyReply(replyDTO);

        return Map.of("RESULT", result);
    }

}
