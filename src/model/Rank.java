/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SR
 */
public class Rank {

    private static Map<Integer, String> values;

    public Rank() {
    }

    public static Map<Integer, String> getValues() {
        return values;
    }

    public static int getKey(String value) {
        for (Integer i : values.keySet()) {
            System.out.println(i + " : " + values.get(i));
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
