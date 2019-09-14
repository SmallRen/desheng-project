package com.desheng.service.user;

import java.util.List;
import java.util.Map;

import com.desheng.pojo.User;

public interface UserService {

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    User getUserLogin(String username, String password);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    Map<String, Object> insertUser(User user);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<User> queryListUser();

    /**
     *
     * @param username
     * @return
     */
    boolean queryIsUser(String username);
}