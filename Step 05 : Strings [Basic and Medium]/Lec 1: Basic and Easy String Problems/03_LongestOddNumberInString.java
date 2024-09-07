// Question Link: https://leetcode.com/problems/largest-odd-number-in-string/description/


class Solution {
    public String largestOddNumber(String num) {

        for(int i = num.length()-1; i >= 0; i--){
            
            int x = (int) num.charAt(i) - 48;
        
            if (x % 2 != 0){
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
