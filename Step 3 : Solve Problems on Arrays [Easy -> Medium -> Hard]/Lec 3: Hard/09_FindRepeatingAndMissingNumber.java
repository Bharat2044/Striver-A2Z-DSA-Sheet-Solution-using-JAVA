// Question Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-missing-and-repeating


class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];
        int temp[] = new int[n + 1];
        
        for(int i = 0 ; i < n ; i++){
            int x = arr[i];
            
            if(temp[x] != 1){
                temp[x] = 1;
            }else{
                ans[0] = x;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(temp[i] == 0){
                ans [1] = i;
            }
        }
        
        return ans;
    }
}
