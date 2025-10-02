package org.logesh.models;

import lombok.Data;

@Data
public class User {

    private final int userId;
    private final String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

}
