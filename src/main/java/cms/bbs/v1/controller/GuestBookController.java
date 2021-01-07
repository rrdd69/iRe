package cms.bbs.v1.controller;

import cms.bbs.v1.dto.GuestbookDTO;
import cms.bbs.v1.dto.PageRequestDTO;
import cms.bbs.v1.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor // 자동 주입을 위한 Anotation
public class GuestBookController {

    private final GuestbookService service;

    @GetMapping({"/"})
    public String index(){
        return "redirect:/guestbook/list";
    }

    /*
    * 리스트 출력
    * */
    @GetMapping({"/list"})
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("#############################"+pageRequestDTO);
        model.addAttribute("result", service.getLsit(pageRequestDTO));
    }

    /**
     * 데이터 등록
     */
    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }

    /*
    * 실제 등록
    * */
    @PostMapping("/register")
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..."+ dto);

        //새로 추가된 엔티티의 번호
        Long gno = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", gno);

        return "redirect:/guestbook/list";
    }


    @GetMapping("/read")
    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("gno" + gno);
        GuestbookDTO dto = service.read(gno);
        model.addAttribute("dto",dto);
    }
}
