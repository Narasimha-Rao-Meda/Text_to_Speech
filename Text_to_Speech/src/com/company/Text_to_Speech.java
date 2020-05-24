package com.company;



import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Text_to_Speech implements ActionListener {
    JFrame jFrame;
    JTextArea jTextArea;
    JButton speak = new JButton("Speak");
    JButton clear = new JButton("Clear");
    void collect() {
        function();
        actions();
    }
    void function(){
        jFrame = new JFrame();
        jTextArea = new JTextArea();
        jFrame.setSize(400,400);
        jFrame.setTitle("Text to Speech");
        jFrame.getContentPane().setBackground(Color.WHITE);
        jFrame.getContentPane().setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jTextArea.setFont(new Font("Arial",Font.BOLD,12));
        jTextArea.setBounds(20,40,300,150);
        jTextArea.setBackground( new Color(229,112,200));
        jTextArea.setForeground(Color.BLACK);
        jFrame.add(jTextArea);
        speak.setBounds(70,220,100,30);
        speak.setFont(new Font("Arial",Font.BOLD,11));
        speak.setBackground(new Color(229,118,80));
        speak.setForeground(Color.cyan);
        jFrame.add(speak);
        clear.setBounds(180,220,100,30);
        clear.setFont(new Font("Arial",Font.BOLD,11));
        clear.setBackground(new Color(229,118,80));
        clear.setForeground(Color.cyan);
        jFrame.add(clear);



    }
    public void actions(){
        speak.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource() == clear){
              jTextArea.setText("");
          }
          if(e.getSource() == speak){
              Voice voice = VoiceManager.getInstance().getVoice("kevin16");
              if( voice != null){
                  voice.allocate();
              }
              try{
                  voice.setRate(150);
                  voice.setPitch(150);
                  voice.setVolume(60);
                  voice.speak(jTextArea.getText());
              }
              catch (Exception e1){
                  e1.printStackTrace();
              }
          }
    }
}
