package controller;

import entity.Driver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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

  @RequestMapping(value = "/driver/add", method = RequestMethod.GET)
  public ModelAndView add() {
      return  new ModelAndView("resources/views/driverform","driver",new Driver());
  }

  @RequestMapping(value = "/driver/add", method = RequestMethod.POST)
  public String doAdd(@ModelAttribute("driver") Driver driver) {
  Driver tempDriver=new Driver(driver.getName(),driver.getAddress(),driver.getPhone(),driver.getSkill());
    System.out.println(driverService.save(tempDriver));
    return "redirect:/driver";
  }

  @RequestMapping(value = "/driver/edit", method = RequestMethod.POST)
  public String doEdit(@ModelAttribute("driver") Driver driver) {
    driverService.update(driver);
    return "redirect:/driver";
  }

  @RequestMapping(value = "/driver/edit", method = RequestMethod.GET)
  public ModelAndView edit( @RequestParam("id") Integer id) {
      return new ModelAndView("resources/views/driverform","driver",driverService.findID(id));
  }

}
