package GUI;

import Data.*;
import java.awt.*;
import javax.swing.*;

public class RestaurantInfoGUI extends JFrame {

  RestaurantInfoGUI(Restaurant restaurant){
    setTitle("RMeal");

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    setSize(500,400);
    setVisible(true);
  }

}
