package com.nyotafund.service;

import com.nyotafund.entity.LoanMessage;
import com.nyotafund.repository.LoanMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanMessageService {

    private final LoanMessageRepository repository;

    public LoanMessage submit(LoanMessage message) {
        return repository.save(message);
    }

    public List<LoanMessage> getAll() {
        return repository.findAll();
    }

    public List<LoanMessage> getByLoanId(Long loanId) {
        return repository.findByLoanId(loanId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


