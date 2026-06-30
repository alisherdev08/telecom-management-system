package dev.alisherdev08.telecommanagement.entity.organization;

import dev.alisherdev08.telecommanagement.enums.organization.managerEnums.ManagerLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "managers")
@DiscriminatorValue("MANAGER")
public class Manager extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Manager level is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ManagerLevel level;
    @NotNull(message = "Team size is required")
    @Min(value = 0, message = "Team size cannot be negative")
    @Column(nullable = false)
    private Integer teamSize;
}
