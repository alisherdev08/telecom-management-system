package dev.alisherdev08.telecommanagement.entity.billing;

import dev.alisherdev08.telecommanagement.enums.billing.serviceEnums.ServiceStatus;
import dev.alisherdev08.telecommanagement.enums.billing.serviceEnums.ServiceType;
import jakarta.persistence.*;
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
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Service name is required.")
    @Size(min = 2, max = 100, message = "Service name must be between 2 and 100 characters.")
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @NotBlank(message = "Service description is required.")
    @Size(min = 10, max = 500, message = "Service description must be between 10 and 500 characters.")
    @Column(nullable = false, length = 500)
    private String description;
    @NotNull(message = "Service type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType type;
    @NotNull(message = "Service status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
