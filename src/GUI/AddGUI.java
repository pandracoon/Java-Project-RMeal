package GUI;


import static GUI.CreateComponent.*;

import Data.*;
import Data.OptionList.*;
import GUI.RMealMainGUI.mainGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddGUI extends JFrame {

  AddGUI(ArrayList<Restaurant> ResList) {
    setTitle("RMeal-ADD DATA");

    ArrayList<Option> options=new ArrayList<Option>();

    Container container = this.getContentPane();
    container.setBackground(Color.WHITE);
    container.setLayout(null);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    JLabel titleLabel = createJLabel("식당 추가", 20,20,200,50,50);
    titleLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 40));
    container.add(titleLabel);

    ///////////////////////////////////////////제목//////////////////////////////////////////

    //////////////////////////////////////////옵션 체크///////////////////////////////////////

    JPanel typeCheckBoxPanel=createJPanel(20,80,230,600);
    typeCheckBoxPanel.setBackground(Color.WHITE);
    typeCheckBoxPanel.setLayout(new GridLayout(0,1));
    typeCheckBoxPanel.setBorder(createTextBorder("식사",25));
    container.add(typeCheckBoxPanel);

    for(int i=0; i<OptionList.;i++){
      typeCheckBoxPanel.add(createJCheckBox(,20));
    }


    JPanel costCheckBoxPanel=createJPanel(260,80,230,600);
    costCheckBoxPanel.setBackground(Color.WHITE);
    costCheckBoxPanel.setLayout(new GridLayout(0,1));
    costCheckBoxPanel.setBorder(createTextBorder("가격대",25));
    container.add(costCheckBoxPanel);

    JPanel numOfPeopleCheckBoxPanel=createJPanel(500,80,230,600);
    numOfPeopleCheckBoxPanel.setBackground(Color.WHITE);
    numOfPeopleCheckBoxPanel.setLayout(new GridLayout(0,1));
    numOfPeopleCheckBoxPanel.setBorder(createTextBorder("인원",25));
    container.add(numOfPeopleCheckBoxPanel);

    JPanel locationCheckBoxPanel=createJPanel(740,80,230,600);
    locationCheckBoxPanel.setBackground(Color.WHITE);
    locationCheckBoxPanel.setLayout(new GridLayout(0,1));
    locationCheckBoxPanel.setBorder(createTextBorder("위치",25));
    container.add(locationCheckBoxPanel);



    //////////////////////////////////////////옵션 체크///////////////////////////////////////

    ///////////////////////////////////추가하기 돌아가기 버튼///////////////////////////////////

   JButton backButton=createJButton("돌아가기",765,696,100,50,17);
   backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
        new mainGUI(ResList);
      }
    });
   container.add(backButton);

   JButton addButton=createJButton("추가하기",875,695,100,50,17);
   addButton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       dispose();
       new mainGUI(ResList);
     }
   });
   container.add(addButton);

    ///////////////////////////////////추가하기 돌아가기 버튼///////////////////////////////////

    setSize(1000, 800);
    setVisible(true);

  }

  static JCheckBox setOption(ArrayList<Option> options, String text){
    JCheckBox jCheckBox=createJCheckBox(text,20);


    return jCheckBox;
  }
}