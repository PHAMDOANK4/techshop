package com.example.techstore.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.techstore.service.AdminService;
import com.example.techstore.dto.reponse.ApiResponse;
import com.example.techstore.dto.reponse.RevenueResponse;
import com.example.techstore.dto.reponse.UserDetailDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor

public class AdminUserController {

    private final AdminService userService;

  
    @GetMapping("/{id}")
   public ResponseEntity<ApiResponse<List<UserDetailDto>>> getUserById(@PathVariable Integer id) {
        List<UserDetailDto> userDetail = userService.getUserById(id);
        ApiResponse<List<UserDetailDto>> response = ApiResponse.<List<UserDetailDto>>builder()
                .success(true)
                .message("User details retrieved successfully")
                .data(userDetail)
                .build();
        return ResponseEntity.ok(response);
    }


    // @PatchMapping("/{id}/status")
    // public ResponseEntity<Void> updateUserStatus(
    //     @PathVariable Long id,
    //     @RequestBody UserStatusRequest request
    // ) {
    //     userService.updateUserStatus(id, request.getIsActive() ? "activate" : "deactivate");
    //     return ResponseEntity.noContent().build();
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    //     userService.deleteUser(id);
    //     return ResponseEntity.noContent().build();
    // }
}