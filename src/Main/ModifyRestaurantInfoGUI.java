package Main;

import static Main.CreateComponent.*;

import Data.OptionList;
import Data.Restaurant;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.html.Option;

public class ModifyRestaurantInfoGUI extends JFrame {

  String[] answer = {"예", "아니오"};
  JCheckBox[] typeCheckBox;
  JCheckBox[] costCheckBox;
  JCheckBox[] numOfPeopleCheckBox;
  ArrayList<Boolean> resOptionState;

  public ModifyRestaurantInfoGUI(Restaurant restaurant, OptionList optionList,
      ArrayList<Boolean> optionStateList) {
    setTitle(restaurant.getName());

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    //////////////////////////////////////////제목//////////////////////////////////////////////

    JLabel titleLabel = createJLabel("정보 수정하기", 20, 20, 300, 50, 50);
    titleLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 40));
    container.add(titleLabel);

    //////////////////////////////////////////제목//////////////////////////////////////////////

    ////////////////////////////////////////정보 수정///////////////////////////////////////////

    JPanel nameTextAreaPanel = createJPanel(10, 80, 485, 65);
    nameTextAreaPanel.setBackground(Color.WHITE);
    nameTextAreaPanel.setLayout(new GridLayout(0, 1));
    nameTextAreaPanel.setBorder(createTextBorder("이름", 25));
    container.add(nameTextAreaPanel);

    JTextField nameTextField = new JTextField();
    nameTextField.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 17));
    nameTextAreaPanel.add(nameTextField);

    JPanel locationTextAreaPanel = createJPanel(495, 80, 485, 65);
    locationTextAreaPanel.setBackground(Color.WHITE);
    locationTextAreaPanel.setLayout(new GridLayout(0, 1));
    locationTextAreaPanel.setBorder(createTextBorder("위치", 25));
    container.add(locationTextAreaPanel);

    JTextField locationTextField = new JTextField();
    locationTextField.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 17));
    locationTextAreaPanel.add(locationTextField);

    JPanel optionSetPanel = createJPanel(10, 145, 960, 535);
    optionSetPanel.setBackground(Color.WHITE);
    optionSetPanel.setLayout(new GridLayout(1, 0, 5, 5));
    container.add(optionSetPanel);

    JPanel typeCheckBoxPanel = new JPanel();
    typeCheckBoxPanel.setBackground(Color.WHITE);
    typeCheckBoxPanel.setLayout(new GridLayout(0, 1));
    typeCheckBoxPanel.setBorder(createTextBorder("식사", 28));
    optionSetPanel.add(typeCheckBoxPanel);

    JPanel costCheckBoxPanel = new JPanel();
    costCheckBoxPanel.setBackground(Color.WHITE);
    costCheckBoxPanel.setLayout(new GridLayout(0, 1));
    costCheckBoxPanel.setBorder(createTextBorder("가격대", 28));
    optionSetPanel.add(costCheckBoxPanel);

    JPanel numOfPeopleCheckBoxPanel = new JPanel();
    numOfPeopleCheckBoxPanel.setBackground(Color.WHITE);
    numOfPeopleCheckBoxPanel.setLayout(new GridLayout(0, 1));
    numOfPeopleCheckBoxPanel.setBorder(createTextBorder("인원", 28));
    optionSetPanel.add(numOfPeopleCheckBoxPanel);

    typeCheckBox = new JCheckBox[optionList.getList(optionList.TYPE).size()];
    for (int i = 0; i < optionList.getList(optionList.TYPE).size(); i++) {
      typeCheckBox[i] = createJCheckBox(optionList.getList(optionList.TYPE).get(i), 200, 50, 20
          , isContained(restaurant, optionList, OptionList.TYPE, i));
      typeCheckBoxPanel.add(typeCheckBox[i]);
    }

    costCheckBox = new JCheckBox[optionList.getList(optionList.COST).size()];
    for (int i = 0; i < optionList.getList(optionList.COST).size(); i++) {
      costCheckBox[i] = createJCheckBox(optionList.getList(optionList.COST).get(i), 200, 50, 20
          , isContained(restaurant, optionList, OptionList.COST, i));
      costCheckBoxPanel.add(costCheckBox[i]);
    }

    numOfPeopleCheckBox = new JCheckBox[optionList.getList(optionList.NUM).size()];
    for (int i = 0; i < optionList.getList(optionList.NUM).size(); i++) {
      numOfPeopleCheckBox[i] = createJCheckBox(optionList.getList(optionList.NUM).get(i), 200, 50,
          20, isContained(restaurant, optionList, OptionList.NUM, i));
      numOfPeopleCheckBoxPanel.add(numOfPeopleCheckBox[i]);
    }

    ////////////////////////////////////////정보 수정///////////////////////////////////////////

    setSize(1000, 800);
    setVisible(true);
  }

  public static boolean isContained(Restaurant restaurant, OptionList optionList, int listType,
      int optionNum) {
    if (restaurant.getOptionList().contains(optionList.getList(listType).get(optionNum))) {
      return true;
    }
    return false;
  }

}
