// Question Link: https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-number-of-substrings


class Solution {
    
    long countSubstring(String S, int K) {
        int n = S.length();
        
        int[] freq = new int[26];
        
        int uc = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (freq[S.charAt(right) - 'a'] == 0) {
                uc++;
            }
            
            freq[S.charAt(right) - 'a']++;
            
            while (uc > K) {
                freq[S.charAt(left) - 'a']--;
                
                if (freq[S.charAt(left) - 'a'] == 0) {
                    uc--;
                }
                
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
    
    
    long substrCount(String S, int K) {
        if (S == null || K <= 0) {
            return 0;
        }
        
        return countSubstring(S, K) - countSubstring(S, K - 1);
    }
}
