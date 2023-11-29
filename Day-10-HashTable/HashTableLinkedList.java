import java.util.HashMap;

// A class for the key-value pair in the hash table--We have to use linkedList in this
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
        String sentence = "To be or not to be";
        String smallString = sentence.toLowerCase();
        String[] words = smallString.split("\\s+");

        // Choose a size for the hash table
        int hashTableSize = 10;

        // Create a hash table
        MyHashTable wordFrequencyTable = new MyHashTable(hashTableSize);

        // Add words to the hash table
        for (String word : words) {
            wordFrequencyTable.addWord(word);
        }

        // Display the frequency of words
        wordFrequencyTable.displayFrequency();
    }
}
