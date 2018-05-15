package pl.coderstrust.multithreading_magazine;

public class Producer implements Runnable {

    private MyBlockingQueue<Product> queue;
    private int sleepingTime;
    private int productId = 0;

    public Producer(MyBlockingQueue<Product> queue, int sleepingTime) {
        this.queue = queue;
        this.sleepingTime = sleepingTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Product product = new Product("ProductID:" + productId);
                queue.put(product);
                System.out.println("NanoTime " + System.nanoTime() + ". Produced " + product.getProductId() +" NanoTime " + System.nanoTime());
                productId++;
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}