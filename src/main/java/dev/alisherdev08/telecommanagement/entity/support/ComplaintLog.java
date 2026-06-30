package dev.alisherdev08.telecommanagement.entity.support;

import dev.alisherdev08.telecommanagement.enums.support.complaintLogEnums.ComplaintLogAction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaint_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Complaint log action is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintLogAction action;
    @NotBlank(message = "Comment is required.")
    @Size(max = 1000, message = "Comment cannot exceed 1000 characters.")
    @Column(nullable = false, length = 1000)
    private String comment;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}