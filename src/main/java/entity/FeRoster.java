package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
@XmlRootElement
 public class FeRoster implements Serializable {
  Driver driver;
  ArrayList<FeRoute> feRoutes;

}
