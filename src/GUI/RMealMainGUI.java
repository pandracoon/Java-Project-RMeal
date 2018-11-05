package GUI;

import static GUI.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class RMealMainGUI {

  static class mainGUI extends JFrame {

    mainGUI(ArrayList<Restaurant> resList, OptionList optionList) {
      setTitle("RMeal");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container container = this.getContentPane();
      container.setBackground(Color.WHITE);
      container.setLayout(null);

      JLabel titleLabel = createJLabel("RMeal", 200, 150, 600, 200, 120);
      titleLabel.setHorizontalAlignment(JLabel.CENTER);
      titleLabel.setFont(new Font("나눔스퀘어 BOLD", Font.BOLD, 120));
      container.add(titleLabel);

      JButton buttonAdd = createJButton("식당 추가", 350, 420, 300, 50, 20);
      buttonAdd.setBackground(Color.GRAY);
      buttonAdd.setForeground(Color.WHITE);
      buttonAdd.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new AddGUI(resList, optionList);

        }
      });
      container.add(buttonAdd);

      JButton buttonSearch = createJButton("식당 조회", 350, 490, 300, 50, 20);
      buttonSearch.setBackground(Color.GRAY);
      buttonSearch.setForeground(Color.WHITE);
      buttonSearch.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new SearchGUI(resList, optionList);

        }
      });
      container.add(buttonSearch);

      JButton buttonRecommend = createJButton("식당 추천", 350, 560, 300, 50, 20);
      buttonRecommend.setBackground(Color.GRAY);
      buttonRecommend.setForeground(Color.WHITE);
      container.add(buttonRecommend);

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
    ArrayList<Restaurant> resList = new ArrayList<Restaurant>();
    OptionList optionList = new OptionList();
    new mainGUI(resList, optionList);

  }
}
