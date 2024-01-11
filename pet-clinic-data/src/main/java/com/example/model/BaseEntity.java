package com.example.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
public class BaseEntity implements Serializable {
    @ToString.Exclude
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
