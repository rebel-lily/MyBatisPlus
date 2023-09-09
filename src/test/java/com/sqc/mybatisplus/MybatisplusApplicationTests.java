package com.sqc.mybatisplus;

import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import org.apache.catalina.User;
import org.apache.tomcat.util.buf.UEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusApplicationTests {

   @Autowired
    private UsersMapper usersMapper;

   @Test
    public void test(){
       List<Users> list = usersMapper.selectList(null);
       System.out.println(list);
   }

//   @Test
//   //添加功能
//    public void test02(){
//       Users users = new Users();
//       users.setName("luck");
//       users.setPassword("200816");
//       users.setSex("女");
//       int result = usersMapper.insert(users);
//       System.out.println("result:" + result);
//   }

   @Test
    public void test03(){
//       通过id删除
//       int result = usersMapper.deleteById(4);
//       System.out.println(result);

       //通过map集合删除
//       Map<String,Object> map = new HashMap<>();
//       map.put("name","lili");
//       map.put("sex","女");
//       int result = usersMapper.deleteByMap(map);
//       System.out.println(result);

       //批量删除
       List<Long> list = Arrays.asList(7L,8L);
       int result = usersMapper.deleteBatchIds(list);
       System.out.println(result);
   }

//   @Test
//    public void test04(){
//       Users users = new Users();
//       users.setId(7L);
//       users.setPassword("happy");
//       users.setSex("男");
//       int result = usersMapper.updateById(users);
//       System.out.println(result);
//   }

   @Test
   public void test05(){
      //通过ID查询数据
//      Users users = usersMapper.selectById(7L);
//      System.out.println(users);

      //根据多个ID查询数据
//      List<Long> list = Arrays.asList(7L,8L,12L);
//      List<Users> users = usersMapper.selectBatchIds(list);
//      users.forEach(System.out::println);

//      查询所有数据
      List<Users> users = usersMapper.selectList(null);
      users.forEach(System.out::println);

//      Map<String,Object> map = usersMapper.selectMapById(7L);
//      System.out.println(map);

   }
}
