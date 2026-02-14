package com.nyotafund.service;

import com.nyotafund.entity.LoanApplication;
import com.nyotafund.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanApplicationService {

    private final LoanApplicationRepository repository;

    public LoanApplication create(LoanApplication loan) {
        return repository.save(loan);
    }

    public List<LoanApplication> getAll() {
        return repository.findAll();
    }

    public LoanApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public LoanApplication updateStatus(Long id, String status) {
        LoanApplication loan = getById(id);
        loan.setStatus(status);
        return repository.save(loan);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
