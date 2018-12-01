package Main;

import static Data.RestaurantManager.*;
import static Main.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AddGUI extends JPanel {

  String[] answer = {"예", "아니오"};
  JCheckBox[] typeCheckBox;
  JCheckBox[] costCheckBox;
  JCheckBox[] numOfPeopleCheckBox;
  JTextField nameTextField;
  JTextField locationTextField;
  AddGUI addGUI = this;

  AddGUI(Container mainContainer, RestaurantList restaurantList, OptionList optionList) {

    setBackground(Color.WHITE);
    setLayout(null);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    JLabel titleLabel = createJLabel("식당 추가", 20, 20, 200, 50, 50);
    titleLabel.setFont(new Font("함초롬돋움", Font.BOLD, 40));
    add(titleLabel);

    JLabel explainLabel = createJLabel("이름과 위치를 입력하고 해당하는 내용을 전부 체크하세요.", 220, 30, 500, 50, 20);
    add(explainLabel);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    //////////////////////////////////////////특성 입력///////////////////////////////////////
    JPanel nameTextAreaPanel = createJPanel(10, 80, 485, 65);
    nameTextAreaPanel.setBackground(Color.WHITE);
    nameTextAreaPanel.setLayout(new GridLayout(0, 1));
    nameTextAreaPanel.setBorder(createTextBorder("이름", 25));
    add(nameTextAreaPanel);

    nameTextField = new JTextField();
    nameTextField.setFont(new Font("함초롬돋움", Font.BOLD, 17));
    nameTextAreaPanel.add(nameTextField);

    JPanel locationTextAreaPanel = createJPanel(495, 80, 485, 65);
    locationTextAreaPanel.setBackground(Color.WHITE);
    locationTextAreaPanel.setLayout(new GridLayout(0, 1));
    locationTextAreaPanel.setBorder(createTextBorder("위치", 25));
    add(locationTextAreaPanel);

    locationTextField = new JTextField();
    locationTextField.setFont(new Font("함초롬돋움", Font.BOLD, 17));
    locationTextAreaPanel.add(locationTextField);

    JPanel optionSetPanel = createJPanel(10, 145, 960, 535);
    optionSetPanel.setBackground(Color.WHITE);
    optionSetPanel.setLayout(new GridLayout(1, 0, 5, 5));
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

    //////////////////////////////////////////특성 입력///////////////////////////////////////

    //////////////////////////////////////////버튼///////////////////////////////////////////

    JButton backButton = createJButton("돌아가기", 765, 696, 100, 50, 17);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showOptionDialog(mainContainer, "메인 화면으로 돌아가시겠습니까?", "돌아가기",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
        if (choice == 0) {
          setVisible(false);
          getParent().add(new MainGUI(mainContainer, restaurantList, optionList));
          getParent().remove(addGUI);
        }
      }
    });
    add(backButton);

    JButton addButton = createJButton("추가하기", 875, 695, 100, 50, 17);
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nameTextField.getText().equals("") || locationTextField.getText().equals("")) {
          JOptionPane
              .showMessageDialog(mainContainer, "이름과 위치를 적어주세요.", "추가 실패",
                  JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        int choice = JOptionPane.showOptionDialog(mainContainer, nameTextField.getText() + " 식당을 "
                + "추가하시겠습니까?", "추가하기", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
            answer, answer[0]);
        if (choice == 0) {
          ArrayList<Boolean> optionStateList = getOptionStateList();
          Restaurant addedRestaurant = addRestaurant(mainContainer, restaurantList, optionStateList,
              optionList, nameTextField.getText(), locationTextField.getText());
          if (addedRestaurant == null) {
            return;
          }
          JOptionPane
              .showMessageDialog(mainContainer, "추가되었습니다!", "추가 성공",
                  JOptionPane.INFORMATION_MESSAGE);
          setVisible(false);
          getParent().add(new MainGUI(mainContainer, restaurantList, optionList));
          getParent().remove(addGUI);
        }
      }
    });
    add(addButton);

    //////////////////////////////////////////////버튼/////////////////////////////////////////////

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

    return optionStateList;

  }
}