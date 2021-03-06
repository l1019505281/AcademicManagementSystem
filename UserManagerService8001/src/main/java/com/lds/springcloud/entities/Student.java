package com.lds.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer sno;
    private String name;
    private String className;
    private Integer userId;
    private String majorName;
    private String sex;
    private String extern;


    public Student(Integer userId) {
        this.userId = userId;
    }
}
