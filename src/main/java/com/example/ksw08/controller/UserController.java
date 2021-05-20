package com.example.ksw08.controller;

import com.example.ksw08.dao.UserDAO;
import com.example.ksw08.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
    public String loginPage(Model model,
                            @RequestParam(value = "errMsg",required = false)String errMsg){
        model.addAttribute("errMsg",errMsg);

        return "/user/userLogin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginTry(HttpServletRequest request, Model model, UserVO paramVO){
        // get userInfo form uid
        UserVO result = userDAO.selectUser(paramVO);

        if(result==null){ // no id
            return "redirect:login?errMsg=NO ID!";
        } else if(paramVO.getUpw().equals(result.getUpw())){
            System.out.println("success login!!");
            result.setUpw(null);
            HttpSession hs = request.getSession();
            hs.setAttribute("loginUser",result);
            return "forward:/board/list";
        } else {
            return "redirect:login?errMsg=WrongPW";
        }

    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

}
