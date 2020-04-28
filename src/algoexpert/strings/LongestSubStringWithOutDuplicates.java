package algoexpert.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutDuplicates {
    public static String longestSubstringWithoutDuplication(String string) {
        int startIndex = 0;
        int[] longestStringIndices = {0, 1};
        Map<Character, Integer> ls = new HashMap<>();
        int i = 0;
        String res = "";
        while (i < string.length()) {
            if (ls.containsKey(string.charAt(i))) {
                startIndex = Math.max(startIndex, ls.get(string.charAt(i)) + 1);
            }
            if (longestStringIndices[1] - longestStringIndices[0] < i + 1 - startIndex) {
                longestStringIndices[0] = startIndex;
                longestStringIndices[1] = i + 1;
            }
            ls.put(string.charAt(i), i);
            i++;
        }

        return string.substring(longestStringIndices[0], longestStringIndices[1]);
    }


}
