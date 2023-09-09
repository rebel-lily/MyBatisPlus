package com.sqc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @ClassName Product
 * @Description
 * @Author Administrator
 * @Date 2023/9/9 9:56
 * @Version V1.0
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//乐观锁版本号注解
    private Integer version;

}
