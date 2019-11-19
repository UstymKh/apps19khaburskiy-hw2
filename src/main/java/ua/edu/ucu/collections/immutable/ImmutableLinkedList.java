package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node end;
    private int size;

    private static class Node {
        private Node next;
        private Object item;

        Node(Object item) {
            this.item = item;
            this.next = null;
        }

        Node getNext() {
            return this.next;
        }

        Object getItem() {
            return this.item;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void setItem(Object item) {
            this.item = item;
        }
    }

    public ImmutableLinkedList() {
        this.size = 0;
        this.head = null;
        this.end = null;
    }

    private ImmutableLinkedList(Object[] elements) {
        this.head = new Node(elements[0]);
        this.size = elements.length;
        Node current = this.head;
        for (int i = 1; i < elements.length; i += 1) {
            current.setNext(new Node(elements[i]));
            current = current.getNext();
        }
        this.end = current;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return this.addAll(this.size(), new Object[]{e});
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return this.addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return this.addAll(this.size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        if (this.size == 0) {
            return new ImmutableLinkedList(c);
        }
        ImmutableLinkedList addition = new ImmutableLinkedList(c);
        ImmutableLinkedList result = new ImmutableLinkedList(this.toArray());
        result.size += c.length;
        if (index == this.size) {
            result.end.setNext(addition.head);
            result.end = addition.end;
            return result;
        }
        Node current = result.head;
        for (int i = 0; i < index - 1; i += 1) {
            current = current.getNext();
        }
        Node shift = current.getNext();
        current.setNext(addition.head);
        addition.end.setNext(shift);
        return result;
    }

    @Override
    public Object get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        Node current = this.head;
        for (int i = 0; i < index; i += 1) {
            current = current.getNext();
        }
        return current.getItem();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        ImmutableLinkedList result = new ImmutableLinkedList(this.toArray());
        result.size -= 1;
        if (index == 0) {
            result.head = result.head.getNext();
        }
        Node current = result.head;
        for (int i = 0; i < index - 1; i += 1) {
            current = current.getNext();
        }
        if (index == this.size - 1) {
            current.setNext(null);
            result.end = current;
            return result;
        }
        current = current.getNext();
        current.setItem(current.getNext().getItem());
        current.setNext(current.getNext().getNext());
        return result;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        ImmutableLinkedList result = new ImmutableLinkedList(this.toArray());
        Node current = result.head;
        for (int i = 0; i < index; i += 1) {
            current = current.getNext();
        }
        current.setItem(e);
        return result;
    }

    @Override
    public int indexOf(Object e) {
        Node current = this.head;
        int result = 0;
        while (!current.getItem().equals(e)) {
            if (current.getNext() == null) {
                return -1;
            }
            current = current.getNext();
            result += 1;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        Node current = this.head;
        for (int i = 0; i < this.size; i += 1) {
            result[i] = current.getItem();
            current = current.getNext();
        }
        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(e);
    }

    public Object getFirst() {
        return this.get(0);
    }

    public Object getLast() {
        return this.get(this.size);
    }

    public ImmutableLinkedList removeFirst() {
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return this.remove(this.size);
    }
}