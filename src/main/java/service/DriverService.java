package service;

import entity.Driver;
import org.springframework.stereotype.Service;
import repository.DriverDao;

import java.util.List;

@Service
public class DriverService {

      DriverDao driverDao=new DriverDao();
    public  Iterable  <Driver> getListDriver() {
        return driverDao.getAll();
    }

    public Driver findID(int id) {
        return driverDao.findById(id);
    }

    public boolean update(Driver driver) {
        return driverDao.update(driver);
    }

  public boolean save(Driver driver) {
    List<Driver> drivers = driverDao.getAll();
    drivers.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
    int id = drivers.get(0).getId() + 1;
    driver.setId(id);
    if (driver.getName() == null) {
      return false;
    }
    return driverDao.save(driver);
  }

    public boolean removeStudent(int id) {
        return driverDao.removeDriver(id);
    }

}
