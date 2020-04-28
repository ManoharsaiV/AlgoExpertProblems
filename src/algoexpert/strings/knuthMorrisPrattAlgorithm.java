package algoexpert.strings;

import java.util.Arrays;

public class knuthMorrisPrattAlgorithm {
    public static boolean checkIfPatternExists(String main, String subString) {
        int[] pattern = new int[subString.length()];
        pattern = findPatternInSubString(subString);
        return findIfPatternExistsInMainString(main, subString, pattern);
    }

    public static int[] findPatternInSubString(String subString) {
        int[] pattern = new int[subString.length()];
        Arrays.fill(pattern, -1);
        int i = 1, j = 0;
        while (i < subString.length()) {
            if (subString.charAt(j) == subString.charAt(i)) {
                pattern[i] = j;
                i += 1;
                j += 1;
            } else {
                if (j > 0) {
                    j = pattern[j - 1] + 1;
                } else {
                    i += 1;
                }
            }

        }
        return pattern;
    }


    public static boolean findIfPatternExistsInMainString(String main, String subString, int[] pattern) {
        int i = 0, j = 0;
        while (i + subString.length() - j <= main.length()) {
            if (main.charAt(i) == subString.charAt(j)) {
                if (j == subString.length() - 1) {
                    return true;
                }
                i += 1;
                j += 1;
            } else {
                if (j > 0) {
                    j = pattern[j - 1] + 1;
                } else {
                    i += 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPatternExists("engineers rock", "er"));
        System.out.println(checkIfPatternExists("engineers rock", "egr"));
        System.out.println(checkIfPatternExists("AABAACAADAABAABA", "AABA"));
    }

}


