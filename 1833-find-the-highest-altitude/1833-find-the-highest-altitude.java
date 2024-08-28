/*
Approach:

Calculate Altitudes:

Start from the initial altitude of 0 and iteratively add each gain value to calculate the altitude at each point.
Track the maximum altitude encountered during the process.

Iterate Through Gain Array:

Initialize the currentAltitude to 0 and maxAltitude to 0.
For each value in the gain array, update the currentAltitude and compare it with maxAltitude to keep track of the highest altitude.
*/
class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}