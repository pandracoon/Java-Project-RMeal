package Main;

import static Data.DataManager.dataSave;
import static Main.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JPanel {

  String[] answer = {"예", "아니오"};
  MainGUI mainGUI = this;

  MainGUI(Container mainContainer, RestaurantList restaurantList, OptionList optionList) {

    setLayout(null);
    setBackground(Color.WHITE);

    JLabel titleLabel = createJLabel("RMeal", 200, 150, 600, 200, 120);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(new Font("함초롬돋움", Font.BOLD, 120));
    add(titleLabel);

    JButton addButton = createJButton("식당 추가", 350, 390, 300, 50, 20);
    addButton.setBackground(Color.GRAY);
    addButton.setForeground(Color.WHITE);
    addButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainContainer.add(new AddGUI(mainContainer, restaurantList, optionList));
        mainContainer.remove(mainGUI);
      }
    });
    add(addButton);

    JButton searchButton = createJButton("식당 조회", 350, 450, 300, 50, 20);
    searchButton.setBackground(Color.GRAY);
    searchButton.setForeground(Color.WHITE);
    searchButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainContainer.add(new SearchGUI(mainContainer, restaurantList, optionList, null,
            SearchGUI.INITIAL_STATE));
        mainContainer.remove(mainGUI);
      }
    });
    add(searchButton);

    JButton recommendButton = createJButton("식당 추천", 350, 510, 300, 50, 20);
    recommendButton.setBackground(Color.GRAY);
    recommendButton.setForeground(Color.WHITE);
    recommendButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        mainContainer.remove(mainGUI);
        mainContainer.add(new RecommendGUI(mainContainer, restaurantList, optionList, null,
            RecommendGUI.INITIAL_STATE));

      }
    });
    add(recommendButton);

    JButton exitButton = createJButton("프로그램 종료", 350, 570, 300, 50, 20);
    exitButton.setBackground(Color.GRAY);
    exitButton.setForeground(Color.WHITE);
    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showOptionDialog(mainContainer, "RMeal을 종료하시겠습니까?", "RMeal 종료",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);

        if (choice == 0) {
          dataSave(restaurantList, optionList);
          System.exit(1);
        } else {
          return;
        }
      }
    });
    add(exitButton);

    JLabel makerLabel = createJLabel("made by 조재건", 850, 710, 120, 50, 15);
    makerLabel.setHorizontalAlignment(JLabel.RIGHT);
    this.add(makerLabel);

  }
}




