package cn.xyy.ejb2.dao;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import cn.xyy.ejb2.*;

@Stateful
public class OneToManyDAO implements OneToManyDAORemote {

    @PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="departmentpu")
    EntityManager em;

    public boolean inserDepartment(Department department){
        try{
            em.persist(department);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Department getDepartmentById(Integer departmentid) {
        Department department=em.find(Department.class, departmentid);
        department.getUsers().size();
        return department;
    }
}