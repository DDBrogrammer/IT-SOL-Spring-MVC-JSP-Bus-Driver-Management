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
import service.RouteService;

@Controller
public class RouteController {

  RouteService routeService = new RouteService();

  @RequestMapping(value = "/route", method = RequestMethod.GET)
  public String index(ModelMap modelMap) {
    modelMap.put("routes", routeService.getListRoute());
    return "resources/views/route";
  }

  @RequestMapping(value = "route/delete", method = RequestMethod.GET)
  public String deleteDriver( @RequestParam("id") Integer id) {
    routeService.removeRoute(id);
    return "redirect:/route";
  }

  @RequestMapping(value = "/route/add", method = RequestMethod.GET)
  public ModelAndView add() {
    return  new ModelAndView("resources/views/routeform","route",new Route());
  }

  @RequestMapping(value = "/route/do-add", method = RequestMethod.POST)
  public String doAdd(@ModelAttribute("route") Route route) {
    System.out.println(route.toString());
    routeService.insert(route);
    return "redirect:/route";
  }

}
