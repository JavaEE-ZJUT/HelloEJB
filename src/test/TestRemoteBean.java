package test;

import javax.ejb.Remote;

@javax.ejb.Stateless(name = "TestRemoteEJB")
@Remote(Hello.class)
public class TestRemoteBean implements Hello{
    public TestRemoteBean() { }
    @Override
    public String say() {
        return "Hello World";
    }
}
