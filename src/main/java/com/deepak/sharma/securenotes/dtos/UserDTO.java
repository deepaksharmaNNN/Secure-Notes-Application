package com.deepak.sharma.securenotes.dtos;

import com.deepak.sharma.securenotes.model.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@JsonSerialize
//@JsonDeserialize
@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Long userId;

    String username;

    String email;

    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;

    LocalDate accountExpiryDate;
    LocalDate credentialExpiryDate;

    String twoFactorSecret;
    boolean isTwoFactorEnabled;
    String signUpMethod;

    Role role;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
