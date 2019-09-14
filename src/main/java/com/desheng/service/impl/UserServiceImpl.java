package com.desheng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.desheng.mapper.UserMapper;
import com.desheng.pojo.User;
import com.desheng.pojo.UserExample;
import com.desheng.service.user.UserService;
import com.desheng.util.ResultMsg;

@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /*
     * (non-Javadoc)
     *
     * @see com.petroleum.service.impl.UserService#getUserLogin(java.lang.String,
     * java.lang.String)
     */
    @Override
    public User getUserLogin(String username, String password) {

        UserExample example = new UserExample();
        example.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
        User user = userMapper.selectByExampleOne(example);
        return user;

    }

    @Override
    public Map<String, Object> insertUser(User user) {
        int i = userMapper.insertSelective(user);
        if (i > 0) {
            return ResultMsg.success("注册成功");
        }
        return ResultMsg.failure("注册失败");

    }

    @Override
    public List<User> queryListUser() {
        List<User> list = userMapper.selectByExample(null);
        return list;
    }

    @Override
    public boolean queryIsUser(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        long count = userMapper.countByExample(example);
        if (count > 0) {
            return false;
        }
        return true;
    }

}
