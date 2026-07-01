package dev.alisherdev08.telecommanagement.entity.infrastructure;

import dev.alisherdev08.telecommanagement.enums.infrastructure.networkNodeEnums.NetworkNodeStatus;
import dev.alisherdev08.telecommanagement.enums.infrastructure.networkNodeEnums.NetworkNodeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "network_nodes")
public class NetworkNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Node code is required.")
    @Column(nullable = false, unique = true)
    private String nodeCode;
    @NotBlank(message = "Node name is required.")
    @Column(nullable = false)
    private String nodeName;
    @NotBlank(message = "IP address is required.")
    @Pattern(
            regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
            message = "IP address must be a valid IPv4 address."
    )
    @Column(nullable = false, unique = true)
    private String ipAddress;
    @NotBlank(message = "Subnet mask is required.")
    @Pattern(
            regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
            message = "Subnet mask must be a valid IPv4 mask."
    )
    @Column(nullable = false)
    private String subnetMask;
    @NotNull(message = "Network node type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NetworkNodeType type;
    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NetworkNodeStatus status;
    @NotNull(message = "Capacity is required.")
    @Min(value = 1, message = "Max calls must be at least 1.")
    @Column(nullable = false)
    private Integer maxCalls;
    @NotNull(message = "Current load is required")
    @Min(value = 0, message = "Current load cannot be negative.")
    @Column(nullable = false)
    private Integer currentLoad;
}
