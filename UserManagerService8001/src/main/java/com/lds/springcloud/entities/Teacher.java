package com.lds.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer tno;
    private String name;
    private String extern;
    private String sex;
    private String majorName;
    private String title;
    private Integer userId;

    public Teacher(Integer userId) {
        this.userId = userId;
    }
}
