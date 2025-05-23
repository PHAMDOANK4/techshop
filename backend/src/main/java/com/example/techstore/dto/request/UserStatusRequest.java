package com.example.techstore.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class UserStatusRequest {
    @NotNull
    private Boolean isActive;
}
