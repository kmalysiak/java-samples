package pl.coderstrust.multithreading_magazine;

public class Consumer implements Runnable {

    private MyBlockingQueue<Product> queue;
    private int sleepingTime;

    public Consumer(MyBlockingQueue<Product> queue, int sleepingTime) {
        this.queue = queue;
        this.sleepingTime = sleepingTime;
    }

    @Override
    public void run() {
        try {

            while (true) {
                Product product;
                product = queue.take();
                System.out.println("NanoTime " + System.nanoTime() + ". Consumed " + product.getProductId() + " NanoTime " + System.nanoTime());
                Thread.sleep(sleepingTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}