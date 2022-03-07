package main;

import entity.FERoster;

import service.RosterService;

import java.util.ArrayList;

public class Main {
  public static void main( String [] arg){
    RosterService rosterService=new RosterService();
    ArrayList<FERoster> rosterArrayList= rosterService.getListRoster();
    for ( FERoster fe:rosterArrayList){
      System.out.println(fe.toString());
    }

  }
}
