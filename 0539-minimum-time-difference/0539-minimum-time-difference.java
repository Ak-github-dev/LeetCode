/*
Approach:

Convert Time to Minutes:

First, we convert each time point into the total number of minutes from midnight (00:00), which can be computed as:
minutes = hours * 60 + minutes

Sort the Time Points:

Sorting the time points will help us easily find the differences between consecutive time points.

Handle the Circular Nature of the Clock:

After sorting, we need to check the difference between the first and last time points as well, accounting for the circular nature of the clock (i.e., 00:00 follows 23:59).

Calculate the Minimum Difference:

Once sorted, calculate the time differences between consecutive time points and also between the last and the first time point.
*/
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        
        // Step 1: Convert each time point to minutes and store in a list
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3, 5));
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        
        // Step 2: Sort the list of minutes
        Collections.sort(minutesList);
        
        // Step 3: Calculate the minimum difference between consecutive time points
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        
        // Step 4: Handle the circular difference between the last and first time point
        int circularDiff = (1440 - minutesList.get(n - 1)) + minutesList.get(0);
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}