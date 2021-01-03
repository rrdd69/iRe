package cms.bbs.v1.service;

import cms.bbs.v1.dto.GuestbookDTO;
import cms.bbs.v1.dto.PageRequestDTO;
import cms.bbs.v1.dto.PageResultDTO;
import cms.bbs.v1.entity.Guestbook;

public interface GuestbookService {


    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO, Guestbook> getLsit(PageRequestDTO requestDTO);


    default Guestbook dtoToEntity(GuestbookDTO dto){ //DTO --> ENTITY
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }

    default GuestbookDTO EntityToDto(Guestbook entity){ //ENTITY --> DTO
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .moddate(entity.getModDate())
                .build();

        return dto;
    }
}
