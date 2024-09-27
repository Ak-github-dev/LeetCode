/*
Approach:

Track Bookings:

We need to track two things:

Regular bookings: intervals where one event can take place.

Double bookings: intervals where two events overlap.

Conditions:

When we try to book a new event, we need to check:
If the new event overlaps with any existing double booking, we cannot book the event because that would lead to a triple booking.
If the new event overlaps with any regular booking, we record this overlap as a double booking.
If the new event overlaps only once or not at all, it can be added safely.

Data Structures:

Use two lists:
bookings: to track the intervals of regular bookings.
overlaps: to track intervals that are already double booked.


Steps:

Initialization:

Initialize two lists bookings and overlaps.

Booking an Event:

First, check the list of overlaps to ensure the new event does not cause a triple booking.
Then, check the bookings list and calculate any new overlaps caused by this event. Add those overlaps to the overlaps list.
Finally, add the event to the bookings list.
*/
class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;


    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check if the new event overlaps with any double-booked interval
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false;  // Triple booking would occur
            }
        }

        // Check for overlaps with existing bookings to track double bookings
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                // Calculate the overlapping interval and add it to overlaps
                int overlapStart = Math.max(start, booking[0]);
                int overlapEnd = Math.min(end, booking[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // No triple booking, so add the new event to bookings
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */