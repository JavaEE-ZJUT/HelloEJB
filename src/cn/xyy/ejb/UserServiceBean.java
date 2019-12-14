package cn.xyy.ejb;

import javax.ejb.Remote;

@javax.ejb.Stateless(name = "UserServiceEJB")
@Remote(UserServiceRemote.class)

public class UserServiceBean implements UserServiceRemote {
    public UserServiceBean() { }
    public boolean login(String username, String password) {
        if (username.equals("zjut")&&password.equals("zjut")) {
            return true;
        } else
            return false;
    }
}
