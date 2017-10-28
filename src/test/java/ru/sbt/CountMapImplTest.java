package ru.sbt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Дмитрий on 29.10.2017.
 */
public class CountMapImplTest {
    @Test
    public void testGetCountAndSize(){
        CountMap<Integer> from = new CountMapImpl<>();
        from.add(10);
        from.add(10);
        from.add(5);
        from.add(6);
        from.add(5);
        from.add(10);

        assertEquals(1, from.getCount(6));
        assertEquals(2, from.getCount(5));
        assertEquals(3, from.getCount(10));

        assertEquals(3, from.size());
    }

    @Test
    public void testAddAll(){
        CountMap<Number> to = new CountMapImpl<>();
        to.add(1.0d);
        to.add(2.0d);
        to.add(3.0d);
        to.add(4.0d);
        to.add(4.0d);
        to.add(4.0d);
        to.add(4.0d);
        to.add(5.0d);

        CountMap<Integer> from = new CountMapImpl<>();
        from.add(5);
        from.add(5);
        from.add(6);
        from.add(10);
        from.add(10);
        from.add(10);

        HashMap<Number,Integer> result = new HashMap<>();
        result.put(1.0d,1);
        result.put(2.0d,1);
        result.put(3.0d,1);
        result.put(4.0d,4);
        result.put(5.0d,1);
        result.put(5,2);
        result.put(6,1);
        result.put(10,3);

        to.addAll(from);
        assertEquals(to.toMap(), result);
    }

    @Test
    public void testDestination() throws Exception {
        CountMap<Number> map = new CountMapImpl<>();
        map.add(1.0d);
        map.add(2.0d);
        map.add(3.0d);
        map.add(4.0d);
        map.add(4.0d);
        map.add(4.0d);
        map.add(4.0d);
        map.add(5.0d);

        Map<Number, Integer> copy = new HashMap<>();
        map.toMap(copy);
        assertEquals(map.toMap(), copy);
    }
}