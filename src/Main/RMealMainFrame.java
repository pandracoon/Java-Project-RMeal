package Main;

import Data.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RMealMainFrame extends JFrame {

  String[] answer = {"예", "아니오"};

  RMealMainFrame(RestaurantList restaurantList, OptionList optionList) {
    setTitle("RMeal");

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    Container mainContainer = this.getContentPane();
    mainContainer.setBackground(Color.WHITE);
    mainContainer.setLayout(new GridLayout(0, 1));

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int choice = JOptionPane.showOptionDialog(mainContainer, "RMeal을 종료하시겠습니까?", "RMeal 종료",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);

        if (choice == 0) {
          System.exit(1);
        } else {
          return;
        }
      }
    });

    mainContainer.add(new MainGUI(mainContainer, restaurantList, optionList));

    setSize(1000, 800);
    setVisible(true);


  }

  public static void main(String[] args) {
    //처음 실행일때와 아닐때를 구분해야함. 읽어들일 파일 존재 여부

    //처음실행했다고 치고
    RestaurantList restaurantList = new RestaurantList();
    restaurantList.add(new Restaurant("너네집 돈까스", "애넘"));
    OptionList optionList = new OptionList();
    new RMealMainFrame(restaurantList, optionList).setLocationRelativeTo(null);

  }

}
