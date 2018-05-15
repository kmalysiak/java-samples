package pl.coderstrust.multithreading_magazine;

public class Main {

    public static void main(String[] args) {
        MyBlockingQueue<Product> queue = new MyArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue, 500);
        Consumer consumer = new Consumer(queue, 1000);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}