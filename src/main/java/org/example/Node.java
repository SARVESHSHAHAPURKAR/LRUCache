package org.example;

public class Node<K, V> {

    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;

    Node(K key, V val){
        this.key= key;
        this.value = val;
        prev=null;
        next=null;
    }
}
