package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.featureEnums.FeatureBillingFrequency;
import dev.alisherdev08.telecommanagement.enums.billing.featureEnums.FeatureStatus;
import dev.alisherdev08.telecommanagement.enums.billing.featureEnums.FeatureType;
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
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Feature name is required.")
    @Size(min = 2, max = 100, message = "Feature name must be 2-100 characters.")
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @NotBlank(message = "Feature description is required.")
    @Size(min = 10, max = 500, message = "Feature description must be between 10 and 500 characters.")
    @Column(nullable = false, length = 500)
    private String description;
    @NotNull(message = "Additional cost is required.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal additionalCost;
    @NotNull(message = "Feature type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FeatureType type;
    @NotNull(message = "Feature status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeatureStatus status;
    @NotNull(message = "Billing frequency is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FeatureBillingFrequency billingFrequency;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
