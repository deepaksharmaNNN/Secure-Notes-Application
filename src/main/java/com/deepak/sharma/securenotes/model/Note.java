package com.deepak.sharma.securenotes.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "notes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Lob
    String noteContent;

    String username;
}
