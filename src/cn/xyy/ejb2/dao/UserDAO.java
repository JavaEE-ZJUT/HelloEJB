package cn.xyy.ejb2.dao;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.*;

import cn.xyy.ejb.ProductCartRemote;
import cn.xyy.ejb2.User;


@Stateful(name = "UserDAOEJB")
@Remote(UserDAORemote.class)
public class UserDAO implements UserDAORemote {
    @PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="userpu")
    EntityManager em;
    public UserDAO() { }

    @Override
    public boolean insert(User user){
        try{
            em.persist(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> select(String sql){
        List< User> userlist=null;
        try{
            Query q=em.createQuery(sql);
            userlist=(List<User>)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return userlist;
        }
        return userlist;
    }

}