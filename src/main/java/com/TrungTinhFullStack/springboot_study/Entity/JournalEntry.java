package com.TrungTinhFullStack.springboot_study.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
