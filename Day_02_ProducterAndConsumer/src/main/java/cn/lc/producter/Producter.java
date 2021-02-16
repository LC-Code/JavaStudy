package cn.lc.producter;

import cn.lc.massage.Massage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producter implements Runnable {
    private Massage msg;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                msg.set("LC", "ha...ha...ha...");
                System.out.println(Thread.currentThread().getName()+" 生产 LC");


            } else {

                msg.set("LK", "hei...hei...hei");
                System.out.println(Thread.currentThread().getName()+" 生产 LK");

            }
        }

    }
}
