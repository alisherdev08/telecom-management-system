package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.invoiceEnums.InvoiceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Invoice number is required.")
    @Column(nullable = false, unique = true)
    private String invoiceNumber;
    @NotNull(message = "Billing period start is required.")
    @Column(nullable = false, updatable = false)
    private LocalDateTime billingPeriodStart;
    @NotNull(message = "Billing period end is required.")
    @Column(nullable = false, updatable = false)
    private LocalDateTime billingPeriodEnd;
    @NotNull(message = "Total amount is required.")
    @Column(nullable = false)
    private BigDecimal totalAmount;
    @NotNull(message = "Base fee is required.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal baseFee;
    @NotNull(message = "Usage charges is required.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal usageCharges;
    @NotNull(message = "Discount amount is required.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal discountAmount;
    @NotNull(message = "Invoice status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
