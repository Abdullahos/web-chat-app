package com.udacity.jwdnd.spring_security_basics.mapper;

import com.udacity.jwdnd.spring_security_basics.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper {

        @Select("select * FROM MESSAGES WHERE messageid = #{messageid}")
        Message getMessage(Integer messageid);  //as username can be not unique for each message.

        @Select("select * from MESSAGES")
        List<Message> getAllMessages();

        @Select("select username from MESSAGES")
        List<String> getUsername();

        @Insert("insert INTO MESSAGES (username, messagetext) VALUES (#{username}, #{messagetext} ) ")
        @Options(useGeneratedKeys = true,keyProperty = "messageid")
        Integer insert(Message message);
}
