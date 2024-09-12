// Question Link: https://leetcode.com/problems/string-to-integer-atoi/description/


class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');
            
            if (ans * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (ans * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int) ans * sign;
    }
}
