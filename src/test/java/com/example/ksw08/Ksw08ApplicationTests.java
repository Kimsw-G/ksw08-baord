package com.example.ksw08;

import com.example.ksw08.dao.UserDAO;
import com.example.ksw08.vo.UserVO;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ksw08ApplicationTests {

    @Autowired
    UserDAO userDAO;

    @Test
    void contextLoads() {
        UserVO userVO = new UserVO();
        userVO.setUid("kimsw");
        UserVO imsiVO = userDAO.selectUser(userVO);
        System.out.println(imsiVO.getUid());
    }

}
