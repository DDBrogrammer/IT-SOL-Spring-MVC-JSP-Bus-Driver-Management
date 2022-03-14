package main;

import repository.RosterDao;

public class Main {
  public static void main( String [] arg){
    RosterDao rosterDao =new RosterDao();
    System.out.println(rosterDao.getRemainDriver());
  }
}
