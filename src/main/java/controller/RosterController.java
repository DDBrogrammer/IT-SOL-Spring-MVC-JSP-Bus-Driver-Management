package controller;


import entity.Driver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.RosterService;

@Controller
public class RosterController {
  RosterService rosterService = new RosterService();

  @RequestMapping(value = "/roster", method = RequestMethod.GET)
  public String index(ModelMap modelMap) {
    modelMap.put("feRosters", rosterService.getListRoster());
    return "resources/views/roster";
  }

}

