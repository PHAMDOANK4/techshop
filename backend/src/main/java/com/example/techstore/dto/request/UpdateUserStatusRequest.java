package com.example.techstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull
public class UpdateUserStatusRequest {
    @NotBlank(message = "Status is required")
    private String status; // ACTIVE, INACTIVE, BANNED
    private String reason; // Lý do (optional)
}