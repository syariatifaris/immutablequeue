package imqueue;

import java.util.NoSuchElementException;

public class QueueImpl<T> implements Queue<T>{
    private Stack<T> order;
    private Stack<T> back;

    private QueueImpl(Stack<T> order, Stack<T> back) {
        this.order = order;
        this.back = back;
    }

    public QueueImpl() {
        this.order = Stack.emptyStack();
        this.back = Stack.emptyStack();
    }

    public QueueImpl<T> enQueue(T t) {
        if (null == t)
            throw new IllegalArgumentException();
        return new QueueImpl<T>(this.order.push(t), this.back);
    }

    public QueueImpl<T> deQueue() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (!this.back.isEmpty()) {
            return new QueueImpl<T>(this.order, this.back.tail);
        } else {
            return new QueueImpl<T>(Stack.emptyStack(), this.order.getPrevStack().tail);
        }
    }

    public T head(){
        return this.order.head;
    }

    public boolean isEmpty() {
        return this.order.size + this.back.size == 0;
    }

    private static class Stack<E> {
        private E head;
        private Stack<E> tail;
        private int size;

        private Stack(E obj, Stack<E> tail) {
            this.head = obj;
            this.tail = tail;
            this.size = tail.size + 1;
        }

        public static Stack emptyStack() {
            return new Stack();
        }

        private Stack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public Stack<E> getPrevStack() {
            Stack<E> stack = new Stack<E>();
            Stack<E> tail = this;
            while (!tail.isEmpty()) {
                stack = stack.push(tail.head);
                tail = tail.tail;
            }
            return stack;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public Stack<E> push(E obj) {
            return new Stack<E>(obj, this);
        }
    }

    private void reset() {
        this.back = this.order.getPrevStack();
        this.order = Stack.emptyStack();
    }
}
