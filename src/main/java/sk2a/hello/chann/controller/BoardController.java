package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;
import sk2a.hello.chann.service.PageService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final PageService pageService;

    @GetMapping("/board")
    public String showBoardList(
            Model model,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String time,
            @RequestParam(required = false, defaultValue = "1") int page // Add default value for the page parameter
    ) {
        int pageSize = 3;
        Page<Board> boardPage = pageService.getBoardByPage(page, pageSize, search, category, price, time);

        model.addAttribute("boardPage", boardPage);
        return "Product_List";
    }


    @ResponseBody
    @GetMapping("/api/board/{page}")
    public Page<Board> getBoardByPage(
            @PathVariable String page,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String time
    ) {
        int pageNumber;
        try {
            pageNumber = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            return new Page<>();
        }

        int pageSize = 3;
        return pageService.getBoardByPage(pageNumber, pageSize, search, category, price, time);
    }
}
