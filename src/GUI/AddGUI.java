package GUI;

import GUI.RMealMainGUI.mainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddGUI extends JFrame {

  AddGUI() {
    setTitle("RMeal-ADD DATA");

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.add(new JPanel());
    container.setLayout(null);

   JButton ja=new JButton("메인 화면으로 돌아가기");
   ja.setSize(300,200);
   ja.setLocation(300,300);
   ja.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
        new mainGUI();

      }
    });
   container.add(ja);


    setSize(1000, 800);
    setVisible(true);

  }
}
