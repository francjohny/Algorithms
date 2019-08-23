package ImmutableQueue;

/**
 * ImmutableStack is an implementation of the Stack interface with the following properties:
 * 1. head - a reference to the top of the stack
 * 2. tail - a reference to the stack without the top element
 * @param <T>
 */
public class ImmutableStack<T> implements Stack<T> {
    private T head;
    private ImmutableStack<T> tail;

    ImmutableStack() {
        this.head = null;
        this.tail = null;
    }

    private ImmutableStack(T head, ImmutableStack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * push adds a new element to the top of the stack by creating a new stack with the newly added element as its head.
     * @param t element to be added to the stack
     * @return A new stack with the element 't' added to the top of the stack.
     */
    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<>(t, this);
    }

    /**
     * pop removes an element from the top of the stack by creating a new stack without the head of the stack.
     * @return A new stack without the head element at the top of the stack.
     */
    @Override
    public Stack<T> pop() {
        return this.tail;
    }

    /**
     * peak retrieves the element at the head of the stack.
     * @return Element at the top of the stack.
     */
    @Override
    public T peek() {
        return this.head;
    }

    /**
     * isEmpty checks if a stack is empty by checking if both its head and tail are empty.
     * @return True if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    /**
     * reverse is used to reverse the elements of an existing stack by creating a new stack
     * with the elements inserted the other way round
     * @return A new stack with the elements reversed.
     */
    @Override
    public Stack<T> reverse() {
        Stack<T> tmp = this;
        Stack<T> result = new ImmutableStack<>();
        while (!tmp.isEmpty()) {
            result = result.push(tmp.peek());
            tmp = tmp.pop();
        }
        return result;
    }
}
