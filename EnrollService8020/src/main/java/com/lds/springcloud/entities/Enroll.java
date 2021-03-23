package com.lds.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enroll {
    private Integer cno;
    private Integer sno;
    private String className;
    private String name;
}
