package com.company;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
	    // write your code here
        int result  = MyStrCmp("abc", "abd");
        int result2 = MyStrCmp("abc", "abc");
        int result3 = MyStrCmp("abc", "aaa");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int MyStrCmp(String str1, String str2)
    {
        if (str1.length() != str2.length())
        {
            System.out.println("Both parameters need to have equal lengths.");
            return -2;
        }

        int ret = stringCompare(str1, str2);

        switch (ret)
        {
            case -1:
                // display str1 reversed and str2 reversed
                System.out.println(String.format("%s and %s", reverseString(str1), reverseString(str2)));
                break;
            case 0:
                // display str1 and str2 merged
                System.out.println(getMergedString(str1, str2, true));
                break;
            case 1:
                // display str1 and str2 reversed and merged
                System.out.println(getMergedString(str1, str2, false));
                break;
            default:
                break;
        }

        return ret;
    }

    // My own implementation of String.compareTo(otherString)
    public static int stringCompare(String str1, String str2)
    {
        for(int i = 0; i < str1.length(); i++)
        {
            int char1 = (int) str1.charAt(i);
            int char2 = (int) str2.charAt(i);

            if(char1 < char2)
                return -1;
            else if(char1 > char2)
                return 1;
        }

        return 0;
    }

    // Reverse and return a given string.
    public static String reverseString(String reverseMe)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = reverseMe.length() -1; i > -1; i--)
            sb.append(reverseMe.charAt(i));

        return sb.toString();
    }

    // Get an ascending ArrayList<Character> of a given string.
    public static ArrayList<Character> getAscendingCharList(String listMe)
    {
        ArrayList<Character> stringChars = new ArrayList<Character>();
        for (int i = 0; i < listMe.length(); i++)
            stringChars.add(listMe.charAt(i));

         return stringChars;
    }

    // Get a descending ArrayList<Character> of a given string.
    public static ArrayList<Character> getDescendingCharList(String listMe)
    {
        ArrayList<Character> stringChars = new ArrayList<Character>();
        for (int i = listMe.length() -1; i > -1 ; i--)
            stringChars.add(listMe.charAt(i));

        return stringChars;
    }

    public static String getMergedString(String str1, String str2, boolean forward)
    {
        ArrayList<Character> str1Chars;
        ArrayList<Character> str2Chars;
        StringBuilder merged = new StringBuilder();

        if (forward)
        {
            // build an ascending character merged string
            str1Chars = getAscendingCharList(str1);
            str2Chars = getAscendingCharList(str2);
            for(int i = 0; i < str1Chars.size(); i++)
            {
                merged.append(str1Chars.get(i));
                merged.append(str2Chars.get(i));
            }
        }
        else
        {
            // build a descending character merged string
            str1Chars = getDescendingCharList(str1);
            str2Chars = getDescendingCharList(str2);
            for(int i = 0; i < str1Chars.size(); i++)
            {
                merged.append(str1Chars.get(i));
                merged.append(str2Chars.get(i));
            }
        }

        return merged.toString();
    }
}
