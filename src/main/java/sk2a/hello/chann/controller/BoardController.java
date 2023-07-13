package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;
import sk2a.hello.chann.service.PageService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;
    private final PageService pageService;

    @GetMapping("/board/{page}")
    public String showBoardList(
            Model model,
            @PathVariable int page,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String time
    ) {
        log.info("page={}, search={}, category={}, price={}, time={}", page, search, category, price, time);
        int pageSize = 4;
        Page<Board> boardPage = pageService.getBoardByPage(page, pageSize, search, category, price, time);

        model.addAttribute("boardPage", boardPage);
        return "board_list"; // Return the name of the Thymeleaf template
    }

    @ResponseBody
    @GetMapping("/api/board/{page}")
    public Page<Board> getBoardByPage(
            @PathVariable int page,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String time
    ) {
        int pageSize = 4;
        return pageService.getBoardByPage(page, pageSize, search, category, price, time);
    }
}
