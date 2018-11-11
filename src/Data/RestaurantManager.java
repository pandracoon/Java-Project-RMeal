package Data;


import com.sun.org.apache.regexp.internal.RE;
import java.util.ArrayList;

public class RestaurantManager {


  public static void addRestaurant(ArrayList<Restaurant> resList,
      boolean[] optionStateList, OptionList optionList, String name, String location) {

    Restaurant restaurant = new Restaurant(name, location);

    for (int i = 0; i < optionList.getList(OptionList.TYPE).size(); i++) {
      if (optionStateList[i]) {
        restaurant.addOption(optionList.getList(OptionList.TYPE).get(i));
      }
    }
    for (int i = 0; i < optionList.getList(OptionList.COST).size(); i++) {
      if (optionStateList[i + 5]) {
        restaurant.addOption(optionList.getList(OptionList.COST).get(i));
      }
    }
    for (int i = 0; i < optionList.getList(OptionList.NUM).size(); i++) {
      if (optionStateList[i + 10]) {
        restaurant.addOption(optionList.getList(OptionList.NUM).get(i));
      }
    }

    if (!optionList.getList(OptionList.LOC).contains(location)) {
      optionList.getList(OptionList.LOC).add(location);
    }
    resList.add(restaurant);
  }

  public static String[] searchRestaurant(ArrayList<Restaurant> resList, OptionList optionList,
      boolean[] optionStateList) {
    ArrayList<Restaurant> filteredList = new ArrayList<Restaurant>(resList);

    for (int i = 0; i < optionList.getList(OptionList.TYPE).size(); i++) {
      if (optionStateList[i]) {
        filteredList = filterList(optionList.getList(OptionList.TYPE).get(i), filteredList);
      }
    }

    for (int i = 0; i < optionList.getList(OptionList.COST).size(); i++) {
      if (optionStateList[i + 5]) {
        filteredList = filterList(optionList.getList(OptionList.COST).get(i), filteredList);
      }
    }

    for (int i = 0; i < optionList.getList(OptionList.NUM).size(); i++) {
      if (optionStateList[i + 10]) {
        filteredList = filterList(optionList.getList(OptionList.NUM).get(i), filteredList);
      }
    }

    String[] searchResultNameList = new String[filteredList.size()];
    for (int i = 0; i < filteredList.size(); i++) {
      searchResultNameList[i] = filteredList.get(i).getName();
    }

    return searchResultNameList;
  }

  public static ArrayList<Restaurant> filterList(String option, ArrayList<Restaurant> resList) {
    ArrayList<Restaurant> filteredList = new ArrayList<Restaurant>();
    for (int i = 0; i < resList.size(); i++) {
      if (resList.get(i).getOptionList().contains(option)) {
        filteredList.add(resList.get(i));
      }
    }

    return filteredList;
  }

}
