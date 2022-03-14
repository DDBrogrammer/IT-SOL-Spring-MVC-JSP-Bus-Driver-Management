package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
@XmlRootElement
public class FeRoute {
  Route route;
  int quantity;
}
