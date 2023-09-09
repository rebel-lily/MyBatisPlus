package com.sqc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Users;
import com.sqc.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

   @Test
    public void test02(){
       //查询用户根据用户名降序和id升序
       QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
       queryWrapper.orderByDesc("user_name").orderByAsc("uid");
       List<Users> list = usersMapper.selectList(queryWrapper);
       list.forEach(System.out::println);
   }

   @Test
    public void test03(){
       //删除用户名称为null的数据
       QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
       queryWrapper.isNull("user_name");
       int result = usersMapper.delete(queryWrapper);
       System.out.println("result:" + result);
   }

//   @Test
//    public void test04(){
//       //将用户名含有ybc或性别为女的用户信息修改
//       QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
//       queryWrapper.like("user_name","ybc").or().like("sex","男");
//       Users user = new Users();
//       user.setName("see");
//       user.setSex("女");
//       int result = usersMapper.update(user,queryWrapper);
//       System.out.println(result);
//   }

//   @Test
//    public void test05(){
//       //优先级
//       QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
//       queryWrapper.like("user_name","u").and(i->i.like("sex","女").or().isNull("password"));
//       Users user = new Users();
//       user.setName("lucky");
//       user.setSex("男");
//       int result = usersMapper.update(user,queryWrapper);
//       System.out.println(result);
//   }

   @Test
   public void test06(){
      //组装select字句
      QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
      queryWrapper.select("user_name","password");
      List<Map<String,Object>> list = usersMapper.selectMaps(queryWrapper);
      list.forEach(System.out::println);
   }

   @Test
   public void test07(){
      //子查询
      QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
      queryWrapper.inSql("uid","select uid from t_user where uid<10");
      List<Users> list = usersMapper.selectList(queryWrapper);
      list.forEach(System.out::println);
   }

   @Test
   public void test08(){
      //使用UpdateWrapper修改数据
      UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
      updateWrapper.like("user_name","see");
      updateWrapper.set("user_name","saw");
      int result = usersMapper.update(null,updateWrapper);
      System.out.println(result);
   }

   @Test
   public void test09(){
      //condition条件组装
      String username = "a";
      String password = "123";
      QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
      queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
              .like(StringUtils.isNotBlank(password),"password",password);
      List<Users> list = usersMapper.selectList(queryWrapper);
      list.forEach(System.out::println);
   }

   @Test
   public void test10(){
      //使用lambda后要用函数式接口，例如Users::getName
      String username = "a";
      String password = "123";
      LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
      queryWrapper.like(StringUtils.isNotBlank(username),Users::getName,username)
              .like(StringUtils.isNotBlank(password),Users::getPassword,password);
      List<Users> list = usersMapper.selectList(queryWrapper);
      list.forEach(System.out::println);
   }
}
