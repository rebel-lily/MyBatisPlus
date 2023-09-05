package com.sqc.mybatisplus;

import com.sqc.mybatisplus.pojo.Users;
import com.sqc.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyBatisPlusService
 * @Description
 * @Author Administrator
 * @Date 2023/9/5 9:23
 * @Version V1.0
 */
@SpringBootTest
public class MyBatisPlusService {
    @Autowired
    //自动注入
    private UserService userService;

    @Test
    public void test01(){
        //查询总计录数
        long count = userService.count();
        System.out.println("总记录数:" + count);
    }

    @Test
    public void test02(){
        //批量添加
        List<Users> list = new ArrayList<>();
        for (int i = 1;i <= 6;i++){
            Users user = new Users();
            user.setName("ybc" + i);
            user.setPassword("123" + i);
            if (i % 2 == 0){
                user.setSex("男");
            }else {
                user.setSex("女");
            }
            list.add(user);
        }
        userService.saveBatch(list);
    }

}
