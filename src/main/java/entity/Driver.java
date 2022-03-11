package entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
@AllArgsConstructor
@Table(name = "driver")
@Component
public class Driver implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Id
    @Column(nullable = false)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "address",nullable = false)
    String address;

    @Column( name = "phone",nullable = false)
    String phone;

    public Driver(String name, String address, String phone, String skill) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.skill = skill;
    }

  public Driver(Integer id, String name, String address, String phone, String skill) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.skill = skill;
    this.id=id;
  }

    public Driver() {

    }

    @Column(name = "skill_level",nullable=false)
    String skill;

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Roster> rosters;
}

