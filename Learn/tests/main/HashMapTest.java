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

    @Test
    public void testGetWithCollisions() throws Exception {
        IHashMapable map = new HashMap();
        int key = 3;

        map.put(new HashableObject((long) 434.34, key));
        map.put(new HashableObject((long) 666.66, key));

        assertEquals(2, map.size());

        HashableObject retrieved = map.get(key);

        assertTrue(retrieved != null);
//        System.out.println(retrieved.getKey());
//        System.out.println(retrieved.getValue());

        assertTrue(retrieved.getKey() == key); //@TODO: equals should be overriden
        assertTrue(retrieved.getValue() == (long) 666.66);
    }
}