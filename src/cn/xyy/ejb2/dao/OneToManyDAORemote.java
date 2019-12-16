package cn.xyy.ejb2.dao;


import java.util.List;
import javax.ejb.Remote;
import cn.xyy.ejb2.Department;
import cn.xyy.ejb2.User;

@Remote
public interface OneToManyDAORemote {
    public boolean inserDepartment(Department department);
    public Department getDepartmentById(Integer departmentid);
}