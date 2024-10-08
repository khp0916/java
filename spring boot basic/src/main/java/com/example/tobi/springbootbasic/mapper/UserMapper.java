package com.example.tobi.springbootbasic.mapper;

import com.example.tobi.springbootbasic.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(long id);
    User deleteById(long id);
    void insertUser(User user);
}