package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DriverService;

@Controller
@RequestMapping(value = "/")
public class DriverController {
    DriverService driverService = new DriverService();

    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public String getDrivers(ModelMap modelMap) {
        modelMap.put("drivers", driverService.getListDriver());
        return "resources/views/driver";
    }

  @RequestMapping(value = "driver/delete", method = RequestMethod.GET)
  public String deleteDriver( @RequestParam("id") Integer id) {
    driverService.removeStudent(id);
    return "redirect:/driver";
  }


  @RequestMapping(value = "/driver/update", method = RequestMethod.GET)
  public String update(ModelMap modelMap, @RequestParam("id") Integer id) {
    modelMap.put("driver", driverService.findID(id));
    return "resources/views/driverform";
  }


}
