package cn.xyy.ejb4.dao;

import cn.xyy.ejb4.Role;
import cn.xyy.ejb4.UserUser;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class ManyToManyDAO implements ManyToManyDAORemote {
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "useruserpu")
    EntityManager em;

    @Override
    public boolean insertUser(UserUser user) {
        try {
            em.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserUser getUserById(Integer id) {
        return null;
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "rolepu")
    EntityManager em2;
    @Override
    public boolean insertRole(Role role) {
        try {
            em2.persist(role);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Role getRoleById(Integer id) {
        return null;
    }
}
