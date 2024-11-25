package com.exo1.exo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "projet_tasks_number")
public class ProjetTasksNumber {

    @Id
    private Long projetId;

    private String projetName;

    private Long taskCount;
}
