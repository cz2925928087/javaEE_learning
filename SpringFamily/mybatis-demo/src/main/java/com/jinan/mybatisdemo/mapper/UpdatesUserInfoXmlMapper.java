package com.jinan.mybatisdemo.mapper;

import com.jinan.mybatisdemo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdatesUserInfoXmlMapper {
    Integer insertUserByCondition(UserInfo userInfo);

    List<UserInfo> queryByCondition();
}
