package Data;

import java.util.ArrayList;

public class Restaurant {

  private String name;
  private String Location;
  private ArrayList<Option> optionArrayList = new ArrayList<Option>();


  public Restaurant(String name,String Location) {
    this.name = name;
  }

  public void addOption(Option option) {
    optionArrayList.add(option);

  }
}

