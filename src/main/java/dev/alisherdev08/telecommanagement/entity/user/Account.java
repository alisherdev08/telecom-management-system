package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.accountEnums.AccountStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Account number is required.")
    @Column(nullable = false, unique = true, updatable = false)
    private String accountNumber;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;
    @NotNull(message = "Balance is required.")
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;
    @NotNull(message = "Credit limit is required.")
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal creditLimit;
    @NotNull(message = "Total usage in this month is required.")
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalUsageThisMonth;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
