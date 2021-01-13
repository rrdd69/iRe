package cms.bbs.v1.repository;

import cms.bbs.v1.entity.Board;
import cms.bbs.v1.entity.Member;
import cms.bbs.v1.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember(){

        IntStream.rangeClosed(1,100).forEach(i->{

            Member member = Member.builder()
                    .email("user"+i+"@aaa.com")
                    .password("1111")
                    .name("USER"+i)
                    .build();

            memberRepository.save(member);

        });

    }

    @Transactional
    @Test
    public void testMember1(){

        Optional<Member> result = memberRepository.findByEmail("user71@aaa.com");

        Member member = result.get();

        System.out.println("board = " + member);
        /*
        for(Board board : member.getBoardList())
        {
            System.out.println("board = " + board);
            for(Reply reply : board.getReplyList()){
                System.out.println("###############");
                System.out.println("reply = " + reply);
                System.out.println("###############");
            }

        }
        */
    }

}

