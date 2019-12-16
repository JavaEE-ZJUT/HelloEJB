package cn.xyy.ejb4;

import cn.xyy.ejb2.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name="useruser",schema = "public")
public class UserUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useruser_id")
    private Integer useruserId;

    @Column(name = "useruser_name")
    private String useruserNAme;

    @ManyToMany(targetEntity = Role.class, mappedBy = "userusers", cascade=CascadeType.ALL)
    private Set<Role> roles = new HashSet<Role>();


    public Integer getUseruserId() { return useruserId; }
    public void setUseruserId(Integer useruserId) { this.useruserId = useruserId; }

    public String getUseruserNAme() { return useruserNAme; }
    public void setUseruserNAme(String useruserNAme) { this.useruserNAme = useruserNAme; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }

    //增加两个方法，作用为向roles集合中添加和删除role对象
    public void addNewRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
            role.getUserusers().add(this);
        }
    }
    public void removeRole(Role role){
        role.getUserusers().remove(role);
        this.getRoles().remove(role);
    }
}
