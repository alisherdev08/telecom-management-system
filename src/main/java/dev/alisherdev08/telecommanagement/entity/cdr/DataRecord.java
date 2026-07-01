package dev.alisherdev08.telecommanagement.entity.cdr;

import dev.alisherdev08.telecommanagement.enums.cdr.dataRecordEnums.DataRecordSessionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "data_records")
public class DataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Start time is required")
    @Column(nullable = false, updatable = false)
    private LocalDateTime startTime;
    @NotNull(message = "End time is required")
    @Column(nullable = false, updatable = false)
    private LocalDateTime endTime;
    @NotNull(message = "Data used is required.")
    @Column(nullable = false)
    private Long dataUsedMb;
    @NotNull(message = "Data upload is required.")
    @Column(nullable = false)
    private Long dataUploadMb;
    @NotNull(message = "Data download is required.")
    @Column(nullable = false)
    private Long dataDownloadMb;
    @NotNull(message = "Session type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataRecordSessionType sessionType;
    @NotNull(message = "Signal strength is required.")
    @Min(value = 0, message = "Signal strength must be at least 0.")
    @Max(value = 31, message = "Signal strength must not exceed 31.")
    @Column(nullable = false)
    private Integer signalStrength;
    @NotNull(message = "Data speed is required.")
    @Column(nullable = false)
    private Integer dataSpeedKbps;
    @Column
    private String accessPointName;
    @Column(nullable = false)
    private boolean isRoaming = false;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
