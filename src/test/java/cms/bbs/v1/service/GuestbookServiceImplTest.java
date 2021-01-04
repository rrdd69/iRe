package cms.bbs.v1.service;

import cms.bbs.v1.dto.GuestbookDTO;
import cms.bbs.v1.dto.PageRequestDTO;
import cms.bbs.v1.dto.PageResultDTO;
import cms.bbs.v1.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceImplTest {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister(){

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println("service = " + service.register(guestbookDTO));
    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getLsit(pageRequestDTO);

        System.out.println("PREV:" + resultDTO.isPrev());
        System.out.println("NEXT:" + resultDTO.isNext());
        System.out.println("TOTAL:" + resultDTO.getTotalPage());

        System.out.println("###############################################");
        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println("guestbookDTO = " + guestbookDTO);
        }
        System.out.println("###############################################");
        System.out.println("###############################################");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

}