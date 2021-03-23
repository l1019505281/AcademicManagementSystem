package com.lds.springcloud.entities;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer cno;
    private String className;
    private String classRoom;
    private String classMajor;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timeEnroll;
    private Integer tno;
    private Integer numberPeople;
    private Integer enrollPeople;
}
