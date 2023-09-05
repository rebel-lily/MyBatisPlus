package com.sqc.mybatisplus.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqc.mybatisplus.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description
 * @Author Administrator
 * @Date 2023/8/26 18:29
 * @Version V1.0
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Map<String,Object> selectMapById(Long id);
}
