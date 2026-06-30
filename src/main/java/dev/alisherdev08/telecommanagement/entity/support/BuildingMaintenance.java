package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.buildingMaintenanceEnums.BuildingMaintenanceStatus;
import dev.alisherdev08.telecommanagement.enums.support.buildingMaintenanceEnums.BuildingMaintenanceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "building_maintenances")
public class BuildingMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Maintenance date is required.")
    @Column(nullable = false)
    private LocalDate maintenanceDate;
    @NotNull(message = "Maintenance type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildingMaintenanceType type;
    @NotNull(message = "Maintenance status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildingMaintenanceStatus status;
    @NotBlank(message = "Description is required.")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters.")
    @Column(nullable = false, length = 1000)
    private String description;
    @NotNull(message = "Cost is required.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;
    @NotBlank(message = "Technician name is required.")
    @Column(nullable = false)
    private String technicianName;
    @NotNull(message = "Next maintenance date is required.")
    @Column(nullable = false)
    private LocalDate nextMaintenanceDate;
}
