package Main;

import static Main.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RMealMainGUI {

  static class mainGUI extends JFrame {

    String[] answer = {"예", "아니오"};

    mainGUI(RestaurantList restaurantList, OptionList optionList) {
      setTitle("RMeal");

      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

      Container container = this.getContentPane();
      container.setBackground(Color.WHITE);
      container.setLayout(null);

      this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          int choice = JOptionPane.showOptionDialog(container, "RMeal을 종료하시겠습니까?", "RMeal 종료",
              JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);

          if (choice == 0) {
            System.exit(1);
          } else {
            return;
          }
        }
      });

      JLabel titleLabel = createJLabel("RMeal", 200, 150, 600, 200, 120);
      titleLabel.setHorizontalAlignment(JLabel.CENTER);
      titleLabel.setFont(new Font("나눔스퀘어 BOLD", Font.BOLD, 120));
      container.add(titleLabel);

      JButton addButton = createJButton("식당 추가", 350, 390, 300, 50, 20);
      addButton.setBackground(Color.GRAY);
      addButton.setForeground(Color.WHITE);
      addButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new AddGUI(restaurantList, optionList).setLocationRelativeTo(null);

        }
      });
      container.add(addButton);

      JButton searchButton = createJButton("식당 조회", 350, 450, 300, 50, 20);
      searchButton.setBackground(Color.GRAY);
      searchButton.setForeground(Color.WHITE);
      searchButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new SearchGUI(restaurantList, optionList, null, 0).setLocationRelativeTo(null);

        }
      });
      container.add(searchButton);

      JButton recommendButton = createJButton("식당 추천", 350, 510, 300, 50, 20);
      recommendButton.setBackground(Color.GRAY);
      recommendButton.setForeground(Color.WHITE);
      recommendButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new RecommendGUI(restaurantList, optionList, null, RecommendGUI.INITIAL_STATE)
              .setLocationRelativeTo(null);
        }
      });
      container.add(recommendButton);

      JButton exitButton = createJButton("프로그램 종료", 350, 570, 300, 50, 20);
      exitButton.setBackground(Color.GRAY);
      exitButton.setForeground(Color.WHITE);
      exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          int choice = JOptionPane.showOptionDialog(container, "RMeal을 종료하시겠습니까?", "RMeal 종료",
              JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);

          if (choice == 0) {
            System.exit(1);
          } else {
            return;
          }
        }
      });
      container.add(exitButton);

      JLabel makerLabel = createJLabel("made by 조재건", 850, 710, 120, 50, 15);
      makerLabel.setHorizontalAlignment(JLabel.RIGHT);
      container.add(makerLabel);

      setSize(1000, 800);
      setVisible(true);
    }
  }


  public static void main(String[] args) {
    //처음 실행일때와 아닐때를 구분해야함. 읽어들일 파일 존재 여부

    //처음실행했다고 치고
    RestaurantList restaurantList = new RestaurantList();
    restaurantList.add(new Restaurant("너네집 돈까스", "애넘"));
    OptionList optionList = new OptionList();
    new mainGUI(restaurantList, optionList).setLocationRelativeTo(null);

  }
}
