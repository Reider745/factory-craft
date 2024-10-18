package com.reider745.factorycraft.api;

import java.util.HashMap;

public class ItemType {
    private static final HashMap<Integer, String> types = new HashMap<>();

    public static String get(int id){
        return types.get(id);
    }

    public static boolean is(int id, String type){
        return type.equals(get(id));
    }

    public static void set(int id, String type){
        if(id != -1)
            types.put(id, type);
    }

    public static void remove(int id){
        types.remove(id);
    }
}
