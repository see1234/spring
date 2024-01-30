package ru.gb.spring5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность "Задача"
 * @id - идентификатор
 * @name - наименование (заголовок)
 * @description - описание
 * @status - статус
 * @createdDate - дата создания
 */
@Data
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
}
