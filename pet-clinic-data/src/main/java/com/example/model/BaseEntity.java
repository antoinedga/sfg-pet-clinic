package com.example.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
public class BaseEntity implements Serializable {
    @ToString.Exclude
    private Long id;

}
