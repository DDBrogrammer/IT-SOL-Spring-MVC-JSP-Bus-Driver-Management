package service;

import entity.Driver;
import entity.Roster;
import org.springframework.stereotype.Service;
import repository.RosterDao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RosterService {
    RosterDao rosterDao = new RosterDao();
    public ArrayList<Roster> getListRoster() {
        for(Roster r:rosterDao.getAll()){
            System.out.println(r.toString());
        }
        for(Driver d: rosterDao.getAllDriver()){
            System.out.println(d.toString());
        }
        return (ArrayList<Roster>) rosterDao.getAll();
    }

    public Roster findID(int id) {
        return rosterDao.findById(id);
    }

    public boolean insert(Roster roster) {
        List<Roster> rosters = rosterDao.getAll();

        return rosterDao.insert(roster);
    }

    public ArrayList<Roster> getListRosterByDriverID(int id ){
        return (ArrayList<Roster>) rosterDao.getRostersByDriverId(id);
    }
    public List<Driver> getListDriver(){
        return rosterDao.getAllDriver();
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
