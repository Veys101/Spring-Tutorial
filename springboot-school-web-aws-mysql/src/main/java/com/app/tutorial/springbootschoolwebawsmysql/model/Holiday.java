package com.app.tutorial.springbootschoolwebawsmysql.model;

import lombok.Data;

// Show inherited methods of class: Ctrl+12
@Data
public class Holiday extends BaseEntity {
    private String day;
    private String reason;
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
