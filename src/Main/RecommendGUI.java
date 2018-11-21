package Main;


import static Data.RestaurantManager.recommendRestaurant;
import static Main.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class RecommendGUI extends JPanel {

  public static final int INITIAL_STATE = 0;
  public static final int SEARCHED_STATE = 1;

  String[] answer = {"예", "아니오"};
  JCheckBox[] typeCheckBox;
  JCheckBox[] costCheckBox;
  JCheckBox[] numOfPeopleCheckBox;
  JCheckBox[] locationCheckBox;
  String recommendedRestaurantName;
  Restaurant recommendedRestaurant;
  RecommendGUI recommendGUI = this;

  public RecommendGUI(Container mainContainer, RestaurantList restaurantList, OptionList optionList,
      ArrayList<Boolean> optionStateList, int state) {

    setBackground(Color.WHITE);
    setLayout(null);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    JLabel titleLabel = createJLabel("식당 추천", 20, 20, 200, 50, 50);
    titleLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 40));
    add(titleLabel);

    JLabel explainLabel = createJLabel("추천받을 조건을 선택하세요.", 220, 30, 500, 50, 20);
    add(explainLabel);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    /////////////////////////////////////////조건 입력////////////////////////////////////////

    JPanel optionSetPanel = createJPanel(10, 80, 960, 580);
    optionSetPanel.setBackground(Color.WHITE);
    optionSetPanel.setLayout(new GridLayout(2, 2, 5, 5));
    add(optionSetPanel);

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

    JPanel locationCheckBoxPanel = new JPanel();
    locationCheckBoxPanel.setBackground(Color.WHITE);
    locationCheckBoxPanel.setSize(400, 1000);
    locationCheckBoxPanel.setLayout(new GridLayout(0, 1));

    JScrollPane locationCheckBoxScrollPane = new JScrollPane(locationCheckBoxPanel,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    locationCheckBoxScrollPane.setBorder(createTextBorder("위치", 28));
    locationCheckBoxScrollPane.setBackground(Color.WHITE);
    optionSetPanel.add(locationCheckBoxScrollPane);

    if (state == INITIAL_STATE) {
      typeCheckBox = new JCheckBox[optionList.getList(optionList.TYPE).size()];
      for (int i = 0; i < optionList.getList(optionList.TYPE).size(); i++) {
        typeCheckBox[i] = createJCheckBox(optionList.getList(optionList.TYPE).get(i), 200, 50, 20);
        typeCheckBoxPanel.add(typeCheckBox[i]);
      }

      costCheckBox = new JCheckBox[optionList.getList(optionList.COST).size()];
      for (int i = 0; i < optionList.getList(optionList.COST).size(); i++) {
        costCheckBox[i] = createJCheckBox(optionList.getList(optionList.COST).get(i), 200, 50, 20);
        costCheckBoxPanel.add(costCheckBox[i]);
      }

      numOfPeopleCheckBox = new JCheckBox[optionList.getList(optionList.NUM).size()];
      for (int i = 0; i < optionList.getList(optionList.NUM).size(); i++) {
        numOfPeopleCheckBox[i] = createJCheckBox(optionList.getList(optionList.NUM).get(i), 200, 50,
            20);
        numOfPeopleCheckBoxPanel.add(numOfPeopleCheckBox[i]);
      }

      locationCheckBox = new JCheckBox[optionList.getList(optionList.LOC).size()];
      for (int i = 0; i < optionList.getList(optionList.LOC).size(); i++) {
        locationCheckBox[i] = createJCheckBox(optionList.getList(optionList.LOC).get(i), 200, 50,
            20);
        locationCheckBoxPanel.add(locationCheckBox[i]);
      }
    }

    if (state == SEARCHED_STATE) {
      typeCheckBox = new JCheckBox[optionList.getList(optionList.TYPE).size()];
      for (int i = 0; i < optionList.getList(optionList.TYPE).size(); i++) {
        typeCheckBox[i] = createJCheckBox(optionList.getList(optionList.TYPE).get(i), 200, 50, 20
            , optionStateList.get(i));
        typeCheckBoxPanel.add(typeCheckBox[i]);
      }

      costCheckBox = new JCheckBox[optionList.getList(optionList.COST).size()];
      for (int i = 0; i < optionList.getList(optionList.COST).size(); i++) {
        costCheckBox[i] = createJCheckBox(optionList.getList(optionList.COST).get(i), 200, 50, 20
            , optionStateList.get(i + 5));
        costCheckBoxPanel.add(costCheckBox[i]);
      }

      numOfPeopleCheckBox = new JCheckBox[optionList.getList(optionList.NUM).size()];
      for (int i = 0; i < optionList.getList(optionList.NUM).size(); i++) {
        numOfPeopleCheckBox[i] = createJCheckBox(optionList.getList(optionList.NUM).get(i), 200, 50,
            20, optionStateList.get(i + 10));
        numOfPeopleCheckBoxPanel.add(numOfPeopleCheckBox[i]);
      }

      locationCheckBox = new JCheckBox[optionList.getList(optionList.LOC).size()];
      for (int i = 0; i < optionList.getList(optionList.LOC).size(); i++) {
        locationCheckBox[i] = createJCheckBox(optionList.getList(optionList.LOC).get(i), 200, 50,
            20, optionStateList.get(i + 15));
        locationCheckBoxPanel.add(locationCheckBox[i]);
      }
    }

    /////////////////////////////////////////조건 입력////////////////////////////////////////

    ////////////////////////////////////////식당 추첨/////////////////////////////////////////

    String[] resNameList = new String[restaurantList.size()];
    for (int i = 0; i < restaurantList.size(); i++) {
      resNameList[i] = restaurantList.get(i).getName();
    }

    JPanel recommendPanel = createJPanel(10, 665, 640, 83);
    recommendPanel.setBackground(Color.WHITE);
    recommendPanel.setBorder(createTextBorder("추천 결과", 28));
    recommendPanel.setLayout(new GridLayout(0, 1));
    add(recommendPanel);

    if (state == SEARCHED_STATE) {
      recommendedRestaurantName = recommendRestaurant(restaurantList, optionList, optionStateList);

      for (int i = 0; i < restaurantList.size(); i++) {
        if (restaurantList.get(i).getName().equals(recommendedRestaurantName)) {
          recommendedRestaurant = restaurantList.get(i);
          break;
        }
      }
      JLabel recommendLabel = createJLabel(recommendedRestaurantName, 20, 20, 200, 50, 50);
      recommendLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 40));
      recommendPanel.add(recommendLabel);
    }

    ////////////////////////////////////////식당 추첨/////////////////////////////////////////

    //////////////////////////////////////////버튼///////////////////////////////////////////

    JButton showButton = createJButton("정보보기", 655, 695, 100, 50, 17);
    showButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new RestaurantInfoGUI(mainContainer, recommendedRestaurant, null, null, null, null,
            RestaurantInfoGUI.FROM_RECOMMENDGUI).setLocationRelativeTo(null);
      }
    });
    add(showButton);

    JButton recommendButton = createJButton("추천받기", 765, 695, 100, 50, 17);
    recommendButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainContainer.remove(recommendGUI);
        mainContainer
            .add(new RecommendGUI(mainContainer, restaurantList, optionList, getOptionStateList(),
                RecommendGUI.SEARCHED_STATE));
      }
    });
    add(recommendButton);

    JButton backButton = createJButton("돌아가기", 875, 695, 100, 50, 17);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showOptionDialog(mainContainer, "메인 화면으로 돌아가시겠습니까?", "돌아가기",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
        if (choice == 0) {
          setVisible(false);
          mainContainer.remove(recommendGUI);
          mainContainer.add(new MainGUI(mainContainer, restaurantList, optionList));
        }
      }
    });
    add(backButton);

    setVisible(true);

  }

  public ArrayList<Boolean> getOptionStateList() {

    ArrayList<Boolean> optionStateList = new ArrayList<Boolean>();

    for (int i = 0; i < typeCheckBox.length; i++) {
      optionStateList.add(this.typeCheckBox[i].isSelected());
    }

    for (int i = 0; i < costCheckBox.length; i++) {
      optionStateList.add(this.costCheckBox[i].isSelected());
    }

    for (int i = 0; i < numOfPeopleCheckBox.length; i++) {
      optionStateList.add(this.numOfPeopleCheckBox[i].isSelected());
    }

    for (int i = 0; i < locationCheckBox.length; i++) {
      optionStateList.add(this.locationCheckBox[i].isSelected());
    }

    return optionStateList;

  }
}
