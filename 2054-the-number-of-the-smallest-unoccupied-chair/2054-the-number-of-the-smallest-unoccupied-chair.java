/*
Approach:

Sorting the times:
First, we need to sort the friends based on their arrival times, so we know who arrives first and in what order.

Using a Min-Heap:
To manage the seating efficiently, we can use two min-heaps:
One heap to track available chairs (since we need to assign the smallest available chair).
Another heap to track when a friend leaves and frees up their chair. The heap will store both the time they leave and the chair they were sitting on.

Processing Events:
We will iterate over the sorted times array and process events in the order of 
friends' arrivals:
    If the current time is equal to or greater than the leaving time of any friend (tracked in the "leaving heap"), we will free up their chair.
    For each friend arriving at a time, we assign the smallest available chair, record when they leave and which chair they sat on.

Finding the Target Friend:
As we simulate the seating process, when we handle the friend who corresponds to targetFriend, we return the chair they were assigned.


Algorithm Steps:
Sort the times array based on the arrival times.
Use a min-heap to track the available chairs (initially, all chairs from 0 to n-1 are available).
Use another min-heap to track the departure times and release chairs accordingly.
Simulate the seating process. Once we seat the targetFriend, return the chair number they were assigned.
*/
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // Create an array of friends with their index
        int[][] friends = new int[n][3]; // [arrival, leaving, friendIndex]
        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0]; // arrival time
            friends[i][1] = times[i][1]; // leaving time
            friends[i][2] = i;           // friend index
        }

        // Sort friends by arrival time
        Arrays.sort(friends, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to keep track of available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i); // Initially, all chairs from 0 to n-1 are available
        }

        // Min-heap to keep track of when friends leave (leavingTime, chair)
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Process each friend's arrival and assign them a chair
        for (int[] friend : friends) {
            int arrival = friend[0];
            int leaving = friend[1];
            int friendIndex = friend[2];

            // Free up chairs for friends who have already left
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.offer(leavingQueue.poll()[1]); // Add the chair back to the available pool
            }

            // Assign the smallest available chair to the current friend
            int assignedChair = availableChairs.poll();

            // If this is the target friend, return the chair number
            if (friendIndex == targetFriend) {
                return assignedChair;
            }

            // Add the leaving time and the assigned chair to the leaving queue
            leavingQueue.offer(new int[]{leaving, assignedChair});
        }

        return -1; // This should never be reached
    }
}