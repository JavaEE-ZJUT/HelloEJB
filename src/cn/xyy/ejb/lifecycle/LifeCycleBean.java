package cn.xyy.ejb.lifecycle;

import javax.ejb.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.Remove;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful(name = "LifeCycleEJB")
@Remote(LifeCycleRemote.class)

public class LifeCycleBean implements LifeCycleRemote {
    public LifeCycleBean() { }

    public String hello(String name) {
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello" + name + "!";
    }

    @Init
    public void init() {
        System.out.println("@Init 事件触发");
    }

    @PostConstruct
    public void construct() {
        System.out.println("@PostConstruct 事件触发");
    }

    @PreDestroy
    public void exit() {
        System.out.println("@PreDestroy 事件触发");
    }

    @PostActivate
    public void activate() {
        System.out.println("@PostActivate 事件触发");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("@prePassivate 事件触发");
    }

    @Remove
    public void removeSession() {
        System.out.println("@remove 事件触发");
    }
}