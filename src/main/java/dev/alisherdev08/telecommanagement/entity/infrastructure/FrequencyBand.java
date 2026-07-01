package dev.alisherdev08.telecommanagement.entity.infrastructure;

import dev.alisherdev08.telecommanagement.enums.infrastructure.frequencyBandEnums.FrequencyBandStatus;
import dev.alisherdev08.telecommanagement.enums.infrastructure.frequencyBandEnums.FrequencyBandTechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "frequency_bands")
public class FrequencyBand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Band name is required.")
    @Column(nullable = false)
    private String bandName;
    @NotNull(message = "Frequency is required.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal frequencyMHz;
    @NotNull(message = "Band width is required.")
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal bandwidthMHz;
    @NotNull(message = "Number of channels is required.")
    @Min(value = 1, message = "Number of channels must be at least 1.")
    @Column(nullable = false)
    private Integer numberOfChannels;
    @NotNull(message = "Technology type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequencyBandTechnologyType technologyType;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequencyBandStatus status;
    @NotNull(message = "Max capacity is required.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal maxCapacityMbps;
    @NotNull(message = "Current throughput is required.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal currentThroughputMbps;
    @NotNull(message = "Utilization percentage is required.")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal utilizationPercentage;
}
