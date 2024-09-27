package com.example.tobi.springbootbasic.service;

import com.example.tobi.springbootbasic.dto.MemberListResponseDTO;
import com.example.tobi.springbootbasic.mapper.UserMapper;
import com.example.tobi.springbootbasic.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<MemberListResponseDTO> findAll() {
        List<User> users = userMapper.findAll();

        // Java Stream & Lambda
        return users.stream()
                .map(User::toMemberListResponseDTO)
                .collect(Collectors.toList());
    }

}
