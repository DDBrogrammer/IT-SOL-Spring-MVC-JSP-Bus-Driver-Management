package service;

import entity.*;
import entity.FeRoster;
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

    public ArrayList<FeRoster> getListFeRoster() {
        ArrayList<FeRoster> feRosters=new ArrayList<FeRoster>();
        List<Driver> drivers=rosterDao.getAllDriver();
        ArrayList<Roster> tempRosters=new ArrayList<Roster>();
        FeRoster feRoster=new FeRoster();
      for(Driver driver:drivers){
        feRoster=new FeRoster(driver,getListFeRouteByDriverID(driver.getId()));
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

    public ArrayList<FeRoute> getListFeRouteByDriverID(int id){
      ArrayList<FeRoute> routes=new ArrayList<FeRoute>();
      ArrayList<Roster> rosters = getListRosterByDriverID(id);
      for(Roster r:rosters){
        FeRoute feRoster=new FeRoute(r.getRoute(),r.getTotalRoute());
        routes.add(feRoster);
      }
      return routes;
    }

    public Driver getDriverById(int id ){
      return driverDao.findById(id);
    }
    public List<Driver> getListDriver(){
        return rosterDao.getAllDriver();
    }

    public List<Driver> getListRemainDriver(){
      return rosterDao.getRemainDriver();
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

