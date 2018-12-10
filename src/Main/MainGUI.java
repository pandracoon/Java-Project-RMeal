package Main;

import static Data.DataManager.dataSave;
import static Main.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainGUI extends JPanel {

  private String[] answer = {"예", "아니오"};
  private MainGUI mainGUI = this;

  MainGUI(RestaurantList restaurantList, OptionList optionList) {

    setLayout(null);
    setBackground(Color.WHITE);

    //////////////////////////////////////////////제목/////////////////////////////////////////////

    JLabel titleLabel = createJLabel("RMeal", 200, 150, 600, 200, 120);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(new Font("함초롬돋움", Font.BOLD, 120));
    add(titleLabel);

    //////////////////////////////////////////////제목/////////////////////////////////////////////

    //////////////////////////////////////////////버튼/////////////////////////////////////////////

    JButton addButton = createJButton("식당 추가", 350, 390, 300, 50, 20);
    addButton.setBackground(Color.GRAY);
    addButton.setForeground(Color.WHITE);
    addButton.addActionListener(e -> {

      setVisible(false);
      getParent().add(new AddGUI(restaurantList, optionList));
      getParent().remove(mainGUI);

    });
    add(addButton);

    JButton searchButton = createJButton("식당 조회", 350, 450, 300, 50, 20);
    searchButton.setBackground(Color.GRAY);
    searchButton.setForeground(Color.WHITE);
    searchButton.addActionListener(e -> {
      setVisible(false);
      getParent().add(new SearchGUI(restaurantList, optionList, null,
          SearchGUI.INITIAL_STATE));
      getParent().remove(mainGUI);

    });
    add(searchButton);

    JButton recommendButton = createJButton("식당 추천", 350, 510, 300, 50, 20);
    recommendButton.setBackground(Color.GRAY);
    recommendButton.setForeground(Color.WHITE);
    recommendButton.addActionListener(e -> {

      setVisible(false);
      getParent().add(new RecommendGUI(restaurantList, optionList, null,
          RecommendGUI.INITIAL_STATE));
      getParent().remove(mainGUI);

    });
    add(recommendButton);

    JButton exitButton = createJButton("프로그램 종료", 350, 570, 300, 50, 20);
    exitButton.setBackground(Color.GRAY);
    exitButton.setForeground(Color.WHITE);
    exitButton.addActionListener(e -> {
      int choice = JOptionPane.showOptionDialog(getParent(), "RMeal을 종료하시겠습니까?", "RMeal 종료",
          JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);

      if (choice == 0) {
        dataSave(restaurantList, optionList);
        System.exit(1);
      }
    });
    add(exitButton);

    //////////////////////////////////////////////버튼/////////////////////////////////////////////

    JLabel makerLabel = createJLabel("made by 조재건", 850, 710, 120, 50, 15);
    makerLabel.setHorizontalAlignment(JLabel.RIGHT);
    this.add(makerLabel);

  }
}




