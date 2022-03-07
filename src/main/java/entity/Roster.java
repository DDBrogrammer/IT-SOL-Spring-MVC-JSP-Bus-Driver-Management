package entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@XmlRootElement
@NoArgsConstructor
@Table(name = "roster")
@Component
public class Roster implements Serializable {
    @Id
    @ManyToOne(targetEntity = Driver.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    Driver driver;

    @Id
    @ManyToOne(targetEntity = Route.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    Route route;

   @Column(name="total_route", nullable = false )
   int totalRoute;

    public Roster(Driver driver, Route route, int totalRoute) {
        this.driver = driver;
        this.route = route;
        this.totalRoute = totalRoute;
    }

    @Autowired
    public Roster(Driver driver, Route route) {
        this.driver = driver;
        this.route = route;
    }
}
