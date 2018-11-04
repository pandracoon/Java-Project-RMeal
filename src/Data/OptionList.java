package Data;

import java.util.ArrayList;

public interface OptionList {
 String[] getList();
}

class TypeList implements OptionList {

   public String[] getList(){
     String[] typeList = {
         "한식", "일식", "중식", "양식", "기타"
     };

     return typeList;
  }
}

class CostList implements OptionList {
  String[] costList={
      "5000원 미만", "10000원 미만", "20000원 미만", "20000원 이상"
  };

}

class NumOfPeopleList implements OptionList {
  String[] numOfPeopleList={
      "1인 가능", "2인 가능", "3인 가능", "4인 가능", "5인 이상 가능"
  };

}

class LocationList implements OptionList {
  ArrayList<String> locationList=new ArrayList<String>();

  public void addLocation(String location){
    locationList.add(location);
    return;
  }


}


