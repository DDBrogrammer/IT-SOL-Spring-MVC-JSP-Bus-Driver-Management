package service;

import entity.Driver;
import entity.Route;
import org.springframework.stereotype.Service;
import repository.RouteDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    RouteDao routeDao = new RouteDao();
    public ArrayList<Route> getListRoute() {
        return (ArrayList<Route>) routeDao.getAll();
    }

    public Route findID(int id) {
        return routeDao.findById(id);
    }

    public boolean save(Route route) {
      List<Route> routes = routeDao.getAll();
      routes.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
      int id = routes.get(0).getId() + 1;
      route.setId(id);
        return routeDao.save(route);
    }

  public boolean update(Route route) {
    return routeDao.update(route);
  }
  public boolean removeRoute(int id) {
    return routeDao.removeRoute(id);
  }



}
