package queue;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {
    @Test
    public void enqueueTest() {
        Queue<Integer> queue = new ArrayQueue<>();
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(3, queue.getSize());
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void deenqueueTest() {
        Queue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void frontTest() {
        Queue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(Integer.valueOf(1), queue.front());
        Assert.assertEquals(3, queue.getSize());

        Assert.assertEquals(Integer.valueOf(1), queue.front());
        Assert.assertEquals(3, queue.getSize());
    }

    @Test
    public void circularTest() {
        Queue<Integer> queue = new ArrayQueue<>(7);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assert.assertEquals(Integer.valueOf(5), queue.dequeue());

        queue.enqueue(8);
        queue.enqueue(9);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void circularTest2() {
        Queue<String> queue = new ArrayQueue<>(4);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
    }

    @Test
    public void fullTest() {
        Queue<Integer> queue = new ArrayQueue<>(3);

        queue.enqueue(0);
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }
}
