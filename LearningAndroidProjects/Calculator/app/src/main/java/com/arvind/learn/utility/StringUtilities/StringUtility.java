package com.arvind.learn.utility.StringUtilities;

/**
 * Created by Jarvis on 9/22/2016.
 */
public class StringUtility {
    public static boolean isContains(String string, String s)
    {
        int sLength = s.length();
        int stringLength = string.length();
        for(int i = 0; i <= (stringLength-sLength); i++)
        {
            String subString = string.substring(i,sLength+i);
            if(subString.equals(s))
            {
                System.out.println(subString);
                return true;
            }
        }
        return false;
    }
    public static String infixToPostfix(String infixString)
    {
        String postfixString = null;

        return postfixString;
    }
}
