package cms.bbs.v1.repository;

import cms.bbs.v1.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void textClass(){

        System.out.println("#########################");
        System.out.println(memoRepository.getClass().getName());
        System.out.println("#########################");

    }

    @Test
    public void 더미데이터_입력_테스트(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void 단건조회_테스트(){

        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("==================================");
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println("memo = " + memo);
        }
    }


    @Test
    public void 수정작업_테스트(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));

    }

    @Test
    public void 삭제작업_테스트(){

        memoRepository.deleteById(100L);

    }



}