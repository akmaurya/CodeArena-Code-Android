package com.apk.wordress.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sanjay.bind1 on 9/29/2017.
 */

public class QuestionVO implements Serializable {
    private String id;
    private WordVO wordVO;

    public QuestionVO() {
    }

    public QuestionVO(String id, WordVO wordVO) {
        this.id = id;
        this.wordVO = wordVO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WordVO getWordVO() {
        return wordVO;
    }


    public void setWordVO(WordVO wordVO) {
        this.wordVO = wordVO;
    }


}
