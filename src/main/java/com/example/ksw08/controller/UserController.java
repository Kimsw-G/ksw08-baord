package com.example.ksw08.controller;

import com.example.ksw08.dao.UserDAO;
import com.example.ksw08.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String logingPage(@RequestParam("errMsg") String errMsg, Model model){
        model.addAttribute("errMsg",errMsg);
        return "/user/userLogin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginTry(HttpServletRequest request, RedirectAttributes redirect, UserVO paramVO){
        // get userInfo form uid
        UserVO result = userDAO.selectUser(paramVO);

        if(result==null){ // no id
            redirect.addAttribute("errMsg","NO ID!");
        } else if(upw.equals(result.getUpw())){
            System.out.println("success login!!");
            result.setUpw(null);
            HttpSession hs = request.getSession();
            hs.setAttribute("loginUser",result);
            return "forward:/board/list";
        } else {
            redirect.addAttribute("errMsg","WrongPW!");
        }
        System.out.println("fail login");
        return "redirect:login";

    }

}
