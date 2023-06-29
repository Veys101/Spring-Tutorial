package com.app.tutorial.springbootschoolwebrestserviceconsuming.model;

import jakarta.persistence.*;
import lombok.Data;

// Show inherited methods of class: Ctrl+12
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    private String day;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
