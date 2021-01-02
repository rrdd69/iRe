package cms.bbs.v1.service;

import cms.bbs.v1.dto.GuestbookDTO;
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

}