package cn.xyy.ejb3.dao;

import cn.xyy.ejb3.Address;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class OneToOneDAO implements OneToOneDAORemote {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "addresspu")
    EntityManager em;

    @Override
    public boolean insertAddress(Address address) {
        try {
            em.persist(address);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Address getAddressById(Integer addressdId) {
        Address address = em.find(Address.class, addressdId);
        address.getEmployee();
        return address;
    }
}
