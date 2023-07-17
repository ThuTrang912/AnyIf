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

    @GetMapping("/board/{page}")
    public String showBoardList(
            Model model,
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
            // Xử lý khi giá trị "page" không phải là một số nguyên hợp lệ
            // Ví dụ: Hiển thị thông báo lỗi hoặc chuyển hướng đến trang 404
            return "error"; // Thay thế bằng tên view và logic xử lý của bạn
        }

        log.info("page={}, search={}, category={}, price={}, time={}", pageNumber, search, category, price, time);
        int pageSize = 4;
        Page<Board> boardPage = pageService.getBoardByPage(pageNumber, pageSize, search, category, price, time);

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
            // Xử lý khi giá trị "page" không phải là một số nguyên hợp lệ
            // Ví dụ: Trả về một trang rỗng hoặc trả về lỗi JSON
            return new Page<>(); // Thay thế bằng giá trị phù hợp trong trường hợp của bạn
        }

        int pageSize = 4;
        return pageService.getBoardByPage(pageNumber, pageSize, search, category, price, time);
    }
}
