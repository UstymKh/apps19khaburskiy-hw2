package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] arr;

    public ImmutableArrayList() {
        this.arr = new Object[0];
    }

    private ImmutableArrayList(Object[] elements) {
        this.arr = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return this.addAll(this.size(), new Object[]{e});
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return this.addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        Object[] new_arr = new Object[this.size() + c.length];
        int i_original_array = 0;
        for (int i = 0; i < new_arr.length; i += 1) {
            if (i == index) {
                for (Object o : c) {
                    new_arr[i] = o;
                    i += 1;
                }
            }
            if (i>=new_arr.length) {
                break;
            }
            new_arr[i] = this.arr[i_original_array];
            i_original_array += 1;
        }
        return new ImmutableArrayList(new_arr);
    }

    @Override
    public Object get(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        return this.arr[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        Object[] new_arr = new Object[this.size() - 1];
        for (int i = 0; i < new_arr.length; i += 1) {
            if (i >= index) {
                new_arr[i] = this.arr[i + 1];
            } else {
                new_arr[i] = this.arr[i];
            }
        }
        return new ImmutableArrayList(new_arr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index >= this.arr.length) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        Object[] new_arr = new Object[this.size()];
        new_arr[index] = e;
        return new ImmutableArrayList(new_arr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i += 1) {
            if (this.arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.arr.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() != 0;
    }

    @Override
    public Object[] toArray() {
        return this.arr;
    }
}
