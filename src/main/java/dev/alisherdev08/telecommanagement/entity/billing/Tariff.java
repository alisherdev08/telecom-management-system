package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.tariffEnums.TariffBillingCycle;
import dev.alisherdev08.telecommanagement.enums.billing.tariffEnums.TariffStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tariff name is required.")
    @Size(min = 2, max = 100, message = "Tariff name must be between 2 and 100 characters.")
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @NotBlank(message = "Tariff description is required.")
    @Size(min = 10, max = 500, message = "Tariff description must be between 10 and 500 characters.")
    @Column(nullable = false, length = 500)
    private String description;
    @Column(nullable = false)
    private String monthlyFee;
    @NotNull(message = "Billing cycle is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TariffBillingCycle billingCycle;
    @NotNull(message = "Included voice minutes is required.")
    @Min(value = 0, message = "Included voice minutes cannot be negative.")
    @Column(nullable = false)
    private Integer voiceMinutesIncluded;
    @NotNull(message = "Included SMS is required.")
    @Min(value = 0, message = "Included SMS cannot be negative.")
    @Column(nullable = false)
    private Integer smsIncluded;
    @NotNull(message = "Included data limit is required.")
    @Min(value = 0, message = "Included data limit cannot be negative.")
    @Column(nullable = false)
    private Integer dataLimitMb;
    @NotNull(message = "Voice rate per minute is required.")
    @Column(nullable = false)
    private BigDecimal voiceRatePerMinute;
    @NotNull(message = "SMS rate per message is required.")
    @Column(nullable = false)
    private BigDecimal smsRatePerMessage;
    @NotNull(message = "Data rate per MB is required.")
    @Column(nullable = false)
    private BigDecimal dataRatePerMb;
    @NotNull(message = "Tariff status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TariffStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
