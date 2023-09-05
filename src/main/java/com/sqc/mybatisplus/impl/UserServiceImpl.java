package com.sqc.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import com.sqc.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Administrator
 * @Date 2023/9/5 9:20
 * @Version V1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserService {

}
