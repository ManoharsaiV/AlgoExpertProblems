package algoexpert.strings;

public class LongestPalindromicSubString {
    public static String longestPalindromicSubstring(String str) {
        String longest = str.substring(0, 1);
        int maxLen = longest.length();
        for (int i = 1; i < str.length(); i++) {
            String oddLengthedPalindromicString = getLongestPalindrome(str, i - 1, i + 1);
            String evenLengthedPalindromicString = getLongestPalindrome(str, i - 1, i);
            int len = Math.max(oddLengthedPalindromicString.length(), evenLengthedPalindromicString.length());
            if (maxLen < len) {
                maxLen = len;
                longest = oddLengthedPalindromicString.length() > evenLengthedPalindromicString.length() ?
                        oddLengthedPalindromicString : evenLengthedPalindromicString;
            }
        }

        return longest;
    }

    public static String getLongestPalindrome(String str, int beginIndex, int endIndex) {
        while (beginIndex >= 0 && endIndex < str.length()) {
            if (str.charAt(beginIndex) != str.charAt(endIndex)) {
                break;
            }
            beginIndex -= 1;
            endIndex += 1;
        }

        return str.substring(beginIndex + 1, endIndex);

    }
}
