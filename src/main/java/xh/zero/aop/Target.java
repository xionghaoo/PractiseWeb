package xh.zero.aop;

import org.springframework.stereotype.Component;

@Component("target")
public class Target {
    public void save() {
        System.out.println("save running");
    }
}
