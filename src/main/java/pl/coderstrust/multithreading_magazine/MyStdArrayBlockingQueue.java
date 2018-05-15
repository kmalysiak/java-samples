package pl.coderstrust.multithreading_magazine;

import java.util.concurrent.ArrayBlockingQueue;

public class MyStdArrayBlockingQueue<E> extends ArrayBlockingQueue<E>
        implements MyBlockingQueue<E> {

    public MyStdArrayBlockingQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void put(E element) throws InterruptedException {
        super.put(element);
    }

    @Override
    public E take() throws InterruptedException {
        return super.take();
    }

    @Override
    public int size() {
        return super.size();
    }
}
