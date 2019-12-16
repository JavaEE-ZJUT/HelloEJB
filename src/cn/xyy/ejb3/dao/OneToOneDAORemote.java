package cn.xyy.ejb3.dao;

import cn.xyy.ejb3.Address;

import javax.ejb.Remote;

@Remote
public interface OneToOneDAORemote {
    public boolean insertAddress(Address address);
    public Address getAddressById(Integer addressdId);
}
