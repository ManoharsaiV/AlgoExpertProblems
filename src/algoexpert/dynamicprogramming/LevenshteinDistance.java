package algoexpert.dynamicprogramming;

import java.util.Arrays;

public class LevenshteinDistance {
    public static int findDistance(String str1, String str2) {
        int rows = str1.length() + 1, cols = str2.length() + 1;
        int[][] editsTable = new int[rows][cols];
        // initialise to initial values as required
        // first row - 0, 1, 2, 3, .... length of string 1
        /** first column -
         * 0
         * 1
         * 2
         * 3
         * .
         * .
         * .
         * length of string 2
         */
        // first row
        for (int i = 0; i < cols; i++) {
            editsTable[0][i] = i;
        }

        // first column
        for (int i = 1; i < rows; i++) {
            editsTable[i][0] = i;
        }

        /**   */


        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str2.charAt(j - 1) == str1.charAt(i - 1)) {
                    editsTable[i][j] = editsTable[i - 1][j - 1];
                } else {
                    int min1 = Math.min(editsTable[i][j - 1], editsTable[i - 1][j]);
                    editsTable[i][j] = Math.min(min1, editsTable[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int[] x : editsTable) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        return editsTable[rows - 1][cols - 1];

    }

    public static void main(String[] args) {
        System.out.println(findDistance("abc", "yabd"));
    }
}
