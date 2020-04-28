package algoexpert.strings;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubStringBruteForce {
    public static List<String> allPossibleSubStrings(String str) {
        List<String> sl = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                sl.add(str.substring(i, j));
            }
        }

        return sl;
    }


    public static boolean checkIfPalindromicString(String str) {
        StringBuilder sb = new StringBuilder();
        if (sb.append(str).reverse().toString().equals(str)) {
            return true;
        }

        return false;
    }


    public static String longestPalindromicSubString(String str) {
        List<String> stringList = allPossibleSubStrings(str);
        int maxLen = 0;
        String res = "";
        for (String s : stringList) {
            if (checkIfPalindromicString(s) && s.length() > maxLen) {
                res = s;
                maxLen = s.length();
            }
        }

        return res;


    }


    public static void main(String[] args) {
        System.out.println(longestPalindromicSubString("abaxyzzyxf"));
    }


}
