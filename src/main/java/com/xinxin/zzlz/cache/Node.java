package com.xinxin.zzlz.cache;

/**
 * @Description: 节点
 * @Date: 2020/5/8
 * @Version: 1.0
 */
public class Node {
    public int key,value;
    public Node next,prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
