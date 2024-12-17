package com.deepak.sharma.securenotes.service.implementations;

import com.deepak.sharma.securenotes.dtos.UserDTO;
import com.deepak.sharma.securenotes.enums.AppRole;
import com.deepak.sharma.securenotes.mapper.UserMapper;
import com.deepak.sharma.securenotes.model.Role;
import com.deepak.sharma.securenotes.model.User;
import com.deepak.sharma.securenotes.repository.RoleRepository;
import com.deepak.sharma.securenotes.repository.UserRepository;
import com.deepak.sharma.securenotes.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAllUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(UserMapper.userToUserDTO(user));
        }
        return userDTOS;
    }

    @Override
    public String updateRole(Long userId, String roleName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        AppRole role = AppRole.valueOf(roleName);
        Role newRole = roleRepository.findByRoleName(role).orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(newRole);
        userRepository.save(user);

        return "Role updated successfully";
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.userToUserDTO(user);
    }
}
