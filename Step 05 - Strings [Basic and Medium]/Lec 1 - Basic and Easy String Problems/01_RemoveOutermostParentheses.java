// Question Link: https://leetcode.com/problems/remove-outermost-parentheses/description/

class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;        
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '(') {
                if(count != 0) {
                    ans += s.charAt(i);
                }
                count++; 
            } else {
                if(count > 1) {
                    ans += s.charAt(i);
                }                
                count--; 
            }
        }

        return ans;
    }
}
