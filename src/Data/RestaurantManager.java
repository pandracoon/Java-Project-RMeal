package Data;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RestaurantManager {

  private static final int CLEAR = -1;

  public static Restaurant addRestaurant(Container container, RestaurantList restaurantList,
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
    int deleteIndex = isNameContained(restaurant, name, restaurantList);

    if (deleteIndex != RestaurantManager.CLEAR) {
      int choice = JOptionPane.showOptionDialog(container, "일치하는 이름을 가진 식당이 있습니다.\n 기존 "
              + "식당을 삭제하고 수정하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
      if (choice == 0) {
        deleteRestaurant(restaurantList.get(deleteIndex), restaurantList, optionList);
      } else {
        return null;
      }
    }

    restaurantList.add(restaurant);

    return restaurant;
  }

  public static String[] searchRestaurant(RestaurantList restaurantList, OptionList optionList,
      ArrayList<Boolean> optionStateList) {
    RestaurantList filteredList = (RestaurantList) restaurantList.clone();

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

  public static void deleteRestaurant(Restaurant restaurant, RestaurantList restaurantList,
      OptionList optionList) {
    restaurantList.remove(restaurant);
    for (int i = 0; i < restaurantList.size(); i++) {
      if (restaurantList.get(i).getLocation().equals(restaurant.getLocation())) {
        break;
      }
      if (i == restaurantList.size() - 1) {
        optionList.getList(OptionList.LOC).remove(restaurant.getLocation());
      }
    }

    if (restaurantList.size() == 0) {
      optionList.getList(OptionList.LOC).remove(restaurant.getLocation());
    }
  }

  public static Restaurant modifyRestaurant(Restaurant restaurant, OptionList optionList,
      RestaurantList restaurantList, ArrayList<Boolean> optionStateList, String name,
      String location, Container container) {

    String[] answer = {"예", "아니오"};
    int deleteIndex = isNameContained(restaurant, name, restaurantList);

    if (deleteIndex != RestaurantManager.CLEAR) {
      int choice = JOptionPane.showOptionDialog(container, "일치하는 이름을 가진 식당이 있습니다.\n 기존 "
              + "식당을 삭제하고 수정하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
      if (choice == 0) {
        deleteRestaurant(restaurantList.get(deleteIndex), restaurantList, optionList);
      } else {
        return null;
      }
    }
    deleteRestaurant(restaurant, restaurantList, optionList);

    return addRestaurant(container, restaurantList, optionStateList, optionList, name, location);
  }

  public static String recommendRestaurant(RestaurantList restaurantList, OptionList optionList,
      ArrayList<Boolean> optionStateList) {
    String[] searchResultNameList = searchRestaurant(restaurantList, optionList, optionStateList);
    if (searchResultNameList.length == 0) {
      return "결과 없음";
    }

    int recommendIndex = (int) (Math.random() * searchResultNameList.length);
    return searchResultNameList[recommendIndex];

  }


  private static RestaurantList filterList(ArrayList<String> optionList,
      RestaurantList restaurantList, ArrayList<Boolean> optionStateList, int listNum) {
    RestaurantList filteredList = new RestaurantList();

    for (int i = 0; i < optionList.size(); i++) {
      if (optionStateList.get(i + 5 * listNum)) {
        break;
      }
      if (i == optionList.size() - 1) {
        return restaurantList;
      }
    }

    if (listNum == OptionList.LOC) {
      for (Restaurant restaurant : restaurantList) {
        for (int j = 0; j < optionList.size(); j++) {
          if (!optionStateList.get(j + 5 * listNum)) {
            continue;
          }
          if (restaurant.getLocation().equals(optionList.get(j))) {
            filteredList.add(restaurant);
            break;
          }
        }
      }
    } else {
      for (Restaurant restaurant : restaurantList) {
        for (int j = 0; j < optionList.size(); j++) {
          if (!optionStateList.get(j + 5 * listNum)) {
            continue;
          }
          if (restaurant.getOptionList().contains(optionList.get(j))) {
            filteredList.add(restaurant);
            break;
          }
        }
      }
    }
    return filteredList;
  }

  private static int isNameContained(Restaurant restaurant, String name,
      RestaurantList restaurantList) {

    for (int i = 0; i < restaurantList.size(); i++) {
      if (restaurantList.get(i).equals(restaurant)) {
        continue;
      }
      if (restaurantList.get(i).getName().equals(name)) {
        return i;
      }
    }
    return RestaurantManager.CLEAR;
  }
}
