package com.sqc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import com.sqc.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName MybatisPlusWrapperTest
 * @Description
 * @Author Administrator
 * @Date 2023/9/5 19:48
 * @Version V1.0
 */
@SpringBootTest
public class MybatisPlusWrapperTest {
   @Autowired
    private UsersMapper usersMapper;

   @Test
    public void test01(){
       //查询用户名包括y,密码包括123，性别不为空的用户
       QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
       queryWrapper.like("user_name","y").like("password","123")
               .isNotNull("sex");
       List<Users> list = usersMapper.selectList(queryWrapper);
       list.forEach(System.out::println);

   }
}
