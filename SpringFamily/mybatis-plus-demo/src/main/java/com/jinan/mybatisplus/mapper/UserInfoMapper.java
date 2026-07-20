package com.jinan.mybatisplus.mapper;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.jinan.mybatisplus.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select id,username,password,age from user_info where age = #{age} and username like #{username}")
    List<UserInfo> queryUserInfoList(Integer age,String username);


    @Select("select id,username,password,age from user_info ${ew.customSqlSegment}")
    List<UserInfo> queryUserInfoList2(@Param(Constants.WRAPPER) QueryWrapper wrappers);



    List<UserInfo> queryUserInfoList3(@Param(Constants.WRAPPER) QueryWrapper<UserInfo> wrapper);

    @Update("update user_info set age = age + #{addAge}  ${ew.customSqlSegment}")
    void updateUserInfo(@Param("addAge") int addAge, @Param(Constants.WRAPPER)UpdateWrapper wrapper);
}
