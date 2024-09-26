
/*
Approach:

Events Representation:

Each event can be represented by a start time and an end time. We need to make sure that when a new event is being added, it does not overlap with any existing events.
An event [start,end) means that the event starts at start and lasts until just before end.

No Overlap Condition:

Two events [start1,end1) and [start2,end2) do not overlap if:
end1 <= start2 (event1 ends before event2 starts) or
end2 <= start1 (event2 ends before event1 starts).

The condition for overlap is the negation of the above:
start1 < end2 and start2 < end1.

Data Structure:

To store the events, we can use a list (or array) to store pairs of (start, end) times. Every time a new event is added, we iterate through the list to check if it overlaps with any of the previously booked events.

Steps:
Initialize an empty list to store events.
For each new booking:
Iterate through the current list of events and check if the new event overlaps with any of them.
If there is no overlap, add the new event to the list and return True.
If there is an overlap, return False.
*/class MyCalendar {
    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
         // Check if the new event overlaps with any existing event
        for (int[] event : events) {
            int existingStart = event[0];
            int existingEnd = event[1];
            
            // Check for overlap
            if (start < existingEnd && existingStart < end) {
                return false; // There is an overlap, so we can't book this event
            }
        }
        
        // No overlap, add the new event to the list
        events.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */