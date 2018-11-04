package Data;

import java.util.ArrayList;

public class Restaurant {

  private String name;
  private ArrayList<Option> optionArrayList = new ArrayList<Option>();
  private String Location;

  public Restaurant(String name,String Location) {
    this.name = name;
  }

  public void addOption(Option option) {
    optionArrayList.add(option);

  }
}

