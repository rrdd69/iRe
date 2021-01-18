package cms.bbs.v1.service;

import cms.bbs.v1.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("TEST...")
                .content("TEST Contetn...")
                .writerEmail("user55@aaa.com")  //현재 데에터베이스에 존재하는 회원 이메일
                .build();

        Long bno = boardService.register(dto);
    }

}