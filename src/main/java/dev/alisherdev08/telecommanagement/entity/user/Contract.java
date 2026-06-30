package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.contractEnums.ContractStatus;
import dev.alisherdev08.telecommanagement.enums.user.contractEnums.ContractTerminationReason;
import dev.alisherdev08.telecommanagement.enums.user.contractEnums.ContractType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Contract number is required.")
    @Column(nullable = false, unique = true, updatable = false)
    private String contractNumber;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startDate;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime endDate;
    @NotNull(message = "Status is required.")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractStatus status;
    @NotNull(message = "Contract type is required.")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractType type;
    @Column(precision = 10, scale = 2)
    private BigDecimal contractValue;
    @Column(precision = 10, scale = 2)
    private BigDecimal penaltyForEarlyTermination;
    @Column
    private boolean autoRenewal;
    @Column
    private Integer renewalPeriodMonths;
    @Size(max = 2000, message = "Terms must not exceed 2000 characters.")
    @Column(length = 2000)
    private String terms;
    @Column
    private LocalDateTime terminationDate;
    @NotNull(message = "Contract termination reason is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractTerminationReason terminationReason;
    @NotNull
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @NotNull
    @UpdateTimestamp
    @Column(nullable = false)
    private  LocalDateTime updatedAt;
}
