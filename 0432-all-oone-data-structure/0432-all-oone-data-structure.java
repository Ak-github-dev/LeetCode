import java.util.*;

class AllOne {
    private Map<String, Integer> count;
    private TreeSet<Map.Entry<String, Integer>> set;

    public AllOne() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> {
            int countComparison = a.getValue().compareTo(b.getValue());
            return countComparison != 0 ? countComparison : a.getKey().compareTo(b.getKey());
        });
    }

    public void inc(String key) {
        int currentCount = count.getOrDefault(key, 0);
        // Remove the previous entry if exists
        if (currentCount > 0) {
            set.remove(Map.entry(key, currentCount));
        }
        // Update the count
        count.put(key, currentCount + 1);
        // Add the new entry with updated count
        set.add(Map.entry(key, currentCount + 1));
    }

    public void dec(String key) {
        int currentCount = count.get(key);
        set.remove(Map.entry(key, currentCount)); // Remove current entry
        if (currentCount == 1) {
            count.remove(key); // If it's the last occurrence, remove it entirely
        } else {
            count.put(key, currentCount - 1); // Decrement the count
            set.add(Map.entry(key, currentCount - 1)); // Add updated entry
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().getKey();
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().getKey();
    }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */