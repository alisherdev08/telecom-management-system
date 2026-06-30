package dev.alisherdev08.telecommanagement.entity.organization;

import dev.alisherdev08.telecommanagement.enums.organization.employeeEnums.EmployeeStatus;
import dev.alisherdev08.telecommanagement.enums.organization.employeeEnums.EmployeeEmploymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Employee code is required.")
    @Column(nullable = false, unique = true)
    private String employeeCode;
    @NotBlank(message = "First name is required.")
    @Size(min = 2, max = 50, message = "First name must be 2-50 characters")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "Last name is required.")
    @Size(min = 2, max = 50, message = "Last name must be 2-50 characters")
    @Column(nullable = false)
    private String lastName;
    @NotBlank(message = "Email is required.")
    @Email(message = "Email must be valid.")
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank(message = "Phone number is required.")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be 10-15 digits")
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @NotBlank(message = "Identity number is required.")
    @Column(nullable = false)
    private String identityNumber;
    @Size(max = 255, message = "Address must not exceed 255 characters.")
    @Column
    private String address;
    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must not exceed 100 characters")
    @Column(nullable = false)
    private String city;
    @NotBlank(message = "Country is required.")
    @Column(nullable = false)
    private String country;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status;
    @NotNull(message = "Employment type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeEmploymentType type;
    @NotNull(message = "Join date is required")
    @Column(nullable = false)
    private LocalDate joinDate;
    @Column
    private LocalDate resignationDate;
    @NotNull(message = "Monthly salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Monthly salary must be greater than 0")
    @Column(nullable = false)
    private BigDecimal monthlySalary;
    @NotBlank(message = "Job title is required")
    @Size(min = 2, max = 100, message = "Job title must be 2-100 characters")
    @Column(nullable = false)
    private String jobTitle;
}
