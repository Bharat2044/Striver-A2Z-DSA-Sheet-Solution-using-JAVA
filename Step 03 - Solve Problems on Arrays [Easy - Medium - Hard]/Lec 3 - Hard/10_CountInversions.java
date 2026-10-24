// Question Link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array


class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long merge(long[]arr,int l,int m,int h){
        long swap = 0;
        long[] left = Arrays.copyOfRange(arr, l, m + 1);
        long[] right = Arrays.copyOfRange(arr, m + 1,h + 1);
        
        int i = 0, j = 0, k = l;
        
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swap += (m + 1) - (l + i);   //FOCUS ON THIS LINE ,HOW TO WORK IT
            }
        }
        
        while(i < left.length){
            arr[k++] = left[i++];
        }
        
        while(j < right.length){
            arr[k++] = right[j++];
        }
        
        return swap;
    }
    
    static long noOfInversion(long[]arr,int l,int h) {
        long count = 0;
        
        if(l<h){
            int mid=l+(h-l)/2;
        
            count+=noOfInversion(arr,l,mid);
            count+=noOfInversion(arr,mid+1,h);
            count+=merge(arr,l,mid,h);
        }
        
        return count;
    }
    
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        long count=noOfInversion(arr,0,n-1);
        return count;
    }
}
