package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    Queue() {
        this.queue = new ImmutableLinkedList();
    }

    Object peek() {
        return this.queue.getFirst();
    }

    Object dequeue() {
        Object first = this.peek();
        this.queue = this.queue.removeFirst();
        return first;
    }

    void enqueue(Object e) {
        this.queue = this.queue.addLast(e);
    }

}
