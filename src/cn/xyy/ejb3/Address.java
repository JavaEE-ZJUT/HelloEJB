package cn.xyy.ejb3;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private Integer addrId;

    @Column(name = "addr_location")
    private String addrLocation;

    @OneToOne(targetEntity = Employee.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Integer getAddrId() { return addrId; }
    public void setAddrId(Integer addrId) { this.addrId = addrId; }

    public String getAddrLocation() { return addrLocation; }
    public void setAddrLocation(String addrLocation) { this.addrLocation = addrLocation; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
