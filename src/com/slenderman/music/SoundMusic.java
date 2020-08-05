//package com.slenderman.music;
//
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;
//
//import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//
//public class SoundMusic implements ActionListener {
//  JFrame frame;
//  JLabel songNameLabel = new JLabel();
//  JButton selectButton = new JButton("Select MP3");
//  JButton playButton = new JButton("Play");
//  JButton pauseButton = new JButton("Pause");
//  JButton resumeButton = new JButton("Resume");
//  JButton stopButton = new JButton("Stop");
//  JFileChooser fileChooser;
//  FileInputStream fileInputStream;
//  File myFile= null;
//  String filename;
//  String filePath;
//  long totalLength;
//  long pause;
//  Player player;
//  Thread playThread;
//  SoundMusic(){
//    prepareGUI();
//    addActionEvents();
//    playThread=new Thread(runnablePlay);
//    resumeThread=new Thread(runnableResume);
//
//  }
//  public void prepareGUI() {
//    frame = new JFrame();
//    frame.setTitle("Music Player");
//    frame.getContentPane().setLayout(null);
//    frame.getContentPane().setBackground(Color.pink);
//    frame.setSize(440, 200);
//    frame.setLocationRelativeTo(null);
//    frame.setVisible(true);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//    selectButton.setBounds(160, 10, 100, 30);
//    frame.add(selectButton);
//
//    songNameLabel.setBounds(100, 50, 300, 30);
//    frame.add(songNameLabel);
//
//    playButton.setBounds(30, 110, 100, 30);
//    frame.add(playButton);
//
//    pauseButton.setBounds(120, 110, 100, 30);
//    frame.add(pauseButton);
//
//    resumeButton.setBounds(210, 110, 100, 30);
//    frame.add(resumeButton);
//
//    stopButton.setBounds(300, 110, 100, 30);
//    frame.add(stopButton);
//  }
//  public void addActionEvents(){
//    //registering action listener to buttons
//    selectButton.addActionListener(this);
//    playButton.addActionListener(this);
//    pauseButton.addActionListener(this);
//    resumeButton.addActionListener(this);
//    stopButton.addActionListener(this);
//  }
//  @Override
//  public void actionPerformed(ActionEvent e) {
//    if(e.getSource()==selectButton){
//      //code for selecting our mp3 file from dialog window
//      fileChooser=new JFileChooser();
//      fileChooser.setCurrentDirectory(new File("Forest.wav"));
//      fileChooser.setDialogTitle("Select Mp3");
//      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//      fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files","mp3"));
//      if(fileChooser.showOpenDialog(selectButton)==JFileChooser.APPROVE_OPTION){
//        myFile=fileChooser.getSelectedFile();
//        filename=fileChooser.getSelectedFile().getName();
//        filePath=fileChooser.getSelectedFile().getPath();
//      }
//    }
//    if(e.getSource()==playButton){
//      //starting play thread
//      playThread.start();
//      songNameLabel.setText("now playing : "+filename);
//    }
//    if(e.getSource()==pauseButton){
//      //code for pause button
//      if(player!=null){
//        try {
//          pause=fileInputStream.available();
//          player.close();
//        } catch (IOException e1) {
//          e1.printStackTrace();
//        }
//      }
//    }
//
//    if(e.getSource()==resumeButton){
//      //starting resume thread
//      resumeThread.start();
//    }
//    if(e.getSource()==stopButton){
//      //code for stop button
//      if(player!=null){
//        player.close();
//        songNameLabel.setText("");
//      }
//
//    }
//
//  }
//
//
//
//  Runnable runnableResume=new Runnable() {
//    @Override
//    public void run() {
//      try {
//        //code for resume button
//        fileInputStream=new FileInputStream(myFile);
//        bufferedInputStream=new BufferedInputStream(fileInputStream);
//        player=new Player(bufferedInputStream);
//        fileInputStream.skip(totalLength-pause);
//        player.play();
//      } catch (FileNotFoundException e) {
//        e.printStackTrace();
//      } catch (JavaLayerException e) {
//        e.printStackTrace();
//      } catch (IOException | JavaLayerException e) {
//        e.printStackTrace();
//      }
//    }
//  };
//
//
//}
