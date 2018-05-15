package pl.coderstrust.multithreading_magazine;

public interface MyBlockingQueue<E> {

    void put(E element) throws InterruptedException;

    E take() throws InterruptedException;

    int size();
}
