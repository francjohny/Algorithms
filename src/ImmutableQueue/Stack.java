package ImmutableQueue;

/**
 * Stack is an interface for a generic immutable LIFO (Last In First Out) data structure with the operations:
 * 1. push(): to insert an element at the top of the immutable stack, and return a new stack.
 * 2. pop(): to remove an element from the top of the immutable stack, and return a new stack.
 * 3. peek(): to retrieve the element at the top of the immutable stack.
 * 4. isEmpty(): to check if the immutable stack is empty.
 * 5. reverse(): to reverse a immutable stack, and return a new stack.
 * @param <T>
 */
public interface Stack<T> {
    public Stack<T> push(T t);
    public Stack<T> pop();
    public T peek();
    public boolean isEmpty();
    public Stack<T> reverse();
}
