package dev.alisherdev08.telecommanagement.entity.user;

import dev.alisherdev08.telecommanagement.enums.user.simCardEnums.SimCardStatus;
import dev.alisherdev08.telecommanagement.enums.user.simCardEnums.SimCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sim_cards")
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "MSISDN is required.")
    @Size(min = 10, max = 15)
    @Pattern(regexp = "\\d{10,15}")
    @Column(nullable = false, unique = true)
    private String msisdn;
    @NotBlank(message = "ICCID is required.")
    @Column(nullable = false, unique = true)
    private String iccid;
    @Column
    private String imsi;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SimCardStatus status;
    @NotNull(message = "Sim card type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SimCardType type;
    @Column(nullable = false, updatable = false)
    private LocalDateTime activationDate;
    @Column(nullable = false)
    private LocalDateTime expiryDate;
    @Column
    private LocalDateTime suspensionDate;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
