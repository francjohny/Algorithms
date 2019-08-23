package ImmutableQueue;

/**
 * ImmutableQueue is an implementation of the Queue interface with the help of 2 stacks:
 * 1) front - to dequeue/remove elements from the front of the queue.
 * 2) back - to enqueue/add elements to the back of the queue.
 * @param <T>
 */
public class ImmutableQueue<T> implements Queue<T> {
    private Stack<T> front;
    private Stack<T> back;

    ImmutableQueue() {
        this.front = new ImmutableStack<>();
        this.back = new ImmutableStack<>();
    }

    private ImmutableQueue(Stack<T> front, Stack<T> back) {
        this.front = front;
        this.back = back;
    }

    /**
     * enQueue inserts an element to the back of the queue by pushing elements to the 'back' stack.
     * @param t element to be inserted to the queue
     * @return A new queue with the element 't' inserted at the back of the queue.
     */
    @Override
    public Queue<T> enQueue(T t) {
        System.out.printf("Enqueue: %s%n", t);
        return new ImmutableQueue<>(this.front, this.back.push(t));
    }

    /**
     * deQueue removes elements from the front of the queue by popping elements from the 'front' stack.
     * In the case where the 'front' stack is empty, elements from the 'back' stack are popped and
     * pushed to the 'front' stack, and then popped.
     * @return A new queue with element at the front of the queue removed.
     */
    @Override
    public Queue<T> deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, no elements to dequeue.");
            return new ImmutableQueue<>(this.front, this.back);
        }
        if (this.front.isEmpty()) {
            final Stack<T> newFront = this.back.reverse();
            System.out.printf("Dequeue: %s%n", newFront.peek());
            return new ImmutableQueue<>(newFront.pop(), new ImmutableStack<>());
        }
        System.out.printf("Dequeue: %s%n", this.front.peek());
        return new ImmutableQueue<>(this.front.pop(), this.back);
    }

    /**
     *
     * @return Element at the front of the queue.
     */
    @Override
    public T head() {
        if (!this.front.isEmpty()) {
            return this.front.peek();
        }
        return this.back.reverse().peek();
    }

    /**
     * Checks if queue is empty.
     * @return True if queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.front.isEmpty() && this.back.isEmpty();
    }
}
