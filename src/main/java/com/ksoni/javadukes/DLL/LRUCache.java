package com.ksoni.javadukes.DLL;


import java.util.HashMap;

public class LRUCache {

    public class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key,int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Integer capacity;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    HashMap<Integer, Node> nodeHashMap = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    private Integer lastSetKey;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)) {
            Node address = nodeHashMap.get(key);
            delete(address);
            insertBack(tail, address);
        }
        return hashMap.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        if(hashMap.containsKey(key)) {
            Node address = nodeHashMap.get(key);
            delete(address);
            Node newNode = new Node(key,value);
            insertBack(tail,newNode);
            nodeHashMap.put(key, newNode);
            hashMap.put(key, value);
        } else {
            if(hashMap.size() == this.capacity) {
                int removekey = head.next.key;
                hashMap.remove(removekey);
                nodeHashMap.remove(removekey);
                delete(head.next);
            }
            Node newNode = new Node(key, value);
            insertBack(tail,newNode);
            nodeHashMap.put(key, newNode);
            hashMap.put(key, value);
        }
    }

    public void insertBack(Node tail,Node newNode) {
        Node prevNode = tail.prev;
        prevNode.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        newNode.prev = prevNode;
    }

    public void delete(Node toDelete) {
        Node prevNode = toDelete.prev;
        Node nextNode = toDelete.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        toDelete.next = null;
        toDelete.prev = null;
    }
}
