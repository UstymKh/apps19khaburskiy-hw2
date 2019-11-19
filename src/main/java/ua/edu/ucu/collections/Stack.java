package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    Stack() {
        this.stack = new ImmutableLinkedList();
    }

    Object peek() {
        return stack.getLast();
    }

    Object pop() {
        Object last = this.peek();
        this.stack = this.stack.removeLast();
        return last;
    }

    void push(Object e) {
        this.stack = this.stack.addLast(e);
    }
}
