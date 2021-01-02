package cms.bbs.v1.service;

import cms.bbs.v1.dto.GuestbookDTO;
import cms.bbs.v1.entity.Guestbook;

public interface GuestbookService {


    Long register(GuestbookDTO dto);

    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }
}
