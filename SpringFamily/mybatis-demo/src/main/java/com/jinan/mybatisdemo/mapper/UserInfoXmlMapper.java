package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface UserInfoXmlMapper {
    List<UserInfo> selectAll();

    UserInfo selectById(Integer id);

    List<UserInfo> selectByAgeAndGender(Integer age,Integer gender);

    Integer insertUser(UserInfo userInfo);

    Integer deleteUser(Integer id);

    void updateUser(String username,Integer id);



}
