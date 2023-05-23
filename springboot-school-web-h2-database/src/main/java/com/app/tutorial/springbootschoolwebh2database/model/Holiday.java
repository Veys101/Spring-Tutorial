package com.app.tutorial.springbootschoolwebh2database.model;

import lombok.Data;

// Show inherited methods of class: Ctrl+12
@Data
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
