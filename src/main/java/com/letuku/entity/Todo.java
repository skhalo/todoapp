package com.letuku.entity;

import lombok.Data;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
public class Todo extends AbstractEntity {

    @NotEmpty(message = "A Todo task must be set")
    @Size(min = 3, max = 140, message = "The minimum character length should be 3 and max 140.")
    private String task; //varchar 255
    private LocalDate dateCreated;
    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Due date must be in the present or future.")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate; //yyyy-mm-dd eg 2018-10-31
    private boolean completed;
    private boolean archived;
    private boolean remind;


    @ManyToOne
    @JoinColumn(name = "TodoUser_Id")
    private TodoUser todoOwner;
}
