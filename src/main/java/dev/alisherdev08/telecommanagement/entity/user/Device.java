package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.deviceEnums.DeviceStatus;
import dev.alisherdev08.telecommanagement.enums.user.deviceEnums.DeviceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "IMEI is required.")
    @Pattern(regexp = "\\d{15}", message = "IMEI must be exactly 15 digits")
    @Column(nullable = false, unique = true)
    private String imei;
    @Column
    private String model;
    @Column
    private String manufacturer;
    @Column
    private String operatingSystem;
    @Column
    private String osVersion;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;
    @NotNull(message = "Device type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceType type;
    @Column
    private boolean is5GCapable;
    @Column
    private boolean isEsimCapable;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
