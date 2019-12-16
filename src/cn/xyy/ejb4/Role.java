package cn.xyy.ejb4;

import cn.xyy.ejb2.User;
import cn.xyy.ejb3.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name="role",schema = "public")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;


    @ManyToMany(targetEntity = UserUser.class, cascade=CascadeType.ALL)
//    @JoinTable(
//        name = "user_role",
//        joinColumns = {
//            @JoinColumn(name = "useruser_id", referencedColumnName = "useruser_id")
//        },
//        inverseJoinColumns = {
//            @JoinColumn(name = "useruser_id", referencedColumnName = "useruser_id")
//        }
//    )
    private Set<UserUser> userusers = new HashSet<>();


    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public Set<UserUser> getUserusers() { return userusers; }
    public void setUserusers(Set<UserUser> userusers) { this.userusers = userusers; }

    //增加两个方法，作用为向users集合中添加和删除User对象
    public void addNewUserUser(UserUser user){
        if(!this.userusers.contains(user)){
            this.userusers.add(user);
            user.getRoles().add(this);
        }
    }
    public void removeUser(User user){
        user.setDepartment(null);
        this.userusers.remove(user);
    }
}
