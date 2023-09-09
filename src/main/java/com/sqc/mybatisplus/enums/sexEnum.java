package com.sqc.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @ClassName sexEnum
 * @Description
 * @Author Administrator
 * @Date 2023/9/9 10:39
 * @Version V1.0
 */
@Getter
public enum sexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private Integer sex;
    private String sexName;

    sexEnum(Integer sex,String sexName){
        this.sex = sex;
        this.sexName = sexName;
    }
}
