package dev.alisherdev08.telecommanagement.entity.organization;

import dev.alisherdev08.telecommanagement.enums.organization.companyEnums.CompanyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Company code is required.")
    @Column(nullable = false, unique = true)
    private String companyCode;
    @NotBlank(message = "Company name is required.")
    @Column(nullable = false, unique = true)
    private String companyName;
    @NotBlank(message = "Registration number is required.")
    @Column(nullable = false)
    private String registrationNumber;
    @NotBlank(message = "Tax ID is required.")
    @Column(nullable = false)
    private String taxId;
    @NotBlank(message = "Registered address is required.")
    @Column(nullable = false)
    private String registeredAddress;
    @NotBlank(message = "Registered city is required.")
    @Column(nullable = false)
    private String registeredCity;
    @NotBlank(message = "Registered country is required.")
    @Column(nullable = false)
    private String registeredCountry;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Phone number is required.")
    @Pattern(regexp = "^[+]?[0-9]{1,3}[0-9]{6,14}$")
    @Column(nullable = false)
    private String phoneNumber;
    @NotBlank(message = "Website is required.")
    @Column(nullable = false)
    private String website;
    @NotNull(message = "Company status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyStatus status;
    @Column(nullable = false)
    private Long totalSubscribers;
    @Column(nullable = false)
    private Long activeSubscribers;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}