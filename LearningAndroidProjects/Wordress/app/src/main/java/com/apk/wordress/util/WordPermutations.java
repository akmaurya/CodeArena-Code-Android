package com.apk.wordress.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sanjay.bind1 on 10/8/2017.
 */

public class WordPermutations {

    /*All generated words in a 2D array*/
    String[][] permutedWords = new String[15][4];
    int index = 0;
    List<String> permutedWordList = new ArrayList<>();

    public String[][] getPermutedWords(String[] wordsList, int wordLength) {
        for (int i = 0; i < wordsList.length ; i++) {
            permutedWordList.clear();
            permute(wordsList[i],1,wordLength-1);
            List<String> temp = permutedWordList;
            temp.remove(0);
            Collections.shuffle(temp);
            permutedWords[i][0] = wordsList[i];
            permutedWords[i][1] = temp.get(0);
            permutedWords[i][2] = temp.get(1);
            permutedWords[i][3] = temp.get(2);
        }
        return permutedWords;
    }

    public void permute(String word, int l, int r)
    {
        if (l == r) {
            permutedWordList.add(word);
        }

        else
        {
            for (int i = l; i <= r; i++)
            {
                word = swap(word,l,i);
                permute(word, l+1, r);
                word = swap(word,l,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
