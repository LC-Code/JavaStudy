package cn.lc.main;

import cn.lc.consumer.Consumer;
import cn.lc.massage.Massage;
import cn.lc.producter.Producter;

public class Main {
    public static void main(String[] args) {
        Massage msg = new Massage();
        new Thread(new Producter(msg),"生产者").start();
        new Thread(new Consumer(msg),"消费者").start();
    }
}
