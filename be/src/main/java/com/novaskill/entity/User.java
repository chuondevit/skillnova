package com.novaskill.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.novaskill.enums.Role;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // =========================
    // PRIMARY KEY
    // =========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // BASIC INFO
    // =========================
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String avatar;

    // =========================
    // ROLE
    // =========================
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // =========================
    // WALLET
    // =========================
    @Builder.Default
    private Double balance = 0.0;

    // =========================
    // STATUS
    // =========================
    @Builder.Default
    private Boolean isActive = true;

    // =========================
    // CREATED TIME
    // =========================
    @CreationTimestamp
    private LocalDateTime createdAt;
}