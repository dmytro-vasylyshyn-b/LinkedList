package main.java.com.universe.LinkedList;

import main.java.com.universe.LinkedList.Interface.List;

import java.util.NoSuchElementException;
import static java.lang.StringTemplate.STR;

public class LinkedList<T> implements List<T> {
    public int size = 0;
    public Node<T> first;
    public Node<T> last;

    public LinkedList() {
    }



    public void addFirst(T Element) {
        final Node<T> FirstElement = first;
        final Node<T> NewFirstNode = new Node<>(null, Element, FirstElement);
        first = NewFirstNode;
        if (FirstElement == null) {
            last = NewFirstNode;
        } else FirstElement.prev = NewFirstNode;
        size++;
    }

    public void addLast(T Element) {
        final Node<T> LastElement = last;
        final Node<T> NewLastElement = new Node<>(LastElement, Element, null);
        last = NewLastElement;
        if (LastElement == null) {
            first = NewLastElement;
        } else {
            LastElement.next = NewLastElement;
        }
        size++;
    }

    public boolean add(T Element) {
        addLast(Element);
        return true;
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("Походу пустий чи що");
        }
        return first.item;
    }

    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException("Пусто напевно");
        }
        return last.item;
    }

    public void getAll() {
        if (last == null && first == null) {
            throw new NoSuchElementException("Пусто");
        }
        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(getByIndex(i).item + ", ");
        }
        System.out.print(getLast());
        System.out.println("]");
    }


    public Node<T> getByIndex(int Id) {
        if (Id < 0 || Id > size - 1) {
            throw new IndexOutOfBoundsException("Шось не те нема тагого індексу");
        }
        if (Id <= (size / 2)) {
            Node<T> FirstElement = first;
            for (int i = 0; i < Id; i++) {
                FirstElement = FirstElement.next;
            }
            return FirstElement;

        } else {
            Node<T> LastElement = last;
            for (int i = size - 1; i > Id; i--) {
                LastElement = LastElement.prev;
            }
            return LastElement;
        }
    }

    public void removeByIndex(int Id) {
        if (Id < 0 && Id > size - 1) {
            throw new IndexOutOfBoundsException("Index " + Id + "Dos not exsist");
        }
        if (Id == 0) {
            removeFirst();
        } else if (Id == size - 1) {
            removeLast();

        } else {
            Node<T> ForDelete = getByIndex(Id);
            ForDelete.prev.next = ForDelete.next;
            ForDelete.next.prev = ForDelete.prev;
            size--;
        }
    }
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist");
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> nodeAtIndex = getByIndex(index);
            Node<T> newNode = new Node<>(nodeAtIndex.prev, element, nodeAtIndex);
            nodeAtIndex.prev.next = newNode;
            nodeAtIndex.prev = newNode;
            size++;
        }
    }


    public void removeFirst() {
        first = first.next;
        size--;
    }

    public void removeLast() {
        last = last.prev;
        size--;
    }

    public void removeAll() {
        first = null;
        last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return STR."LinkyList{Size=\{size}, First=\{first}, Last=\{last}}";
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T Element, Node<T> next) {
            this.item = Element;
            this.next = next;
            this.prev = prev;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            prev = prev;
        }

        @Override
        public String toString() {
            return STR."Noda{Item=\{item}, Next=\{next != null ? next.item : "null"}, Prev=\{prev != null ? prev.item : "null"}}";
        }
    }

}


