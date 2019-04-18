package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(450);
                ShareItem shareItem = queue.take();
                System.out.format("Processing ShareItem{description='%s', itemId=%d}", shareItem.getDescription(), shareItem.getItemId());
                System.out.println();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}