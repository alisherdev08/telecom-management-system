package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.roamingPartnerEnums.RoamingPartnerStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "roaming_partners")
public class RoamingPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Company name is required.")
    @Column(nullable = false)
    private String companyName;
    @NotBlank(message = "Country is required.")
    @Column(nullable = false)
    private String country;
    @NotBlank(message = "Network code is required.")
    @Column(nullable = false)
    private String networkCode;
    @NotBlank(message = "Support phone is required.")
    @Column(nullable = false)
    private String supportPhone;
    @NotNull(message = "Contract start date is required.")
    @Column(nullable = false)
    private LocalDate contractStart;
    @NotNull(message = "Contract end date is required.")
    @Column(nullable = false)
    private LocalDate contractEnd;
    @NotNull(message = "Roaming partner status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoamingPartnerStatus status;
}
