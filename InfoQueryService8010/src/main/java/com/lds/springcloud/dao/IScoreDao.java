package com.lds.springcloud.dao;

import com.lds.springcloud.entities.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IScoreDao {
    Score queryScoreByno(@Param("cno") Integer cno,@Param("sno") Integer sno);

    List<Score> queryScoreByQuery(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("query") String query, @Param("sno") Integer sno);

    int getTotalOfScore();

    Integer addScore(Score score);
}
