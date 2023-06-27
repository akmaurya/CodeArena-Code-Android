package com.apk.wordress.dao;

import com.apk.wordress.GamesI;

/**
 * Created by Jarvis on 11/1/2017.
 */

public class QuestionDB {

    String[] levelOneWords = {"Bird","Blue","Joke","Zinc","Quit","Lazy","Wire","Game","Home","Stop","Play","Rain","Leaf","Star","Post"};
    String[] levelTwoWords = {"Bread","Jumbo","Jocks","Delhi","Crazy","Actor","Album","Black","Borne","Chief","Doing","Drove","Email","Proxy","Flirt"};
    String[] levelThreeWords = {"Abroad","Active","Advice","Almost","Author","Beauty","Before","Camera","Change","Closed","Credit","Design","Eating","Factor","Flight"};

    public String[] getWordsOfLevel(int level) {
        if (level == GamesI.LEVEL_ONE)
            return levelOneWords;
        else if (level == GamesI.LEVEL_TWO)
            return levelTwoWords;
        else
            return levelThreeWords;
    }
}
