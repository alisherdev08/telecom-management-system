package dev.alisherdev08.telecommanagement.entity.cdr;

import dev.alisherdev08.telecommanagement.enums.cdr.callRecordEnums.CallRecordNetworkType;
import dev.alisherdev08.telecommanagement.enums.cdr.callRecordEnums.CallRecordStatus;
import dev.alisherdev08.telecommanagement.enums.cdr.callRecordEnums.CallRecordType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "call_records")
public class CallRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Start time is required")
    @Column(nullable = false, updatable = false)
    private LocalDateTime startTime;
    @NotNull(message = "End time is required")
    @Column(nullable = false, updatable = false)
    private LocalDateTime endTime;
    @NotNull(message = "Duration is required.")
    @Column(nullable = false)
    private Integer durationSeconds;
    @NotBlank(message = "Destination number is required")
    @Pattern(regexp = "^[+]?[0-9]{1,3}[0-9]{6,14}$", message = "Invalid phone format")
    @Column(nullable = false)
    private String destinationNumber;
    @NotNull(message = "Call status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CallRecordStatus status;
    @NotNull(message = "Call type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CallRecordType type;
    @Min(value = 0, message = "Signal strength must be at least 0.")
    @Max(value = 31, message = "Signal strength must not exceed 31.")
    @Column(nullable = false)
    private Integer signalStrength;
    @NotNull(message = "Network type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CallRecordNetworkType networkType;
    @Column(nullable = false)
    private boolean isInternational = false;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
