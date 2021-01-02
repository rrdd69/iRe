package cms.bbs.v1.service;

import cms.bbs.v1.dto.GuestbookDTO;
import cms.bbs.v1.entity.Guestbook;
import cms.bbs.v1.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor //의존성 자동 주입
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO####################################");
        log.info(dto);
        log.info("DTO####################################");

        Guestbook entity = dtoToEntity(dto);

        log.info("entity####################################");
        log.info(entity);
        log.info("entity####################################");

        repository.save(entity);

        return entity.getGno();
    }
}
