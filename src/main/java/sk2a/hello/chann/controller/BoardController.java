package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sk2a.hello.chann.dao.BoardDao;
import sk2a.hello.chann.domain.Board;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;

    @ResponseBody
    @RequestMapping(value = "/board/list", method= RequestMethod.GET)
    public List<Board> getAllBoards(Model model){
        log.info("board list");
        List<Board> board = boardDao.getAllBoards();
        return board;
    }

//    @ResponseBody
//    @RequestMapping(value = "/board/search", method= RequestMethod.POST)
//    public List<Board> getSearchBoards(@RequestParam String search){
//        log.info("board search={}", search);
//        List<Board> board = boardDao.getSearchBoards(search);
//        return board;
//    }



}
