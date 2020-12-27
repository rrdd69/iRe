package cms.bbs.v1.repository;

import cms.bbs.v1.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Test
    public void 페이징_테스트(){

        Sort sort1 = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(9,10,sort1);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println("result = " + result);
        System.out.println("===========================================");

        System.out.println("총 몇 페이지 = " + result.getTotalPages()); // 총 몇 페이지
        System.out.println("전체 개수" + result.getTotalElements()); //전체 개수
        System.out.println("현재 페이지 번호" + result.getNumber()); //현재 페이지 번호 (0부터 시작)
        System.out.println("페이지당 데이터 개수" + result.getSize()); //페이지당 데이터 개수
        System.out.println("다음 페이지 존재 여부" + result.hasNext()); // 다음 페이지 존재 여부
        System.out.println("시작 페이지(0) 여부"+ result.isFirst()); //시작 페이지(0) 여부

        System.out.println("===========================================");
        List<Memo> list = result.getContent();
        for(Memo memo: list){
            System.out.println("memo = " + memo);
        }
        /*java 8 */
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        list.forEach(System.out::println);



    }


    @Test
    public void testQueryMethod(){
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
        list.forEach(System.out::println);
    }

    @Test
    public void testQueryMethodWithPagable(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(memo -> System.out.println(memo));
    }

    @Commit
    @Transactional
    @Test
    public void 삭제_테스트(){
        /*실무에서 잘 안쓰는 방법 */
        memoRepository.deleteMemoByMnoLessThan(10L);
    }



}