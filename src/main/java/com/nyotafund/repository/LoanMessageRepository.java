package com.nyotafund.repository;

import com.nyotafund.entity.LoanMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanMessageRepository extends JpaRepository<LoanMessage, Long> {
    List<LoanMessage> findByLoanId(Long loanId);
}

