package com.apk.wordress.model;

import java.io.Serializable;

/**
 * Created by sanjay.bind1 on 9/29/2017.
 */

public class WordVO implements Serializable {
    private String[] options;

    public WordVO() {
    }

    public WordVO(String[] options) {
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] option) {
        this.options = options;
    }
}
