package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.vendorEnums.VendorStatus;
import dev.alisherdev08.telecommanagement.enums.support.vendorEnums.VendorType;
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
@Table(name = "vendors")
public class Vendor {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       @NotBlank(message = "Vendor code is required.")
       @Column(nullable = false, unique = true)
       private String vendorCode;
       @NotBlank(message = "Vendor name is required.")
       @Column(nullable = false)
       private String vendorName;
       @NotBlank(message = "Country is required.")
       @Column(nullable = false)
       private String country;
       @Column
       private String address;
       @Column
       private String city;
       @Column
       private String postalCode;
       @NotBlank(message = "Email is required.")
       @Size(max = 100, message = "Email cannot exceed 100 characters.")
       @Email(message = "Email should be valid.")
       @Column(nullable = false, length = 100)
       private String email;
       @NotBlank(message = "Phone number is required.")
       @Size(max = 20, message = "Phone number cannot exceed 20 characters.")
       @Column(nullable = false, length = 20)
       private String phoneNumber;
       @NotBlank(message = "Website is required.")
       @Size(max = 500, message = "Website cannot exceed 500 characters.")
       @Column(nullable = false, length = 500)
       private String website;
       @NotNull(message = "Vendor type is required.")
       @Enumerated(EnumType.STRING)
       @Column(nullable = false)
       private VendorType type;
       @NotNull(message = "Vendor status is required.")
       @Enumerated(EnumType.STRING)
       @Column(nullable = false)
       private VendorStatus status;
       @Size(max = 1000, message = "Product services cannot exceed 1000 characters.")
       @Column(length = 1000)
       private String productsServices;
       @Size(max = 500, message = "Contract terms cannot exceed 500 characters.")
       @Column(length = 500)
       private String contractTerms;
       @Size(max = 100, message = "Account manager cannot exceed 100 characters.")
       @Column(length = 100)
       private String accountManager;
       @CreationTimestamp
       @Column(nullable = false, updatable = false)
       private LocalDateTime createdAt;
       @UpdateTimestamp
       @Column(nullable = false)
       private LocalDateTime updatedAt;
}
