package cn.lc.massage;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Massage {

    private String name;
    private String content;
    private boolean flag = true;
    // flag = true 生产者可以生产，消费者不能够消费
    // flag = false 生产者不能够生产，消费者可以消费

    @Synchronized
    public synchronized void set(String name, String content) {
        if (!this.flag) { //不能生产，需要等待消费者消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
       this.flag = false;  // 生产结束，允许消费
       super.notify(); //唤醒等待的消费者线程

    }

    @Synchronized
    public synchronized String get() {
        if(this.flag){ //不能消费，需要等待生产者生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
        return this.name + "  --  " + this.content;

        }finally {
            this.flag = true;  //继续生产，
            super.notify(); //唤醒等待的生产者
        }
    }
}
