package dev.alisherdev08.telecommanagement.entity.cdr;

import dev.alisherdev08.telecommanagement.enums.cdr.smsRecordEnums.SmsRecordStatus;
import dev.alisherdev08.telecommanagement.enums.cdr.smsRecordEnums.SmsRecordType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sms_records")
public class SmsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Recipient number is required")
    @Pattern(regexp = "^[+]?[0-9]{1,3}[0-9]{6,14}$", message = "Invalid phone format")
    @Column(nullable = false)
    private String recipientNumber;
    @NotBlank(message = "Message content is required")
    @Size(max = 500, message = "Message cannot exceed 500 characters")
    @Column(nullable = false, length = 500)
    private String messageContent;
    @NotNull(message = "Message length is required.")
    @Column(nullable = false)
    private Integer messageLength;
    @Column(nullable = false)
    private boolean isInternational = false;
    @Column(nullable = false)
    private boolean isRoaming = false;
    @NotNull(message = "SMS status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SmsRecordStatus status;
    @NotNull(message = "SMS type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SmsRecordType type;
    @NotNull
    @Column(nullable = false, updatable = false)
    private LocalDateTime sentAt;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
