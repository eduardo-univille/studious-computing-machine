package queue;

public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E front();

    boolean isEmpty();

    int getSize();
}
