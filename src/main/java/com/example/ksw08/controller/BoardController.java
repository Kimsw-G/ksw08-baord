package com.example.ksw08.controller;

import com.example.ksw08.dao.BoardDAO;
import com.example.ksw08.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    BoardDAO boardDAO;

    @RequestMapping(value="/list")
    public String boardList(Model model, HttpSession session){
        if(session.getAttribute("loginUser")==null){
            return "redirect:/user/list";
        }

        model.addAttribute("list",boardDAO.selectBoardList());
        return "/board/boardList";
    }

    @RequestMapping(value = "/detail")
    public String boardDetail(Model model,HttpSession session,
            BoardVO param){
        // 이 param은 어디서 오는걸까?
        // => parameter값을 읽어, 일치하는 VO의 내용이 있으면 자동으로 할당한다?
        System.out.println(param.getIboard());

        //게시글 정보를 등재
        model.addAttribute("data",boardDAO.selectBoard(param));

        return "/board/boardDetail";
    }
}
