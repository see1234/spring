package ru.gb.spring5.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

/**
 * Сущность "Задача"
 * @id - идентификатор
 * @name - наименование (заголовок)
 * @description - описание
 * @status - статус
 * @createdDate - дата создания
 */

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private TaskStatus status;
    @Column(name = "CREATEDDATE")
    private LocalDateTime createdDate;

    public String getStat() {
        return status.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
