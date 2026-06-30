package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.towerMaintenanceEnums.TowerMaintenanceStatus;
import dev.alisherdev08.telecommanagement.enums.support.towerMaintenanceEnums.TowerMaintenanceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "tower_maintenances")
public class TowerMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Maintenance date is required.")
    @Column(nullable = false)
    private LocalDateTime maintenanceDate;
    @NotNull(message = "Maintenance type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TowerMaintenanceType maintenanceType;
    @NotNull(message = "Maintenance status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TowerMaintenanceStatus maintenanceStatus;
    @Size(max = 1000, message = "Description cannot exceed 1000 characters.")
    @Column(length = 1000)
    private String description;
    @NotBlank(message = "Cost is required.")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal cost;
    @NotBlank(message = "Technician name is required.")
    @Column(nullable = false)
    private String technicianName;
    @NotNull(message = "Next maintenance date is required.")
    @Column(nullable = false)
    private LocalDateTime nextMaintenanceDate;
}
