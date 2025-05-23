package com.example.techstore.service;

import com.example.techstore.dto.reponse.UserDetailDto;
import com.example.techstore.dto.reponse.UserResponseDto;
import com.example.techstore.repository.RoleRepository;
import com.example.techstore.repository.UserRepository;

import java.util.List;

import com.example.techstore.dto.reponse.PageResponse;

public interface AdminService {

   PageResponse<UserResponseDto> getAllUsers(int page, int size, String sortBy, 
                                                   String sortDir, String search, 
                                                   String status, String role);

    List<UserDetailDto>  getUserById(Integer id);
    public void updateUserStatus(Long id, String status);
    public void deleteUser(Long id);

}
