package com.nyotafund.controller;

import com.nyotafund.entity.LoanMessage;
import com.nyotafund.service.LoanMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@CrossOrigin
public class LoanMessageController {

    private final LoanMessageService service;

    // SUBMIT M-Pesa message
    @PostMapping
    public LoanMessage submit(@RequestBody LoanMessage message) {
        return service.submit(message);
    }

    // GET all payments (Admin)
    @GetMapping
    public List<LoanMessage> getAll() {
        return service.getAll();
    }

    // GET payments by loan ID
    @GetMapping("/loan/{loanId}")
    public List<LoanMessage> getByLoanId(@PathVariable Long loanId) {
        return service.getByLoanId(loanId);
    }

    // DELETE payment
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

