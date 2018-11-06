package GUI;

import static GUI.CreateComponent.*;

import Data.*;
import GUI.RMealMainGUI.mainGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SearchGUI extends JFrame {

  String[] answer = {"예", "아니오"};
  String[] resNameList;
  JCheckBox[] typeCheckBox;
  JCheckBox[] costCheckBox;
  JCheckBox[] numOfPeopleCheckBox;
  JCheckBox[] locationCheckBox;

  SearchGUI(ArrayList<Restaurant> resList, OptionList optionList) {
    setTitle("RMeal");

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    JLabel titleLabel = createJLabel("식당 조회", 20, 20, 200, 50, 50);
    titleLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 40));
    container.add(titleLabel);

    JLabel explainLabel = createJLabel("조건을 선택하고 검색 버튼을 누르세요", 220, 30, 500, 50, 20);
    container.add(explainLabel);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    //////////////////////////////////////////조건입력////////////////////////////////////////

    JPanel optionSetPanel = createJPanel(10, 80, 560, 600);
    optionSetPanel.setBackground(Color.WHITE);
    optionSetPanel.setLayout(new GridLayout(2, 2, 5, 5));
    container.add(optionSetPanel);

    JPanel typeCheckBoxPanel = new JPanel();
    typeCheckBoxPanel.setBackground(Color.WHITE);
    typeCheckBoxPanel.setLayout(new GridLayout(0, 1));
    typeCheckBoxPanel.setBorder(createTextBorder("식사", 25));
    optionSetPanel.add(typeCheckBoxPanel);

    JPanel costCheckBoxPanel = new JPanel();
    costCheckBoxPanel.setBackground(Color.WHITE);
    costCheckBoxPanel.setLayout(new GridLayout(0, 1));
    costCheckBoxPanel.setBorder(createTextBorder("가격대", 25));
    optionSetPanel.add(costCheckBoxPanel);

    JPanel numOfPeopleCheckBoxPanel = new JPanel();
    numOfPeopleCheckBoxPanel.setBackground(Color.WHITE);
    numOfPeopleCheckBoxPanel.setLayout(new GridLayout(0, 1));
    numOfPeopleCheckBoxPanel.setBorder(createTextBorder("인원", 25));
    optionSetPanel.add(numOfPeopleCheckBoxPanel);

    JPanel locationCheckBoxPanel = new JPanel();
    locationCheckBoxPanel.setBackground(Color.WHITE);
    locationCheckBoxPanel.setSize(280, 1000);
    locationCheckBoxPanel.setLayout(new GridLayout(0, 1));
    JScrollPane jScrollPane = new JScrollPane(locationCheckBoxPanel,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane.setBorder(createTextBorder("위치", 25));
    jScrollPane.setBackground(Color.WHITE);
    optionSetPanel.add(jScrollPane);

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
      locationCheckBox[i] = createJCheckBox(optionList.getList(optionList.LOC).get(i), 200, 50, 20);
      locationCheckBoxPanel.add(locationCheckBox[i]);
    }

    //////////////////////////////////////////조건입력////////////////////////////////////////

    ///////////////////////////////////////////버튼///////////////////////////////////////////

    JButton searchButton = createJButton("검색하기", 465, 695, 100, 50, 17);
    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    container.add(searchButton);

    JButton backButton = createJButton("돌아가기", 765, 696, 100, 50, 17);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showOptionDialog(container, "메인 화면으로 돌아가시겠습니까?", "돌아가기",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
        if (choice == 0) {
          dispose();
          new mainGUI(resList, optionList);
        }
      }
    });
    container.add(backButton);

    JButton showButton = createJButton("정보보기", 875, 695, 100, 50, 17);
    showButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    container.add(showButton);

    ///////////////////////////////////////////버튼///////////////////////////////////////////

    ////////////////////////////////////////검색결과 리스트/////////////////////////////////////

    resNameList = new String[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      resNameList[i] = resList.get(i).getName();
    }

    JList<String> jList = new JList<String>(resNameList);
    jList.setSize(400, 600);
    jList.setLocation(580, 80);
    jList.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 15));
    jList.setBorder(createTextBorder("검색 결과", 25));
    container.add(jList);

    ////////////////////////////////////////검색결과 리스트/////////////////////////////////////

    setSize(1000, 800);
    setVisible(true);


  }
}
