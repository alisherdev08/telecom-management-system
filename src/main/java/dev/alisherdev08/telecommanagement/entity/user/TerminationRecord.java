package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.terminationRecordEnums.TerminationRecordType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "termination_records")
public class TerminationRecord {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime terminationDate;
    @NotNull(message = "Termination record type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TerminationRecordType terminationRecordType;
    @NotBlank(message = "Reason is required.")
    @Size(max = 500, message = "Reason must not exceed 500 characters")
    @Column(nullable = false, length = 500)
    private String reason;
    @Column(precision = 10, scale = 2)
    private BigDecimal penaltyAmount;
    @Column(precision = 10, scale = 2)
    private String refundAmount;
    @NotBlank(message = "Approver is required.")
    @Column(nullable = false)
    private String approvedBy;
    @Size(max = 1000, message = "Notes must not exceed 1000 characters.")
    @Column(length = 1000)
    private String notes;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
