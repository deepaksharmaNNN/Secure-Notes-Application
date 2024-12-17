package com.deepak.sharma.securenotes.service.interfaces;

import com.deepak.sharma.securenotes.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUsers();

    String updateRole(Long userId, String roleName);

    UserDTO getUserById(Long userId);
}
