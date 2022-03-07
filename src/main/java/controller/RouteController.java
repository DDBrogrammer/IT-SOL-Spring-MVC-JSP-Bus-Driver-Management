package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.RouteService;

@Controller
public class RouteController {

  RouteService routeService = new RouteService();

  @RequestMapping(value = "/route", method = RequestMethod.GET)
  public String index(ModelMap modelMap) {
    modelMap.put("routes", routeService.getListRoute());
    return "resources/views/route";
  }


}
