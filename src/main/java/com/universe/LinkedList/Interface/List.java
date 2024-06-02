package main.java.com.universe.LinkedList.Interface;

import main.java.com.universe.LinkedList.LinkedList;

public interface List<T> {
    void addFirst(T Element);
    void addLast(T Element);
    boolean add(T Element);
    T getFirst();
    T getLast();
    void getAll();
    void removeByIndex(int Id);
    void add(int index, T element);
    void removeFirst();
    void removeLast();
    void removeAll();
    int getSize();


}
