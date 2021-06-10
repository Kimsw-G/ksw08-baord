package com.example.ksw08.dao;

import com.example.ksw08.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository(value="userDAO")
public interface UserDAO {

    UserVO selectUser(UserVO param);
}
