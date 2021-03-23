package com.lds.springcloud.service;

import com.lds.springcloud.entities.Course;
import com.lds.springcloud.entities.Score;

import java.util.List;

public interface IScoreService {
    Score getScore(Integer cno, Integer sno);

    List<Score> queryScoreByQuery(Integer pageNum, Integer pageSize, String query, Integer sno);

    int getTotalOfScore();

    Integer addScore(Score score);
}
