package org.example;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K,V>{

    int capacity;
    Map<K, Node<K,V>> cache;
    Node<K,V> head;
    Node<K,V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node<>(null,null);
        this.tail = new Node<>(null,null);

        head.next=tail;
        tail.prev=head;
    }

    V getValue(K key){
        if(cache.get(key)==null){
            return null;
        }

        Node<K,V> node = cache.get(key);
        moveToHead(node);

        return node.value;
    }

    void put(K key, V value){

        if(cache.get(key)==null){

            if(cache.size()>=capacity){
                removeFromTail();
            }

            Node<K,V> node= new Node<>(key,value);
            cache.put(key, node);

            addToHead(node);
        }
        else{

            Node<K,V> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeFromTail() {
        Node<K,V> tailNode = tail.prev;
        cache.remove(tailNode.key);
        System.out.println("Removed "+tailNode.key);
        removeNode(tailNode);
    }

    void moveToHead(Node<K,V> node){

        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K,V> node) {

        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addToHead(Node<K,V> node) {
        head.next.prev=node;
        node.next = head.next;

        head.next=node;
        node.prev=head;
    }


}
