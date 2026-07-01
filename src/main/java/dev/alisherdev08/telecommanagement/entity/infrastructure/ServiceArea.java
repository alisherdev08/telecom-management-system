package dev.alisherdev08.telecommanagement.entity.infrastructure;

import dev.alisherdev08.telecommanagement.enums.infrastructure.serviceAreaEnums.ServiceAreaCoverageType;
import dev.alisherdev08.telecommanagement.enums.infrastructure.serviceAreaEnums.ServiceAreaStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "service_areas")
public class ServiceArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Area code is required.")
    @Column(nullable = false, unique = true)
    private String areaCode;
    @NotBlank(message = "Area name is required.")
    @Column(nullable = false)
    private String areaName;
    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String city;
    @NotBlank(message = "State is required.")
    @Column(nullable = false)
    private String state;
    @NotBlank(message = "Country is required.")
    @Column(nullable = false)
    private String country;
    @NotNull(message = "Coverage type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceAreaCoverageType coverageType;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceAreaStatus status;
}
