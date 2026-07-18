package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select  * from user_info")
    List<UserInfo> selectAll();

    @Select("select * from user_info where id = #{id}")
    UserInfo selectById(Integer id);

    @Select("select * from user_info where age = #{age} and gender = #{gender}")
    List<UserInfo> selectByAgeAndGender(Integer age,Integer gender);

    //插入
    @Insert("insert INTO user_info(username,`password`,age,gender) VALUES (#{username},#{password},#{age},#{gender})")
    Integer insertUser(UserInfo userInfo);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert INTO user_info(username,`password`,age,gender) VALUES (#{username},#{password},#{age},#{gender})")
    Integer insertUser2(UserInfo userInfo);

    @Insert("insert into user_info (username, `password`, age, gender) " +
            "values (#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender})")
    Integer insertUser3(@Param("userInfo") UserInfo userInfo);


    @Delete("delete from user_info where id = #{id}")
    Integer deleteUser(Integer id);


    @Update("update user_info set username=#{username} where id = #{id}")
    void updateUser(String username,Integer id);

}
