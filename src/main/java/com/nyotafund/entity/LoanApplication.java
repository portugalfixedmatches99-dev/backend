package com.nyotafund.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loan_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phone;
    private String idNumber;
    private String loanType;

    private String status = "APPLIED";
}

