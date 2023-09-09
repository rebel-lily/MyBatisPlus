package com.sqc.mybatisplus;

import com.sqc.mybatisplus.enums.sexEnum;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName MybatisplusEnum
 * @Description
 * @Author Administrator
 * @Date 2023/9/9 10:47
 * @Version V1.0
 */
@SpringBootTest
public class MybatisplusEnum {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test1(){
        //通用枚举类
        Users users = new Users();
        users.setName("小李");
        users.setPassword("1234");
        users.setSex(sexEnum.FEMALE);
        System.out.println(users);
    }
}
