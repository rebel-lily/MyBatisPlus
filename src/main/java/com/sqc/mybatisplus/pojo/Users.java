package com.sqc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.sqc.mybatisplus.enums.sexEnum;
import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author Administrator
 * @Date 2023/8/26 18:29
 * @Version V1.0
 */
@Data
@TableName("t_user")
public class Users {
   @TableId(value = "uid",type = IdType.AUTO)
   //将属性所对应的字段指定为主键
   private long id;
   //指定所对应的字段名
   @TableField("user_name")
   private String name;
   private String password;
   private sexEnum sex;
   //逻辑删除注解
   @TableLogic
   private String isDelete;
}
