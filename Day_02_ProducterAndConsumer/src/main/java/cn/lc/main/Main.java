package cn.lc.main;

import cn.lc.consumer.Consumer;
import cn.lc.massage.Massage;
import cn.lc.producter.Producter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Massage msg = new Massage();
        Thread product = new Thread(new Producter(msg),"生产者");
        product.start();
/*        Thread.sleep(10000);
        System.out.println(msg);*/
        System.out.println(product.getState());
        new Thread(new Consumer(msg),"消费者").start();
    }
}
