package com.sqc.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqc.mybatisplus.mapper.ProductMapper;
import com.sqc.mybatisplus.mapper.UsersMapper;
import com.sqc.mybatisplus.pojo.Product;
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
    @Autowired
    private ProductMapper productMapper;

   @Test
    public void testPage(){
       Page<Users> page = new Page<>(2,3);
       usersMapper.selectPage(page,null);
       //getPages()返回页数
       System.out.println(page.getPages());
       //getRecords()返回有多少条记录数
       System.out.println(page.getRecords());
       System.out.println(page.getTotal());
       //hasNext()是否有下一页
       System.out.println(page.hasNext());
       //hasPrevious()是否有上一页
       System.out.println(page.hasPrevious());
   }

   @Test
    public void testPageVo(){
       Page<Users> page = new Page<>(1,3);
       usersMapper.selectPageVo(page,"女");
       //getPages()返回页数
       System.out.println(page.getPages());
       //getRecords()返回有多少条记录数
       System.out.println(page.getRecords());
       System.out.println(page.getTotal());
       //hasNext()是否有下一页
       System.out.println(page.hasNext());
       //hasPrevious()是否有上一页
       System.out.println(page.hasPrevious());
   }

   @Test
   public void ProductTest(){
     //小李查询的价格
     Product productLi = productMapper.selectById(1);
     System.out.println("小李查询价格" + productLi.getPrice());
      //小王查询的价格
      Product productWa = productMapper.selectById(1);
      System.out.println("小王查询价格" + productLi.getPrice());
      //小李将商品加50
      productLi.setPrice(productLi.getPrice()+50);
      productMapper.updateById(productLi);
      //小王将商品减30
      productWa.setPrice(productWa.getPrice()-30);
      productMapper.updateById(productWa);
      int result = productMapper.updateById(productWa);
      if (result == 0){
          //操作失败重试
          Product productNew = productMapper.selectById(1);
          productNew.setPrice(productNew.getPrice()-30);
          productMapper.updateById(productNew);
      }

      Product productBoss = productMapper.selectById(1);
      System.out.println("老板查询价格" + productBoss.getPrice());
   }
}
