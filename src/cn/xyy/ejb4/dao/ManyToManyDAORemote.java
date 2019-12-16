package cn.xyy.ejb4.dao;

import cn.xyy.ejb4.Role;
import cn.xyy.ejb4.UserUser;

import javax.ejb.Remote;

@Remote
public interface ManyToManyDAORemote {
    public boolean insertUser(UserUser user);
    public UserUser getUserById(Integer id);
    public boolean insertRole(Role role);
    public Role getRoleById(Integer id);
}
