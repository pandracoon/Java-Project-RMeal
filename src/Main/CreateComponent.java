package Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class CreateComponent {

  static JPanel createJPanel(int x, int y, int width, int height) {
    JPanel jPanel = new JPanel();
    jPanel.setLocation(x, y);
    jPanel.setSize(width, height);
    return jPanel;
  }

  static JCheckBox createJCheckBox(String text, int width, int height, int size) {
    JCheckBox jCheckBox = new JCheckBox(text);
    jCheckBox.setSize(width, height);
    jCheckBox.setFont(new Font("함초롬돋움", Font.BOLD, size));
    jCheckBox.setBackground(Color.WHITE);
    return jCheckBox;
  }

  static JCheckBox createJCheckBox(String text, int width, int height, int size,
      boolean state) {
    JCheckBox jCheckBox = new JCheckBox(text, state);
    jCheckBox.setSize(width, height);
    jCheckBox.setFont(new Font("함초롬돋움", Font.BOLD, size));
    jCheckBox.setBackground(Color.WHITE);
    return jCheckBox;
  }

  static JButton createJButton(String text, int x, int y, int width, int height,
      int size) {
    JButton jButton = new JButton(text);
    jButton.setLocation(x, y);
    jButton.setSize(width, height);
    jButton.setFont(new Font("함초롬돋움", Font.BOLD, size));
    return jButton;
  }

  static JLabel createJLabel(String text, int x, int y, int width, int height,
      int size) {
    JLabel jLabel = new JLabel(text);
    jLabel.setLocation(x, y);
    jLabel.setSize(width, height);
    jLabel.setFont(new Font("함초롬돋움", Font.BOLD, size));
    jLabel.setHorizontalAlignment(JLabel.LEFT);
    return jLabel;
  }

  static Border createTextBorder(String text, int size) {
    Border textBorder = BorderFactory.createEtchedBorder();
    textBorder = BorderFactory.createTitledBorder(textBorder, text);
    ((TitledBorder) textBorder).setTitleFont(new Font("함초롬돋움", Font.BOLD, size));
    return textBorder;
  }
}

