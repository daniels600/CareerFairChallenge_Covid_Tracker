package Challenge;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapList {
    HashMap<String, ArrayList<String>> strings = new HashMap<String, ArrayList<String>>();

    public void add(String key, String value) {
        ArrayList<String> values = strings.get(key);
        if (values == null) {
            values = new ArrayList<String>();
            strings.put(key, values);
        }

        values.add(value);
    }

    public ArrayList<String> get(String key) {
        return strings.get(key);
    }

    public static void main(String[] argv) {
        HashMapList mymap = new HashMapList();

        mymap.add("key", "value1");
        mymap.add("key", "value2");

        ArrayList<String> values = mymap.get("key");
        for (String value : values) {
            System.out.println(value);
        }
    }
}
