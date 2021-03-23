package com.lds.springcloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer cno;
    private String className;
    private String classRoom;
    private String classMajor;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeEnroll;
    private Integer tno;
    private Integer numberPeople;
    private Integer enrollPeople;
}
