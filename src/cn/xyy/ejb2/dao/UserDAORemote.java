package cn.xyy.ejb2.dao;

import cn.xyy.ejb2.User;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UserDAORemote {
    public List<User>  select(String sql);
    public boolean insert(User user);
}