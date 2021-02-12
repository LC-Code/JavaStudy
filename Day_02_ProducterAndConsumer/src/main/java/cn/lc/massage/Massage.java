package cn.lc.massage;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;

@Setter
@Getter
public class Massage {

    private String name;
    private String content;

    @Synchronized
    public void set(String name, String content) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
    }

    @Synchronized
    public void get() {
        System.out.println(this.name + "  --  " + this.content);
    }
}
