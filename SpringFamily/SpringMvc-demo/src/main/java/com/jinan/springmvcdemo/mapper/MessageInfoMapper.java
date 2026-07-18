package com.jinan.springmvcdemo.mapper;

import com.jinan.springmvcdemo.entity.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface MessageInfoMapper {

    @Insert("insert into message_info(`from`,`to`,`message`) values (#{from},#{to},#{message})")
    Integer insertMessage(MessageInfo messageInfo);

    @Select("select `id`, `from`, `to`, `message` from message_info where delete_flag=0")
    List<MessageInfo> queryAll();
}
