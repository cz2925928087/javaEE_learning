package com.jinan.springlibarydemo.mapper;

import com.jinan.springlibarydemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserInfoMapper {


    @Select("SELECT *FROM user_info WHERE user_name = #{userName} AND delete_flag = 0")
    UserInfo queryById(String userName);
}
