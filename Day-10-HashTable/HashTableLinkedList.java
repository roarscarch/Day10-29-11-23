
/*
 * Big linkedList: so here we made an array of linkedList.
 * we find the the the index in the array by the hash function 
 * and we traverse that index if we get the word we do freq++
 * else we add the word to the end of the list
 */
class MyMapNode {
    String key;
    Integer value;
    MyMapNode next;

    public MyMapNode(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Define a class for the hash table with linked list
class MyHashTable {
    private final int size;
    private final MyMapNode[] bucketArray;

    public MyHashTable(int size) {
        this.size = size;
        this.bucketArray = new MyMapNode[size];
    }

    // Hash function to map a key to an index
    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }

    // Add a key-value pair to the hash table
    public void addWord(String word) {
        int index = getBucketIndex(word);
        MyMapNode head = bucketArray[index];

        // Check if the word is already present in the hash table
        while (head != null) {
            if (head.key.equals(word)) {
                head.value++;
                return;
            }
            head = head.next;
        }

        // If the word is not present, add a new node to the linked list
        head = bucketArray[index];
        MyMapNode newNode = new MyMapNode(word, 1);
        newNode.next = head;
        bucketArray[index] = newNode;
    }

    // Remove a key-value pair from the hash table
    public void removeWord(String word) {
        int index = getBucketIndex(word);
        MyMapNode head = bucketArray[index];
        MyMapNode prev = null;

        // Search for the word in the linked list
        while (head != null && !head.key.equals(word)) {
            prev = head;
            head = head.next;
        }

        // If the word is found, remove the node
        if (head != null) {
            if (prev == null) {
                // If the target node is the head of the list
                bucketArray[index] = head.next;
            } else {
                // If the target node is in the middle or end of the list
                prev.next = head.next;
            }
        }
    }

    // Display the frequency of words in the hash table
    public void displayFrequency() {
        for (int i = 0; i < size; i++) {
            MyMapNode head = bucketArray[i];
            while (head != null) {
                System.out.println("Word: " + head.key + ", Frequency: " + head.value);
                head = head.next;
            }
        }
    }
}

public class HashTableLinkedList {
    public static void main(String[] args) {
        String paragraph = "Paranoids are not paranoid because they are paranoid but "
                         + "because they keep putting themselves deliberately into "
                         + "paranoid avoidable situations";

        // Split the paragraph into words
        String smallString=paragraph.toLowerCase();
        String[] words = smallString.split("\\s+");

        // Choose a size for the hash table
        int hashTableSize = 10;

        // Create a hash table
        MyHashTable wordFrequencyTable = new MyHashTable(hashTableSize);

        // Add words to the hash table
        for (String word : words) {
            wordFrequencyTable.addWord(word);
        }

        // Display the frequency of words before removal
        System.out.println("Before Removal:");
        wordFrequencyTable.displayFrequency();

        // Remove the word "avoidable"
        wordFrequencyTable.removeWord("avoidable");

        // Display the frequency of words after removal
        System.out.println("\nAfter Removal:");
        wordFrequencyTable.displayFrequency();
    }
}
