package cn.xyy.ejb.lifecycle;

public interface LifeCycleRemote {
    public String hello(String name);
    public void removeSession();
}
