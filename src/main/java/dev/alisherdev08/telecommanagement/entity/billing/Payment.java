package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.paymentEnums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Transaction reference is required.")
    @Size(min = 10, max = 50, message = "Transaction reference must be 10-50 characters.")
    @Column(nullable = false, unique = true, length = 50)
    private String transactionReference;
    @NotNull(message = "Amount is required.")
    @Column(nullable = false)
    private BigDecimal amount;
    @NotBlank(message = "Gateway transaction ID is required.")
    @Size(max = 100, message = "Gateway transaction ID cannot exceed 100 characters.")
    @Column(nullable = false, length = 100)
    private String gatewayTransactionId;
    @NotBlank(message = "Gateway name is required.")
    @Size(max = 50, message = "Gateway name cannot exceed 50 characters.")
    @Column(nullable = false, length = 50)
    private String gatewayName;
    @Column(nullable = false)
    private String gatewayResponse;
    @Column
    private String failureReason;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;
}
