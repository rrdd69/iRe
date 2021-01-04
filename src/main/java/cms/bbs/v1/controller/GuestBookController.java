package cms.bbs.v1.controller;

import cms.bbs.v1.dto.PageRequestDTO;
import cms.bbs.v1.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping({"/list"})
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("#############################"+pageRequestDTO);
        model.addAttribute("result", service.getLsit(pageRequestDTO));

    }
}
