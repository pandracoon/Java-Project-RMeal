package Data;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RestaurantManager {

  public static final int CLEAR = -1;

  public static Restaurant addRestaurant(Container container, ArrayList<Restaurant> resList,
      ArrayList<Boolean> optionStateList, OptionList optionList, String name, String location) {

    Restaurant restaurant = new Restaurant(name, location);

    for (int i = 0; i < optionList.getList(OptionList.TYPE).size(); i++) {
      if (optionStateList.get(i)) {
        restaurant.addOption(optionList.getList(OptionList.TYPE).get(i));
      }
    }

    for (int i = 0; i < optionList.getList(OptionList.COST).size(); i++) {
      if (optionStateList.get(i + 5)) {
        restaurant.addOption(optionList.getList(OptionList.COST).get(i));
      }
    }

    for (int i = 0; i < optionList.getList(OptionList.NUM).size(); i++) {
      if (optionStateList.get(i + 10)) {
        restaurant.addOption(optionList.getList(OptionList.NUM).get(i));
      }
    }

    if (!optionList.getList(OptionList.LOC).contains(location)) {
      optionList.addLocation(location);
    }

    String[] answer = {"예", "아니오"};
    int deleteIndex = isNameContained(restaurant, name, resList);

    if (deleteIndex != RestaurantManager.CLEAR) {
      int choice = JOptionPane.showOptionDialog(container, "일치하는 이름을 가진 식당이 있습니다.\n 기존 "
              + "식당을 삭제하고 수정하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
      if (choice == 0) {
        deleteRestaurant(resList.get(deleteIndex), resList, optionList);
      } else {
        return null;
      }
    }

    resList.add(restaurant);

    return restaurant;
  }

  public static String[] searchRestaurant(ArrayList<Restaurant> resList, OptionList optionList,
      ArrayList<Boolean> optionStateList) {
    ArrayList<Restaurant> filteredList = new ArrayList<Restaurant>(resList);

    filteredList = filterList(optionList.getList(OptionList.TYPE), filteredList,
        optionStateList, OptionList.TYPE);
    filteredList = filterList(optionList.getList(OptionList.COST), filteredList,
        optionStateList, OptionList.COST);
    filteredList = filterList(optionList.getList(OptionList.NUM), filteredList,
        optionStateList, OptionList.NUM);
    filteredList = filterList(optionList.getList(OptionList.LOC), filteredList,
        optionStateList, OptionList.LOC);

    String[] searchResultNameList = new String[filteredList.size()];
    for (int i = 0; i < filteredList.size(); i++) {
      searchResultNameList[i] = filteredList.get(i).getName();
    }

    return searchResultNameList;
  }

  public static void deleteRestaurant(Restaurant restaurant, ArrayList<Restaurant> resList,
      OptionList optionList) {
    resList.remove(restaurant);
    for (int i = 0; i < resList.size(); i++) {
      if (resList.get(i).getLocation().equals(restaurant.getLocation())) {
        break;
      }
      if (i == resList.size() - 1) {
        optionList.getList(OptionList.LOC).remove(restaurant.getLocation());
      }
    }
    return;
  }

  public static Restaurant modifyRestaurant(Restaurant restaurant, OptionList optionList,
      ArrayList<Restaurant> resList, ArrayList<Boolean> optionStateList, String name,
      String location, Container container) {

    String[] answer = {"예", "아니오"};
    int deleteIndex = isNameContained(restaurant, name, resList);

    if (deleteIndex != RestaurantManager.CLEAR) {
      int choice = JOptionPane.showOptionDialog(container, "일치하는 이름을 가진 식당이 있습니다.\n 기존 "
              + "식당을 삭제하고 수정하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
      if (choice == 0) {
        deleteRestaurant(resList.get(deleteIndex), resList, optionList);
      } else {
        return null;
      }
    }
    deleteRestaurant(restaurant, resList, optionList);

    return addRestaurant(container, resList, optionStateList, optionList, name, location);
  }


  public static ArrayList<Restaurant> filterList(ArrayList<String> optionList,
      ArrayList<Restaurant> resList, ArrayList<Boolean> optionStateList, int listNum) {
    ArrayList<Restaurant> filteredList = new ArrayList<Restaurant>();

    for (int i = 0; i < optionList.size(); i++) {
      if (optionStateList.get(i + 5 * listNum)) {
        break;
      }
      if (i == optionList.size() - 1) {
        return resList;
      }
    }

    if (listNum == OptionList.LOC) {
      for (int i = 0; i < resList.size(); i++) {
        for (int j = 0; j < optionList.size(); j++) {
          if (!optionStateList.get(j + 5 * listNum)) {
            continue;
          }
          if (resList.get(i).getLocation().equals(optionList.get(j))) {
            filteredList.add(resList.get(i));
            break;
          }
        }
      }
    } else {
      for (int i = 0; i < resList.size(); i++) {
        for (int j = 0; j < optionList.size(); j++) {
          if (!optionStateList.get(j + 5 * listNum)) {
            continue;
          }
          if (resList.get(i).getOptionList().contains(optionList.get(j))) {
            filteredList.add(resList.get(i));
            break;
          }
        }
      }
    }
    return filteredList;
  }

  public static int isNameContained(Restaurant restaurant, String name,
      ArrayList<Restaurant> resList) {

    for (int i = 0; i < resList.size(); i++) {
      if (resList.get(i).equals(restaurant)) {
        continue;
      }
      if (resList.get(i).getName().equals(name)) {
        return i;
      }
    }
    return RestaurantManager.CLEAR;
  }
}
