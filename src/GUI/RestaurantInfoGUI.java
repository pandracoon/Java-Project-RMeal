package GUI;

import static GUI.CreateComponent.*;

import Data.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class RestaurantInfoGUI extends JFrame {

  String[] answer = {"예", "아니오"};

  RestaurantInfoGUI(Restaurant restaurant, ArrayList<Restaurant> resList) {
    setTitle("RMeal");

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    //////////////////////////////////////정보////////////////////////////////////////////

    JLabel nameLabel = createJLabel(restaurant.getName() + " / " + restaurant.getLocation(), 10, 10,
        430, 30, 25);
    nameLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 35));
    if (restaurant.getName().length() + restaurant.getLocation().length() >= 12) {
      nameLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 25));
    }
    if (restaurant.getName().length() + restaurant.getLocation().length() >= 17) {
      nameLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 20));
    }
    if (restaurant.getName().length() + restaurant.getLocation().length() >= 21) {
      nameLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 15));
    }
    if (restaurant.getName().length() + restaurant.getLocation().length() >= 28) {
      nameLabel.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 13));
    }
    container.add(nameLabel);

    String[] resOptionNameList = new String[restaurant.getOptionList().size()];

    for (int i = 0; i < restaurant.getOptionList().size(); i++) {
      resOptionNameList[i] = restaurant.getOptionList().get(i).getOption();
    }

    JPanel resOptionListPanel = createJPanel(10, 52, 415, 440);
    resOptionListPanel.setBackground(Color.WHITE);
    resOptionListPanel.setBorder(createTextBorder("특징", 28));
    resOptionListPanel.setLayout(new GridLayout(0, 1));
    container.add(resOptionListPanel);

    JList<String> resOptionList = new JList<>(resOptionNameList);
    resOptionList.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 20));
    resOptionListPanel.add(resOptionList);

    //////////////////////////////////////정보////////////////////////////////////////////

    /////////////////////////////////////버튼/////////////////////////////////////////////

    JButton modifyButton = createJButton("수정하기", 60, 502, 100, 50, 17);
    container.add(modifyButton);

    JButton deleteButton = createJButton("삭제하기", 170, 502, 100, 50, 17);
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showOptionDialog(container, "식당을 삭제하시겠습니까?", "식당 삭제",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]);
        if (choice == 0) {
          resList.remove(restaurant);
          JOptionPane.showMessageDialog(container, "삭제되었습니다!", "삭제 성공",
              JOptionPane.INFORMATION_MESSAGE);
          dispose();
        }
      }
    });
    container.add(deleteButton);

    JButton backButton = createJButton("돌아가기", 280, 502, 100, 50, 17);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    container.add(backButton);

    /////////////////////////////////////버튼///////////////////////////////////////////

    setSize(452, 612);
    setVisible(true);
  }
}


