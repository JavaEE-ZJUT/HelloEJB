package cn.xyy.ejb2;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "department")

public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "departmentid")
    private Integer departmentid;

    @Column(name = "departmentname")
    private String departmentname;

    @OneToMany(targetEntity = User.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @OrderBy(value="userid ASC")
    @JoinColumn(name = "departmentid",referencedColumnName = "departmentid")
    private Set<User> users=new HashSet<User>();

    public Department() { }


    public Integer getDepartmentid() { return departmentid; }
    public void setDepartmentid(Integer departmentid) { this.departmentid = departmentid; }

    public String getDepartmentname() {
        return departmentname;
    }
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }


    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) { this.users = users; }

    //增加两个方法，作用为向users集合中添加和删除User对象
    public void addNewUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
            user.setDepartment(this);
        }
    }
    public void removeUser(User user){
        user.setDepartment(null);
        this.users.remove(user);
    }
}
