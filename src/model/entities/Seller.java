package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer Id;
    private String Name;
    private String Email;
    private Date birthDate;
    private Double baseSalary;

    private Department department;

    public Seller() {}

    public Seller(Integer id, Date birthDate, String name, String email, Double baseSalary, Department department) {
        Id = id;
        this.birthDate = birthDate;
        Name = name;
        Email = email;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(Id, seller.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", birthDate=" + birthDate +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }
}
