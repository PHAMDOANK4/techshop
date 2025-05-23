package com.example.techstore.controller;
import com.example.techstore.dto.reponse.ApiResponse;
import com.example.techstore.dto.reponse.DashboardOverviewResponse;
import com.example.techstore.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminDashboardService adminDashboardService;
    @GetMapping("/dashboard/overview")
    public ResponseEntity<ApiResponse<DashboardOverviewResponse>> getDashboardOverview() {
        try {
            DashboardOverviewResponse overview = adminDashboardService.getDashboardOverview();
            return ResponseEntity.ok(ApiResponse.success(overview));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(ApiResponse.error("Failed to fetch dashboard overview: " + e.getMessage()));
        }
    }
}
