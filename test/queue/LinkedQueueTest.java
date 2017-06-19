package queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {
    @Test
    public void enqueueTest() {
        Queue<Integer> queue = new LinkedQueue<>();
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(3, queue.getSize());
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void dequeueTest() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void frontTest() {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(Integer.valueOf(1), queue.front());
        Assert.assertEquals(3, queue.getSize());

        Assert.assertEquals(Integer.valueOf(1), queue.front());
        Assert.assertEquals(3, queue.getSize());
    }
}
