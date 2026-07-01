package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.invoiceLineItemEnums.InvoiceLineItemType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "invoice_line_items")
public class InvoiceLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Description is required.")
    @Size(min = 5, max = 255, message = "Description must be between 5 and 255 characters.")
    @Column(nullable = false, length = 255)
    private String description;
    @NotNull(message = "Quantity is required.")
    @Column(nullable = false)
    private BigDecimal quantity;
    @NotBlank(message = "Unit of measurement is required.")
    @Size(max = 20, message = "Unit cannot exceed 20 characters.")
    @Column(nullable = false, length = 20)
    private String unit;
    @NotNull(message = "Unit price is required.")
    @Column(nullable = false)
    private BigDecimal unitPrice;
    @NotNull(message = "Amount is required.")
    @Column(nullable = false)
    private BigDecimal amount;
    @NotNull(message = "Line item type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceLineItemType type;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
