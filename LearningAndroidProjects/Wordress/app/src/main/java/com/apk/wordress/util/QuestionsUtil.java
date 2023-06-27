package com.apk.wordress.util;

import com.apk.wordress.GamesI;
import com.apk.wordress.dao.QuestionDB;
import com.apk.wordress.model.QuestionVO;
import com.apk.wordress.model.WordVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay.bind1 on 10/1/2017.
 */

public class QuestionsUtil {

    /*Object to get the words*/
    WordPermutations permutation;
    QuestionDB questionDB;
    /*2D Array*/
    String[][] permutedWords;

    public QuestionsUtil() {
        permutation = new WordPermutations();
        questionDB = new QuestionDB();
    }

    public List<QuestionVO> getQuestionVOListOfLevel(int level) {
        int wordLength = 0;
        if (level == GamesI.LEVEL_ONE)
            wordLength = GamesI.LEVEL_ONE_STRING_LENGTH;
        else if (level == GamesI.LEVEL_TWO)
            wordLength = GamesI.LEVEL_TWO_STRING_LENGTH;
        else
            wordLength = GamesI.LEVEL_THREE_STRING_LENGTH;

        return generateQuestionVOList(permutation.getPermutedWords(questionDB.getWordsOfLevel(level),wordLength));
    }

    private List<QuestionVO> generateQuestionVOList(String[][] permutedWords) {
        List<QuestionVO> list = new ArrayList<>();
        for(String[] word : permutedWords) {
            WordVO wordVO = new WordVO(word);
            QuestionVO questionVO = new QuestionVO(word[0], wordVO);
            list.add(questionVO);
        }
        return list;
    }
}
