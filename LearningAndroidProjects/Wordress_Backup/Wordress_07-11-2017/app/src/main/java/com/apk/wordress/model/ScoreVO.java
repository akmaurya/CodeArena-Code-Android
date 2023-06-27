package com.apk.wordress.model;

import java.io.Serializable;

/**
 * Created by sanjay.bind1 on 9/29/2017.
 */

public class ScoreVO implements Serializable {
    private int level;
    private int score;
    private ScoreVO scoreVO;

    public ScoreVO() {
    }

    public ScoreVO(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ScoreVO getScoreVO() {
        return scoreVO;
    }

    public void setScoreVO(ScoreVO scoreVO) {
        this.scoreVO = scoreVO;
    }
}
