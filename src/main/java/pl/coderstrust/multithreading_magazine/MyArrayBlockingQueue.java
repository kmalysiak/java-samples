package pl.coderstrust.multithreading_magazine;

import java.util.ArrayList;
import java.util.List;

public class MyArrayBlockingQueue<E> implements MyBlockingQueue<E> {

    private List<E> data = new ArrayList<>();
    private int maxCapacity = 0;

    public MyArrayBlockingQueue(int capacity) {
        this.maxCapacity = capacity;
    }

    @Override
    public synchronized void put(E element) throws InterruptedException {
        while (data.size() == maxCapacity) {
            wait();
        }
        data.add(element);
        System.out.println("Queue - On stock: "+data.size() + " products.");
        notify();
    }

    @Override
    public synchronized E take() throws InterruptedException {
        while (data.isEmpty()) {
            wait();
        }
        E removedItem = data.remove(0);
        System.out.println("Queue - On stock: "+data.size() + " products.");
        notify();
        return removedItem;

    }

    @Override
    public int size() {
        return data.size();

    }
}