package com.sqc.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName MyBatisPlusPlugingsTest
 * @Description
 * @Author Administrator
 * @Date 2023/9/7 10:16
 * @Version V1.0
 */
@SpringBootTest
public class MyBatisPlusPlugingsTest {
    @Autowired
    private UsersMapper usersMapper;

   @Test
    public void testPage(){
       Page<Users> page = new Page<>(1,3);
       usersMapper.selectPage(page,null);
       System.out.println(page);
   }
}
