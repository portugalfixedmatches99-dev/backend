package com.nyotafund.controller;

import com.nyotafund.entity.LoanApplication;
import com.nyotafund.service.LoanApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
@CrossOrigin(
        origins = {
                "https://nyotafund1.vercel.app/"
        },
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
public class LoanApplicationController {

    private final LoanApplicationService service;

    // CREATE loan
    @PostMapping
    public LoanApplication apply(@RequestBody LoanApplication loan) {
        return service.create(loan);
    }

    // GET all loans (Admin)
    @GetMapping
    public List<LoanApplication> getAll() {
        return service.getAll();
    }

    // GET loan by ID
    @GetMapping("/{id}")
    public LoanApplication getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE loan status
    @PutMapping("/{id}/status")
    public LoanApplication updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status);
    }

    // DELETE loan
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

