package infra;

import businessObjects.User;

import java.util.HashMap;
import java.util.Map;

public class MemoryDB {
    public static Map<Integer, User> inMemoryDB = new HashMap<>();
}
