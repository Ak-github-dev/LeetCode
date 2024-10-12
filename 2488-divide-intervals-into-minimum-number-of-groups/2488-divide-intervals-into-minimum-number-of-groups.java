/*
Approach:

Concept:
Each interval can be represented by its start (lefti) and end (righti) times.
We can break down the problem into events:
A start of an interval can be considered as adding a new interval.
An end of an interval can be considered as removing that interval.
The goal is to find the maximum number of intervals that overlap at any time.

Events:
For each interval [lefti, righti], we create two events:
An event when the interval starts (lefti), represented as +1 (indicating an interval is starting).
An event when the interval ends (righti + 1), represented as -1 (indicating an interval is ending just after righti).

Count Overlapping Intervals:
Sort all the events based on time. If two events have the same time, process the end event (-1) before the start event (+1) to avoid counting an interval twice.
Traverse through the events and keep a running sum of the number of active intervals (i.e., intervals that have started but not yet ended).
The maximum value of this running sum will give the minimum number of groups needed.


Algorithm:
Create an array of events. For each interval [lefti, righti], add two events: one for lefti with +1 and one for righti + 1 with -1.
Sort the events based on time. If two events have the same time, process the end event before the start event.
Traverse the events while maintaining the count of active intervals, and track the maximum count.
*/
class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        // For each interval, create two events: start and end.
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1}); // +1 for the start of the interval
            events.add(new int[]{interval[1] + 1, -1}); // -1 for just after the end of the interval
        }

        // Sort the events based on time. If times are equal, process the -1 before +1
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxGroups = 0, currentGroups = 0;

        // Traverse through events and calculate the maximum number of groups needed
        for (int[] event : events) {
            currentGroups += event[1];
            maxGroups = Math.max(maxGroups, currentGroups);
        }

        return maxGroups;
    }
}