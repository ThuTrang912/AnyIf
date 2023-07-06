package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;
import sk2a.hello.chann.pagination.Page;
import sk2a.hello.chann.service.BoardService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;
    private final BoardService boardService;

    @ResponseBody
    @GetMapping("/board/list")
    public List<Board> getAllBoards(Model model){
        log.info("board list");
        List<Board> board = boardDao.getAllBoards();
        return board;
    }

    @ResponseBody
    @PostMapping("/board/search")
    public List<Board> getBoardsBySearch(@RequestParam String search){
        log.info("board search={}", search);
        List<Board> board = boardDao.getBoardsBySearch(search);
        return board;
    }

    @GetMapping("/board/{page}")
    public String showBoardList(Model model, @PathVariable int page) {
        log.info("page={}" , page);
        int pageSize = 2;
        Page<Board> boardPage = boardService.getBoardByPage(page, pageSize);

        model.addAttribute("boardPage", boardPage);
        return "board_page";
    }
}
