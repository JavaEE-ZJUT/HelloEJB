package cn.xyy.ejb2.dao.jpql;


import java.util.List;
import javax.ejb.Remote;
import cn.xyy.ejb2.User;

@Remote
public interface JPQLUserDAORemote {
    public boolean insert(User user);
    public boolean update(User user);
    public boolean deleteById(int userid);
    public User selectById(int userid);
    public List<User> list(int pageSize, int pageNo);
}