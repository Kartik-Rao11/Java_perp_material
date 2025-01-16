import java.util.HashMap;

/**
 * HashMap is a data structure that stores key value pair it uses hashCode()
 * method to calculate the bucket for the key and equals() method to check if
 * the key exists and return the value according to that key
 * 
 * hashCode() -> It is used to calculate the hashcode from keys to determine the
 * bucket index to place (key,value) pair, multiple keys can proudce same hash
 * and this produces collision and then chaining occurs.
 * 
 * chaining-> key's with same hashcode are saved in same bucket by chaining them
 * as linked list (before java 8) or balanced binary trees.
 */

class Key {
    String value;

    Key(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 1; // returning the same hashcode for keys
    }

    @Override
    public boolean equals(Object obj) { // equal method to check the right key for get and put operations
        if (this == obj)
            return true;
        if (this == null || getClass() != obj.getClass())
            return false;
        Key key = (Key) obj;
        return value.equals(key.value);
    }
}

class Main {
    public static void main(String[] args) {
        HashMap<Key, String> hashMap = new HashMap<>();
        hashMap.put(new Key("key 1"), "value 1");
        hashMap.put(new Key("key 2"), "value 2");
        hashMap.put(new Key("key 3"), "value 3");
        // adding the values in the hash map with Key as the Key's class object.
        // since we have overriden the hashCode() and equals() method in Key class
        // hashMap will use those function

        hashMap.get(new Key("key 1")); // value 1
        hashMap.get(new Key("key 2")); // value 2
        hashMap.get(new Key("key 3")); // value 3
        // we are creating a new instance of Key class but still we are getting the
        // correct values for the keys. This is due to euqals method.

        /*
         * Before putting them into hashMap
         * index 1 -> key 1, value 1
         * index 2 -> key 2, value 2
         * index 3 -> key 3, value 3
         * 
         * After putting them into hashMap due to hashCode() methods collison happens
         * and they are put into the same bucket
         * index 1 -> (key 1, value 1)-> (key 2,value 2)->(key 3,value 3) (Linked List
         * structure)
         * In java 8 instead linked list balanced binary tress are used
         */

        /**
         * For key's with same hashCode()
         * The T(C) = O(n) -> retrival time of linked list
         * In trees T(c) = O(logn) retrieval time of Binary Trees
         */

    }
}