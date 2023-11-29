import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTableExample<K, V> {
    Map<K, V> map = new HashMap<>();

    //To add the data
    public void add(K key, V value){
        map.put(key,value);
    }

   //To Retvice the data
    public V get(K key){
        return map.get(key);
    }

    public void display(){
        for(Map.Entry<K, V> entry : map.entrySet()){
            System.out.println("Key: " +entry.getKey()+ ", Value: " +entry.getValue());
        }
    }

    public boolean containsKey(K key){
        return map.containsKey(key);
    }

    public void remove(K key){
        map.remove(key);
    }

    public static void main(String[] args) {
        HashTableExample<String, Integer> ageTable = new HashTableExample<>();
        ageTable.add("Alice",25);
        ageTable.add("Ram",20);
        ageTable.add("Ali",18);

        System.out.println("Age of Ram: " +ageTable.get("Ram"));

        ageTable.display();

        System.out.println("Key present if Map: " +ageTable.containsKey("Alice1"));
        ageTable.remove("Ali");
        ageTable.display();
    }
}