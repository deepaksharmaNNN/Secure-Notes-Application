package com.deepak.sharma.securenotes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @NotBlank
    @Size(max = 20)
    @Column(name = "username", length = 20)
    String username;

    @NotBlank
    @Size(max = 50)
    @Column(name = "email", length = 50)
    String email;

    @NotBlank
    @Size(max = 40)
    @Column(name = "password", length = 120)
    String password;

    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled = true;

    LocalDate accountExpiryDate;
    LocalDate credentialExpiryDate;

    String twoFactorSecret;
    boolean isTwoFactorEnabled;
    String signUpMethod;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE})
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    Role role;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;


    public User(String username, String mail, String password) {
        this.username = username;
        this.email = mail;
        this.password = password;
    }
}
