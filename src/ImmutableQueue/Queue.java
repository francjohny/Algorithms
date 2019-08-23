package ImmutableQueue;

/**
 * Queue is an interface for a generic immutable FIFO (First In First Out) data structure with the operations:
 * 1. enQueue(): to insert an element at the end of the immutable queue, and return a new queue.
 * 2. deQueue(): to remove the first element at the beginning of the immutable queue, and return a new queue.
 * 3. head(): to retrieve the element at the beginning of the immutable queue.
 * 4. isEmpty(): to check if the immutable queue is empty.
 * @param <T>
 */
public interface Queue<T> {
    public Queue<T> enQueue(T t);
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}

