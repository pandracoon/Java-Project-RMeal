package Data;

import java.util.ArrayList;

public class Restaurant {

  private String name;
  private String location;
  private ArrayList<String> optionArrayList = new ArrayList<String>();


  public Restaurant(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void addOption(String option) {
    optionArrayList.add(option);
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public ArrayList<String> getOptionList() {
    return optionArrayList;
  }

  public void modifyName(String name) {
    this.name = name;
  }

  public void modifyLocation(String location) {
    this.location = location;
  }
}

