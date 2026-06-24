import java.util.Arrays;

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platforms = 1;
        int maxPlatforms = 1;

        int i = 1; // arrival pointer
        int j = 0; // departure pointer

        while (i < n && j < n) {
            // train arrives before previous train departs
            if (Arrival[i] <= Departure[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } 
            else {
                // one train departed
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}