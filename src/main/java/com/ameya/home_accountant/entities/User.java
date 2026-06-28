package com.ameya.home_accountant.entities;

import java.time.LocalDateTime;

import com.ameya.home_accountant.util.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleId;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private Role role = Role.MEMBER;

    private Boolean enabled = true;

    private LocalDateTime lastLoginAt;
}
