package dev.alisherdev08.telecommanagement.entity.organization;

import dev.alisherdev08.telecommanagement.enums.organization.departmentEnums.DepartmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Department code is required")
    @Column(nullable = false, unique = true)
    private String departmentCode;
    @NotBlank(message = "Department name is required")
    @Column(nullable = false)
    private String departmentName;
    @Column(nullable = false)
    private Integer employeeCount;
    @NotNull(message = "Department status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DepartmentStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
