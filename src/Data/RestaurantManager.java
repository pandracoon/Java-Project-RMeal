package Data;


public class RestaurantManager {


  public static Restaurant addRestaurant(boolean[] optionStateList, OptionList optionList,
      String name,
      String location) {

    Restaurant restaurant = new Restaurant(name, location);

    for (int i = 0; i < optionList.getList(OptionList.TYPE).size(); i++) {
      if (optionStateList[i]) {
        restaurant.addOption(new Option(optionList.getList(OptionList.TYPE).get(i)));
      }
    }
    for (int i = 0; i < optionList.getList(OptionList.COST).size(); i++) {
      if (optionStateList[i + 5]) {
        restaurant.addOption(new Option(optionList.getList(OptionList.COST).get(i)));
      }
    }
    for (int i = 0; i < optionList.getList(OptionList.NUM).size(); i++) {
      if (optionStateList[i + 10]) {
        restaurant.addOption(new Option(optionList.getList(OptionList.NUM).get(i)));
      }
    }

    if (!optionList.getList(OptionList.LOC).contains(location)) {
      optionList.getList(OptionList.LOC).add(location);
    }

    return restaurant;
  }


  /*public static Restaurant addRestaurant(OptionList optionList) {

    Restaurant restaurant = new Restaurant(nameTextField.getText(), locationTextField.getText());

    for (int i = 0; i < typeCheckBox.length; i++) {
      if (this.typeCheckBox[i].isSelected()) {
        restaurant.addOption(new Option(typeCheckBox[i].getText()));
      }
    }
    for (int i = 0; i < costCheckBox.length; i++) {
      if (this.costCheckBox[i].isSelected()) {
        restaurant.addOption(new Option(costCheckBox[i].getText()));
      }
    }
    for (int i = 0; i < numOfPeopleCheckBox.length; i++) {
      if (this.numOfPeopleCheckBox[i].isSelected()) {
        restaurant.addOption(new Option(numOfPeopleCheckBox[i].getText()));
      }
    }

    if(!optionList.getList(OptionList.LOC).contains(locationTextField.getText())){
      optionList.getList(OptionList.LOC).add(locationTextField.getText());
    }

    return restaurant;
  }
  */


}
