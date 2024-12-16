package com.deepak.sharma.securenotes.model;

import com.deepak.sharma.securenotes.enums.AppRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
@FieldDefaults(level = PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "role_name")
    AppRole roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<User> users;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }
}
