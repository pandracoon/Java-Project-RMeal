package GUI;

import GUI.RMealMainGUI.mainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class RMealMainGUI {

  static class mainGUI extends JFrame {

    mainGUI() {
      setTitle("RMeal");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container container = this.getContentPane();
      container.setBackground(Color.WHITE);
      container.add(new JPanel());
      container.setLayout(null);

      JTextField textName = new JTextField("RMeal");
      textName.setEditable(false);
      textName.setHorizontalAlignment(JTextField.CENTER);
      textName.setBackground(Color.WHITE);
      textName.setBorder(null);
      textName.setSize(600, 200);
      textName.setLocation(200, 150);
      textName.setFont(new Font("맑은고딕", Font.BOLD, 120));
      container.add(textName);

      JButton buttonAdd = new JButton("식당 추가하기");
      buttonAdd.setSize(300, 50);
      buttonAdd.setLocation(350, 450);
      buttonAdd.setBackground(Color.GRAY);
      buttonAdd.setForeground(Color.WHITE);
      buttonAdd.setFont(new Font("맑은고딕", Font.BOLD, 20));
      buttonAdd.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          new AddGUI();

        }
      });
      container.add(buttonAdd);

      JButton buttonSearch = new JButton("식당 검색하기");
      buttonSearch.setSize(300, 50);
      buttonSearch.setLocation(350, 550);
      buttonSearch.setBackground(Color.GRAY);
      buttonSearch.setForeground(Color.WHITE);
      buttonSearch.setFont(new Font("맑은고딕", Font.BOLD, 20));
      container.add(buttonSearch);

      setSize(1000, 800);
      setVisible(true);
    }



  }


  public static void main(String[] args) {
   /* Scanner keyboard = new Scanner(System.in);
    ResType resType=new ResType(keyboard.next());
    Restaurant ad = new Restaurant(resType);
    */
    new mainGUI();

  }
}
