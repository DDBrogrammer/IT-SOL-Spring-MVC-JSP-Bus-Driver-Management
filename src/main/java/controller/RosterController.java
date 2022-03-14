package controller;


import entity.Driver;

import entity.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.RosterService;
import service.RouteService;

import java.util.List;

@Controller
public class RosterController {
  RosterService rosterService = new RosterService();
  RouteService routeService=new RouteService();

  @RequestMapping(value = "/roster", method = RequestMethod.GET)
  public String index(ModelMap modelMap) {
    modelMap.put("feRosters", rosterService.getListFeRoster());
    return "resources/views/roster";
  }

  @RequestMapping(value = "/roster/add", method = RequestMethod.GET)
  public String add(ModelMap modelMap) {
    modelMap.put("drivers", rosterService.getListRemainDriver());
    modelMap.put("routes",routeService.getListRoute());
    return "resources/views/rosterform";
  }

  @RequestMapping(value = "/roster/add", method = RequestMethod.POST)
  public String addDriver(@RequestParam("driverId") Integer driverId, @RequestParam("ids") List<Integer> routes,@RequestParam("total") List<Integer> total, ModelMap modelMap) {
    modelMap.put("driver", rosterService.getDriverById(driverId));

    return "resources/views/roster";
  }



}

