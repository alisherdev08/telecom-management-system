package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.complaintEnums.ComplaintPriority;
import dev.alisherdev08.telecommanagement.enums.support.complaintEnums.ComplaintStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    @Column(nullable = false, length = 255)
    private String title;
    @NotBlank(message = "Description is required.")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters.")
    @Column(nullable = false, length = 1000)
    private String description;
    @NotNull(message = "Complaint priority is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintPriority priority;
    @NotNull(message = "Complaint status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintStatus status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime resolvedAt;
}
