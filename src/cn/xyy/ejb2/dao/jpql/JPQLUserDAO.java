package cn.xyy.ejb2.dao.jpql;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import cn.xyy.ejb2.User;

@Stateful
@LocalBean
public class JPQLUserDAO implements JPQLUserDAORemote {
    @PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="userpu")
    EntityManager em;
    public JPQLUserDAO() {    }

    public boolean insert(User user){
        try{
            em.persist(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(User user){
        try{
            em.merge(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteById(int userid){
        try{
            Query q=em.createQuery("delete from User u where u.userid=?1");
            q.setParameter(1, new Integer(userid));
            q.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User selectById(int userid){
        User user=null;
        try{
            Query q=em.createQuery("select u from User u where u.userid=?1");
            q.setParameter(1, new Integer(userid));
            user=(User)q.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return user;
        }
        return user;
    }

    public List<User> list(int pageSize, int pageNo){
        List< User> userlist=null;
        try{
            int index=(pageNo-1)*pageSize;
            Query q=em.createQuery("select u from User u order by userid asc");
            userlist=(List<User>)q.setMaxResults(pageSize).setFirstResult(index).getResultList();
            em.clear();
        }catch(Exception e){
            e.printStackTrace();
            return userlist;
        }
        return userlist;
    }
}