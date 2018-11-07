package Data;

import java.util.ArrayList;

public class Restaurant {

  private String name;
  private String location;
  private ArrayList<Option> optionArrayList = new ArrayList<Option>();


  public Restaurant(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void addOption(Option option) {
    optionArrayList.add(option);

  }

  public String getName() {
    return name;
  }
}

