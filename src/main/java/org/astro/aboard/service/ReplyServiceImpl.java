package org.astro.aboard.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.PageResponseDTO;
import org.astro.aboard.dto.ReplyDTO;
import org.astro.aboard.mappers.BoardMapper;
import org.astro.aboard.mappers.ReplyMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;
    private final BoardMapper boardMapper;
    
    
    @Override
    public PageResponseDTO<ReplyDTO> replyList(PageRequestDTO pageRequestDTO, long bno) {
        
        pageRequestDTO.setSize(10);

        List<ReplyDTO> list = replyMapper.replyList(pageRequestDTO, bno);

        int total = replyMapper.total(bno);

        return PageResponseDTO.<ReplyDTO>withAll().list(list).total(total).build();
    }


    @Override
    public Long insertReply(ReplyDTO replyDTO) {
        
        Long result = null;
        Long gno = replyDTO.getGno();

        if(gno == 0L) {
            int count = replyMapper.insertReply(replyDTO);

            if(count != 1) {
                throw new RuntimeErrorException("ERROR!!!!!!!!!!");
            }
            Long rno = replyDTO.getRno();
            replyMapper.up
        }
    }
    
}
