package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.paymentMethodEnums.PaymentMethodStatus;
import dev.alisherdev08.telecommanagement.enums.billing.paymentMethodEnums.PaymentMethodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Method name is required.")
    @Column(nullable = false)
    private String methodName;
    @NotBlank(message = "Card last four digits is required.")
    @Pattern(regexp = "^\\d{4}$", message = "Card last four digits must be exactly 4 digits.")
    @Column(nullable = false, length = 4)
    private String cardLastFourDigits;
    @NotBlank(message = "Card holder name is required.")
    @Size(min = 2, max = 100, message = "Card holder name must be 2-100 characters.")
    @Column(nullable = false, length = 100)
    private String cardHolderName;
    @NotNull(message = "Expiry month is required.")
    @Min(value = 1, message = "Expiry month must be between 1-12.")
    @Max(value = 12, message = "Expiry month must be between 1-12.")
    @Column(nullable = false, length = 12)
    private Integer expiryMonth;
    @NotNull(message = "Expiry year is required.")
    @Min(value = 2020, message = "Expiry year must be valid.")
    @Column(nullable = false)
    private Integer expiryYear;
    @NotBlank(message = "Bank name is required for bank transfers.")
    @Size(max = 100, message = "Bank name cannot exceed 100 characters.")
    @Column(length = 100)
    private String bankName;
    @NotBlank(message = "Account number is required for bank transfers.")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Account number must be 8-20 alphanumeric characters.")
    @Column(length = 20)
    private String accountNumber;
    @NotBlank(message = "MFO (bank code) is required for bank transfers.")
    @Pattern(regexp = "^\\d{4}$", message = "MFO must be exactly 4 digits.")
    @Column(length = 4)
    private String mfo;
    @NotBlank(message = "Wallet provider is required for digital wallets.")
    @Size(max = 50, message = "Wallet provider cannot exceed 50 characters.")
    @Column(nullable = false, length = 50)
    private String walletProvider;
    @NotBlank(message = "Wallet identifier is required for digital wallets.")
    @Size(max = 100, message = "Wallet identifier cannot exceed 100 characters.")
    @Column(length = 100)
    private String walletIdentifier;
    @NotNull(message = "Payment method type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethodType type;
    @NotNull(message = "Payment method status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethodStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
