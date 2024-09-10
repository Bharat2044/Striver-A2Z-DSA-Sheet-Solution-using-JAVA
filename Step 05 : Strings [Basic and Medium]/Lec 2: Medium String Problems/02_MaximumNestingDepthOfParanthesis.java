// Question Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/


class Solution {
    public int maxDepth(String s) {

        int currCount = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currCount++;
            }

            maxCount = Math.max(currCount, maxCount);

            if (s.charAt(i) == ')') {
                currCount--;
            }
        }

        return maxCount;
    }
}
