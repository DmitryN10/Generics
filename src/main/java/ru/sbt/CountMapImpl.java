package ru.sbt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 27.10.2017.
 */
public class CountMapImpl<T> implements CountMap<T> {
    private HashMap<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        Integer count = map.get(o);
        map.remove(o);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public<E extends T> void addAll(CountMap<E> source) {
        for (E key : source.toMap().keySet()) {
            if (this.map.containsKey(key)) {
                map.put(key, map.get(key) + source.getCount(key));
            } else {
                map.put(key, source.getCount(key));
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() { return new HashMap<>(this.map);
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(this.map);
    }
}
