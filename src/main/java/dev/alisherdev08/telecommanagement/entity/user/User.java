package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.userEnums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First Name is required.")
    @Size(min = 2, max = 50, message = "First name must be 2-50 characters.")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "Last Name is required.")
    @Size(min = 2, max = 50, message = "Last name must be 2-50 characters.")
    @Column(nullable = false)
    private String lastName;
    @NotBlank(message = "Email is required.")
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Phone number is required.")
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String postalCode;
    @Column
    private String country;
    @NotBlank(message = "Identity number is required.")
    @Column(nullable = false, unique = true)
    private String identityNumber;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
