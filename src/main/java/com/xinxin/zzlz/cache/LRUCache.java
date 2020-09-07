package com.xinxin.zzlz.cache;

import java.util.HashMap;

/**
 * 哈希链表实现LRU
 */
public class LRUCache {
    //key -> Node(key,value)
    private HashMap<Integer,Node> map;
    //Node<k1,v1> <-> Node<k2,v2>...
    private DoubleList cache;
    //最大容量
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).value;
        //利用put方法把该数据提前
        cache.moveToFirst(map.get(key));
        return val;
    }

    private void put(int key, int val) {
        Node x = new Node(key,val);

        if(map.containsKey(key)){
            //删除旧节点，增加新节点到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            //更新map中数据
            map.put(key,x);
        }else {
            if (capacity == cache.size()){
                //删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println("get(1):"+ cache.get(1));
        System.out.println("get(2):"+ cache.get(2));

        cache.put(5,5);
        System.out.println("get(3):"+ cache.get(3));
    }
}

