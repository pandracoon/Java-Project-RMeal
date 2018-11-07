package GUI;

import static GUI.CreateComponent.*;

import Data.*;
import java.awt.*;
import javax.swing.*;

public class RestaurantInfoGUI extends JFrame {

  RestaurantInfoGUI(Restaurant restaurant){
    setTitle("RMeal");

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    //////////////////////////////////////정보////////////////////////////////////////////

    JLabel nameLabel= createJLabel(restaurant.getName()+" in "+restaurant.getLocation(),10,10,380,
        30,25);
    nameLabel.setFont(new Font("나눔스퀘어 ExtraBold",Font.BOLD,25));
    container.add(nameLabel);

    setSize(400,700);
    setVisible(true);
  }
}
