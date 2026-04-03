package financebackend.controllers;

import financebackend.repository.FinancialRecordRepository;
import financebackend.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private FinancialRecordService service;

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping("summary")
    public Map<String, Double> getSummary(@RequestHeader("role") String role) {

        if (!(role.equals("ADMIN") || role.equals("ANALYST") || role.equals("VIEWER"))) {
            throw new RuntimeException("Access Denied");
        }

        Map<String, Double> data = new HashMap<>();
        data.put("totalIncome", service.getTotalIncome());
        data.put("totalExpense", service.getTotalExpense());
        data.put("netBalance", service.getNetBalance());

        return data;
    }



}
