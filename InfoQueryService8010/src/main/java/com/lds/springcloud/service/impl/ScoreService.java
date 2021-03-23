package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.IScoreDao;
import com.lds.springcloud.entities.Score;
import com.lds.springcloud.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService implements IScoreService {

    @Autowired
    IScoreDao scoreDao;

    @Override
    public Score getScore(Integer cno, Integer sno) {
        return scoreDao.queryScoreByno(cno,sno);
    }

    @Override
    public List<Score> queryScoreByQuery(Integer pageNum, Integer pageSize, String query, Integer sno) {
        if (pageNum-1 >= 0) {
            pageNum = (pageNum-1)*pageSize;
        }
        if (true) {
            query = query + "%";
        }
        return scoreDao.queryScoreByQuery(pageNum,pageSize,query,sno);
    }

    @Override
    public int getTotalOfScore() {
        return scoreDao.getTotalOfScore();
    }

    @Override
    public Integer addScore(Score score) {
        return scoreDao.addScore(score);
    }
}
