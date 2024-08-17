"""
Approach:

Concept of Partitioning:

We can imagine that we're dividing the combined array into two halves: a left half and a right half.
The median will either be the maximum element of the left half or the average of the maximum of the left half and the minimum of the right half, depending on whether the total number of elements is odd or even.

Binary Search:

Perform binary search on the smaller array (let's assume nums1), to find the correct partition.
For each partition of nums1, determine the corresponding partition in nums2 such that the left half of the combined arrays is of the same size as the right half.

Conditions for Correct Partition:

Ensure that the maximum element of the left partition of one array is less than or equal to the minimum element of the right partition of the other array.
If this condition is met, we have found the correct partition.


Detailed Steps:

Binary Search:

We perform a binary search on the first array nums1.
Let's denote the partition index in nums1 as i and in nums2 as j.

Calculating i and j:

Since we want the left half and the right half to be balanced, we can calculate j based on i as: j = ((m+n+1)/2)-i 
Here, m and n are the lengths of nums1 and nums2, respectively.

Finding the Correct Partition:

Check the elements around the partitions to ensure that the maximum element on the left side is less than or equal to the minimum element on the right side.

Returning the Median:

If the total number of elements is odd, return the maximum of the left partitions.
If the total number of elements is even, return the average of the maximum of the left partitions and the minimum of the right partitions.
"""
"""
Complexity:
Time Complexity: O(log(min(m,n))) because we are performing binary search on the smaller array.
Space Complexity: O(1) as the algorithm only uses a constant amount of extra space.
"""
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1  # Ensure nums1 is the smaller array
        
        m, n = len(nums1), len(nums2)
        imin, imax, half_len = 0, m, (m + n + 1) // 2
        
        while imin <= imax:
            i = (imin + imax) // 2
            j = half_len - i
            
            if i < m and nums1[i] < nums2[j - 1]:
                # i is too small, must increase it
                imin = i + 1
            elif i > 0 and nums1[i - 1] > nums2[j]:
                # i is too big, must decrease it
                imax = i - 1
            else:
                # i is perfect
                if i == 0:
                    max_of_left = nums2[j - 1]
                elif j == 0:
                    max_of_left = nums1[i - 1]
                else:
                    max_of_left = max(nums1[i - 1], nums2[j - 1])
                
                if (m + n) % 2 == 1:
                    return max_of_left
                
                if i == m:
                    min_of_right = nums2[j]
                elif j == n:
                    min_of_right = nums1[i]
                else:
                    min_of_right = min(nums1[i], nums2[j])
                
                return (max_of_left + min_of_right) / 2.0