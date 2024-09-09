// Question Link: https://leetcode.com/problems/rotate-string/description/


class Solution {
    public boolean rotateString(String s, String goal) {
        
        if (s.length() != goal.length()) {
            return false;
        } 

        String temp = s + s;
        
        return temp.contains(goal);
    }
}
