// Question Link: https://leetcode.com/problems/isomorphic-strings/description/


class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256]; 
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != 0 && mapS[c1] != c2 || mapT[c2] != 0 && mapT[c2] != c1) {
                return false;
            }

            mapS[c1] = c2;
            mapT[c2] = c1;
        }

        return true;
    }
}
