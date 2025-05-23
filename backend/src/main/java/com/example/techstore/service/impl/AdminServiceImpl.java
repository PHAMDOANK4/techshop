package com.example.techstore.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import com.example.techstore.dto.reponse.PageResponse;
import com.example.techstore.dto.reponse.UserDetailDto;
import com.example.techstore.dto.reponse.UserResponseDto;

import com.example.techstore.repository.RoleRepository;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.service.AdminService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final UserRepository userRepository;
 
    @Override
    public PageResponse<UserResponseDto> getAllUsers(int page, int size, String sortBy, String sortDir, String search,
            String status, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public List<UserDetailDto> getUserById(Integer id) {
        // TODO Auto-generated method stub
      
        List<Object[]> result = userRepository.getInfoOneUser(id);
        
        
        
        return convertToUserDetailDto(result);
        
    }
    


    @Override
    public void updateUserStatus(Long id, String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserStatus'");
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
    private List<UserDetailDto> convertToUserDetailDto(List<Object[]> results) {
        List<UserDetailDto> response = new ArrayList<>();
        for(Object[] result : results){
            Long id = ((Number) result[0]).longValue();
            String name = (String) result[1];
            LocalDate dateOfBirth = LocalDate.parse((String) result[2]);
            String email = (String) result[3];
            String phone = (String) result[4];
            String address = (String) result[5];
            String roleName = (String) result[6];
            Integer isActive = (Integer) result[7];
            LocalDateTime createdAt = (LocalDateTime) result[8];
        UserDetailDto userDetail = new UserDetailDto(id,name, dateOfBirth,email,phone,address,roleName,isActive,createdAt);
            
            response.add(userDetail);
        }
       
        return response;
    }
}
