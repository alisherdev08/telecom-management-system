package dev.alisherdev08.telecommanagement.entity.infrastructure;

import dev.alisherdev08.telecommanagement.enums.infrastructure.towerEnums.TowerStatus;
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
@Table(name = "towers")
public class Tower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tower code is required.")
    @Column(nullable = false, unique = true)
    private String towerCode;
    @NotBlank(message = "Latitude is required.")
    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal latitude;
    @NotBlank(message = "Longitude is required.")
    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;
    @Column(precision = 7, scale = 2)
    private BigDecimal elevation;
    @NotNull(message = "Tower status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TowerStatus status;
    @NotNull(message = "Capacity is required.")
    @Min(value = 1, message = "Capacity must be at least 1.")
    @Column(nullable = false)
    private Integer capacity;
    @NotNull(message = "Current connections is required.")
    @Min(value = 0, message = "Current connections cannot be negative.")
    @Column(nullable = false)
    private Integer currentConnections;
}
