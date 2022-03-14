package service;

import entity.Driver;
import entity.FERoster;
import entity.Roster;
import entity.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.DriverDao;
import repository.RosterDao;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RosterService {
    RosterDao rosterDao = new RosterDao();
    repository.DriverDao driverDao=new DriverDao();

    public ArrayList<FERoster> getListRoster() {
        ArrayList<FERoster> feRosters=new ArrayList<FERoster>();
        List<Driver> drivers=rosterDao.getAllDriver();
        ArrayList<Roster> tempRosters=new ArrayList<Roster>();
        FERoster feRoster=new FERoster();
      for(Driver driver:drivers){
        feRoster=new FERoster(driver,getListRouteByDriverID(driver.getId()));
         feRosters.add(feRoster);
    }
      return feRosters;
    }

    public Roster findID(int id) {
        return rosterDao.findById(id);
    }

    public boolean insert(Roster roster) {
        return rosterDao.insert(roster);
    }

    public ArrayList<Roster> getListRosterByDriverID(int id ){
        return (ArrayList<Roster>) rosterDao.getRostersByDriverId(id);
    }

    public ArrayList<Route> getListRouteByDriverID(int id){
      ArrayList<Route> routes=new ArrayList<Route>();
      ArrayList<Roster> rosters = getListRosterByDriverID(id);
      for(Roster r:rosters){
        routes.add(r.getRoute());
      }
      return routes;
    }

    public List<Driver> getListDriver(){
        return rosterDao.getAllDriver();
    }

    public List<Driver> getListRemainDriver(){
      List<Driver> remainDrivers= new ArrayList<Driver>();
      return remainDrivers;
    }

    public boolean removeRoster(int id) {
        return rosterDao.removeRoster(id);
    }


    static class NumberOfRouteComparator implements Comparator<Driver> {
      private  RosterService rosterService=new RosterService();
        // override the compare() method
        public int compare(Driver r1, Driver r2)
        {
            return Integer.compare(rosterService.getListRosterByDriverID(r2.getId()).size(),
                    rosterService.getListRosterByDriverID(r1.getId()).size());
        }
    }

    static class DriverNameComparator implements Comparator<Driver> {
        // override the compare() method
        public int compare(Driver r1, Driver r2)
        {
            if (r1.getName().equals(r2.getName()))
                return 0;
            else if (r2.getName().compareTo(r1.getName())>0)
                return 1;
            else
                return -1;
        }
    }




}

