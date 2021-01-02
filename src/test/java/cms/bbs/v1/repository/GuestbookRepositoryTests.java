package cms.bbs.v1.repository;

import cms.bbs.v1.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {


    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i ->{
            Guestbook guestbook = Guestbook.builder()
                .title("Title..."+ i)
                .writer("user"+(i%10))
                .content("Content..."+i)
                .build();
            System.out.println(guestbookRepository.save(guestbook));
        });

    }
}