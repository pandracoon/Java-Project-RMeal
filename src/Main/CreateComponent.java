package Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CreateComponent {

 public static JPanel createJPanel(int x, int y, int width, int height){
   JPanel jPanel=new JPanel();
   jPanel.setLocation(x,y);
   jPanel.setSize(width,height);
   return jPanel;
 }

  public static JCheckBox createJCheckBox(String text, int width,int height,int size) {
    JCheckBox jCheckBox = new JCheckBox(text);
    jCheckBox.setSize(width,height);
    jCheckBox.setFont(new Font("나눔스퀘어 BOLD", Font.BOLD, size));
    jCheckBox.setBackground(Color.WHITE);
    return jCheckBox;
  }

  public static JButton createJButton(String text, int x, int y, int width, int height,
      int size) {
    JButton jButton = new JButton(text);
    jButton.setLocation(x, y);
    jButton.setSize(width, height);
    jButton.setFont(new Font("나눔스퀘어 BOLD", Font.BOLD, size));
    return jButton;
  }

  public static JLabel createJLabel(String text, int x, int y, int width, int height,
      int size){
    JLabel jLabel=new JLabel(text);
    jLabel.setLocation(x,y);
    jLabel.setSize(width,height);
    jLabel.setFont(new Font("나눔스퀘어 BOLD", Font.BOLD,size));
    jLabel.setHorizontalAlignment(JLabel.LEFT);
    return jLabel;
  }



  public static Border createTextBorder(String text,int size){
   Border textBorder=BorderFactory.createEtchedBorder();
   textBorder=BorderFactory.createTitledBorder(textBorder,text);
   ((TitledBorder) textBorder).setTitleFont(new Font("나눔스퀘어 BOLD", Font.BOLD,size));
   return textBorder;
  }
}

