package queue;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public ArrayQueue() {
        array = (E[]) new Object[20];
    }

    public ArrayQueue(int size) {
        array = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            E[] temp = (E[]) new Object[array.length * 2];
            /*
             * for (j = head; j < array.length; j++) { temp[i++] = array[j]; }
             * for (j = 0; j < head; j++) { temp[i++] = array[j]; }
             */
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[(head + i) % array.length];
            }
            head = 0;
            tail = size;
            array = temp;
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
        System.out.println(Arrays.toString(array));
    }

    private boolean isFull() {
        return getSize() == array.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E e = array[head];
            array[head] = null;
            head = (head + 1) % array.length;
            size--;
            System.out.println(Arrays.toString(array));
            return e;
        }
    }

    @Override
    public E front() {
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
