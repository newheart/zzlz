package com.xinxin.zzlz.cache;

/**
 * @Description: 双链表
 * @Date: 2020/5/8
 * @Version: 1.0
 */
public class DoubleList {
    private Node head, tail; //头尾虚节点
    private int size; //链表元素数

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public int size(){return size;}

    //删除链表中的节点x,(x一定存在)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //将节点x移动到链表表头
    public void moveToFirst(Node x) {
        if(x.prev == head){//已在链表头
            return;
        }
        //处理x前后节点
        x.prev.next = x.next;
        x.next.prev = x.prev;
        //移动到头部
        x.next = head.next;
        x.prev = head;
        head.next = x;

    }
    //增加头部节点x
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }
    //删除链表尾节点
    public Node removeLast() {
        if(tail.prev == head){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }
}
