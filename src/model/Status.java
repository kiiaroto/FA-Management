package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SR
 */
public class Status {

    private static Map<Integer, String> values;

    public Status() {
    }

    public static Map<Integer, String> getValues() {
        return values;
    }

    public static int getKey(String value) {
        for (Integer i : values.keySet()) {
            if (values.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    static {
        values = new HashMap<Integer, String>();
    }
}
