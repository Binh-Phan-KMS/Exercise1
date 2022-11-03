package com.example.exercise1.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private String title;

    @NotNull
    private String status;

    private String description;

    private Integer estimatedTime;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "assignee")
    private User assignee;
}
