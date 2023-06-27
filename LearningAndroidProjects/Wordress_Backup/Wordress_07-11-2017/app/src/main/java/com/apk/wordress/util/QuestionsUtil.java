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

    public List<QuestionVO> getQuestionVOListLevelOne() {
        return generateQuestionVOList(permutation.getPermutedWords(questionDB.getLevelOneWords(),GamesI.LEVEL_ONE_STRING_LENGTH));
    }

    public List<QuestionVO> getQuestionVOListLevelTwo() {
        return generateQuestionVOList(permutation.getPermutedWords(questionDB.getLevelTwoWords(),GamesI.LEVEL_TWO_STRING_LENGTH));
    }

    public List<QuestionVO> getQuestionVOListLevelThree() {
        return generateQuestionVOList(permutation.getPermutedWords(questionDB.getLevelThreeWords(),GamesI.LEVEL_THREE_STRING_LENGTH));
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
