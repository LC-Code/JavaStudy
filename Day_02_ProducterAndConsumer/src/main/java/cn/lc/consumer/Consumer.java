package cn.lc.consumer;

import cn.lc.massage.Massage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer implements Runnable{
    private Massage msg;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       msg.get();
        }

    }
}
