package com.lvdong.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by lvdong on 2017/4/12.
 */
public class OverrideCollection {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();

        map.put(1,1);
        map.put(1,1);
        map.put(1,1);
        map.put(null,2);
//        map.put(null,null);
        map.remove(1,1);
        Object o = map.get(null);
        System.out.println(o);

//        Map<String, String> myHashMap = new MyHashMap<>();
//
//        Map m = Collections.synchronizedMap(new HashMap<String,String>());
//
//        Map map2 = Collections.unmodifiableMap(map);



        ArrayList list = new ArrayList<>();
        list.add(1);

        ConcurrentMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
class MyHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>{
    private int size;
    private transient Set<Entry<K,V>> entrySet;

    @Override
    public Set<Entry<K,V>> entrySet() {
        return entrySet == null?new MyEntrySet():entrySet();
    }
    final class MyEntrySet extends AbstractSet<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new MyEntrySetIterator();
        }

        @Override
        public int size() {
            return size;
        }
    }
    abstract class MyHashIterator{
        public final boolean hashNext(){
            return false;
        }
    }

    final class MyEntrySetIterator extends MyHashIterator implements Iterator<Entry<K,V>> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Entry<K, V> next() {
            return null;
        }

    }



    class MyNode<K,V> implements Entry<K,V>{
        final int hash;
        final K key;
        V value;
        MyNode<K,V> next;

        public MyNode(int hash, K key, V value, MyNode<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }
}
