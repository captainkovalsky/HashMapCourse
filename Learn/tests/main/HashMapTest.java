package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void testPut() throws Exception {
        IHashMapable map = new HashMap();

        HashableObject obj = new HashableObject((long) 45.4444, 4);

        boolean status = map.put(obj);

        int size = map.size();
        assertEquals(1, size);
        assertTrue(status);
    }

    @Test
    public void testEmptySize() throws Exception {
        IHashMapable map = new HashMap();
        HashableObject obj = new HashableObject((long) 343.3, 3);

        map.put(obj);
        assertEquals(0, map.size());
    }

    @Test
    public void testNotEmptySize() throws Exception {
        IHashMapable map = new HashMap();
        HashableObject obj = new HashableObject((long) 343.3, 3);

        map.put(obj);
        assertTrue(map.size() > 0);
    }

    @Test
    public void testGet() throws Exception {
        IHashMapable map = new HashMap();
        int key = 3;
        long value = (long) 434.34;
        HashableObject obj = new HashableObject(value, key);

        map.put(obj);

        HashableObject retrieved = map.get(key);

        assertTrue(retrieved.getKey() == key); //@TODO: equals should be overriden
        assertTrue(retrieved.getValue() == value);
    }
}