package dev.alisherdev08.telecommanagement.entity.infrastructure;

import dev.alisherdev08.telecommanagement.enums.infrastructure.buildingEnums.BuildingOwnership;
import dev.alisherdev08.telecommanagement.enums.infrastructure.buildingEnums.BuildingStatus;
import dev.alisherdev08.telecommanagement.enums.infrastructure.buildingEnums.BuildingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Building code is required.")
    @Column(nullable = false, unique = true)
    private String buildingCode;
    @NotBlank(message = "Address is required.")
    @Column(nullable = false)
    private String address;
    @NotBlank(message = "City is required.")
    @Column(nullable = false)
    private String city;
    @NotBlank(message = "State is required.")
    @Column(nullable = false)
    private String state;
    @NotBlank(message = "Country is required.")
    @Column(nullable = false)
    private String country;
    @NotNull(message = "Building type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildingType type;
    @NotNull(message = "Building status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildingStatus status;
    @NotNull(message = "Building ownership is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildingOwnership ownership;
}
