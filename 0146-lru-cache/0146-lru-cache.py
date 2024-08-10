"""
Key Components:
Doubly Linked List:

Each node in the list will store a key-value pair.
The most recently used node is at the head, and the least recently used node is at the tail.
We need to support quick removal and insertion of nodes (hence a doubly linked list).
Hash Map:

The hash map will map keys to their corresponding nodes in the linked list.
This allows quick look-up of nodes during the get and put operations.
LRU Cache Operations:

get(key):
If the key exists in the cache, move the corresponding node to the head (marking it as the most recently used) and return its value.
If the key does not exist, return -1.
put(key, value):
If the key already exists, update its value and move the corresponding node to the head.
If the key does not exist, create a new node, insert it at the head, and if the cache exceeds its capacity, remove the node at the tail (least recently used).
"""
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None
        
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.cache = {}  # Hash map to store key -> node
        self.head = Node(0, 0)  # Dummy head
        self.tail = Node(0, 0)  # Dummy tail
        self.head.next = self.tail
        self.tail.prev = self.head
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._add(node)  # Move the accessed node to the head
            return node.value
        return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache:
            self._remove(self.cache[key])
        new_node = Node(key, value)
        self._add(new_node)
        self.cache[key] = new_node
        if len(self.cache) > self.capacity:
            # Remove the LRU node
            lru_node = self.tail.prev
            self._remove(lru_node)
            del self.cache[lru_node.key]


    def _remove(self, node):
        """Remove an existing node from the linked list."""
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node
    
    def _add(self, node):
        """Add a new node right after the head."""
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node    


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)