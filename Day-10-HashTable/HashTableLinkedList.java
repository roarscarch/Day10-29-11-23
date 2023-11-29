/* questions says small linked list thats why we  require just one linked list.
 *first define node class 
 * then linked list class.
 * now I had problem here . in add node ..if the head is null then add the word and make its current count==1.
 */



class MyMapNode {
    String key;
    int value;
    MyMapNode next;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyLinkedList {
    MyMapNode head;// in java head is NULL by default hehehehehe.

    public void addWord(String word) {
        if (head == null) {
            head = new MyMapNode(word, 1);
        } else {
            MyMapNode current = head;
            while (current.next != null && !current.key.equals(word)) {
                current = current.next;
            }

            if (current.key.equals(word)) {
                current.value++;
            } else {
                current.next = new MyMapNode(word, 1);
            }
        }
    }

    public void displayFrequency() {
        MyMapNode current = head;
        while (current != null) {
            System.out.println("Word: " + current.key + ", Frequency: " + current.value);
            current = current.next;
        }
    }
}

public class HashTableLinkedList {
    public static void main(String[] args) {
        String sentence = "To be or not to be";

        String smallString = sentence.toLowerCase();
        String[] words = smallString.split("\\s+");

       
        MyLinkedList wordFrequencyList = new MyLinkedList();

        // Add words to the linked list
        for (String word : words) {
            wordFrequencyList.addWord(word);
        }

        // Display the frequency of words
        wordFrequencyList.displayFrequency();
    }
}
