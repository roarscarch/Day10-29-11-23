
/*
 *
 Big linkedList: so here we made an array of linkedList.
 * we find the the the index in the array by the hash function 
 * and we traverse that index if we get the word we do freq++
 * else we add the word to the end of the list
 * removing a node is easy peasy
 * just 2 conditions ya to first node delete karna hai ya fir middle mei
 * for that we take a previous pointer
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


class MyHashTable {
    private final int size;
    private final MyMapNode[] bucketArray;

    public MyHashTable(int size) {
        this.size = size;
        this.bucketArray = new MyMapNode[size];
    }

    
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

    
    public void removeWord(String word) {
        int index = getBucketIndex(word);
        MyMapNode head = bucketArray[index];
        MyMapNode prev = null;

       
        while (head != null && !head.key.equals(word)) {
            prev = head;
            head = head.next;
        }

       
        if (head != null) {
            if (prev == null) {
               
                bucketArray[index] = head.next;
            } else {
               
                prev.next = head.next;
            }
        }
    }

   
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

        
        int hashTableSize = 10;

        
        MyHashTable wordFrequencyTable = new MyHashTable(hashTableSize);

        
        for (String word : words) {
            wordFrequencyTable.addWord(word);
        }

        
        System.out.println("Before Removal:");
        wordFrequencyTable.displayFrequency();

        
        wordFrequencyTable.removeWord("avoidable");

        
        System.out.println("\nAfter Removal:");
        wordFrequencyTable.displayFrequency();
    }
}
