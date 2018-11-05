package Data;

import java.util.ArrayList;

public class OptionList {

  public static final int TYPE = 1;
  public static final int COST = 2;
  public static final int NUM = 3;
  public static final int LOC = 4;

  private ArrayList<String> typeList = new ArrayList<String>();

  private ArrayList<String> costList = new ArrayList<String>();

  private ArrayList<String> numOfPeopleList = new ArrayList<String>();

  private ArrayList<String> locationList = new ArrayList<String>();

  public OptionList() {
    typeList.add("한식");
    typeList.add("일식");
    typeList.add("중식");
    typeList.add("양식");
    typeList.add("기타");

    costList.add("5000원 미만");
    costList.add("10000원 미만");
    costList.add("15000원 미만");
    costList.add("2000원 미만");
    costList.add("2000원 이상");

    numOfPeopleList.add("1인 가능");
    numOfPeopleList.add("2인 가능");
    numOfPeopleList.add("3인 가능");
    numOfPeopleList.add("4인 가능");
    numOfPeopleList.add("5인 이상 가능");
  }


  public ArrayList<String> getList(int listNum) {
    switch (listNum) {
      case TYPE:
        return typeList;
      case COST:
        return costList;
      case NUM:
        return numOfPeopleList;
      case LOC:
        return locationList;
      default:
        System.exit(1);
        return null;
    }
  }


  public void addLocation(String location) {
    locationList.add(location);
    return;

  }
}


