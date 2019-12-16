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

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "t_id")
//    private Long tId;
//    @Column(name = "t_name")
//    private String tName;
//    //配置老师和学生一对多
//    /**
//     * 注解配置多表关系
//     *  1,声名关系
//     *  2,配置外键,或者中间表
//     *  OneToMany配置一对多
//     *      targetEntity设置对应的实体类的类型
//     *  JoinColumn 配置外键
//     *      name:外键的名称,
//     *      referencedColumnName参照的主表的主键字段名称
//     */
//    @OneToMany(targetEntity = Student.class)
//    @JoinColumn(name = "s_t_id",referencedColumnName = "t_id")
//    private Set<Student> students = new HashSet<>();

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

    /*Department和User为一对多关系，而且当前类型对应的是User的Department数据成员	且实现所有的级联操作，并且加载集合中的数据（子项)为延迟加载*/
//    @OneToMany(mappedBy="department",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    @OrderBy(value="userid ASC")//加入到集合中的User对象按照userid排序
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
