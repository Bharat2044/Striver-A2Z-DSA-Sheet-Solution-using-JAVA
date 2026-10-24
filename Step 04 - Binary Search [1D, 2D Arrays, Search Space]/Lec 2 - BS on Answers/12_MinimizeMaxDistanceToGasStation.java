// Question Link: https://www.naukri.com/code360/problems/minimise-max-distance_7541449?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM


public class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(k * n) + O(n), Space Complexity = O(1)
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; //size of array.
        int[] howMany = new int[n - 1];

        //Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            //Find the maximum section and insert the gas station:
            double maxSection = -1;
            int maxInd = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double)(howMany[i] + 1);
            
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }

            //insert the current gas station:
            howMany[maxInd]++;
        }

        //Find the maximum distance i.e. the answer:
        double maxAns = -1;

        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double)(howMany[i] + 1);

            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }
    */
    
    /*
    // 2nd Approach: Better Approach (Using Heap) - Time Complexity = O(nlogn + klogn),, Space Complexity = O(n)
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // insert the first n-1 elements into pq with respective distance values:
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            // Find the maximum section and insert the gas station:
            Pair tp = pq.poll();
            int secInd = tp.second;

            // insert the current gas station:
            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }

        return pq.peek().first;
    }
    */

    // 3rd Approach: Optimal Approach (Using Binary Search) - Time Complexity =  O(n * log(n)) + O(n), Space Complexity = O(1)
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; 
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            
            cnt += numberInBetween;
        }

        return cnt;
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; // size of the array
        
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
        
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return high;
    }
}
