package com.nyotafund.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loan_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanId;

    @Column(length = 1000)
    private String mpesaMessage;

    private String phone;
    private Double amount;

    private String status = "PENDING";
}


