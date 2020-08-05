package com.slenderman.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Music {
  public  static  void gameSingleMusic(File file){
    try
    {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start();

      Thread.sleep(clip.getMicrosecondLength()/1000);
    }
    catch (Exception exc)
    {
      exc.printStackTrace(System.out);
    }

  }

  public static void gameMusic(File file) throws Exception {
//    gardenMusic =true;
    //when user/Gamer enter in Forest music will play
//    Clip clip = AudioSystem.getClip();
//    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
//    clip.open(AudioSystem.getAudioInputStream(file));
//    clip.loop(Clip.LOOP_CONTINUOUSLY-1);
    AudioInputStream audioInput=AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioInput);
    clip.start();
    //Below thing will loop continuous
    clip.loop(Clip.LOOP_CONTINUOUSLY);
//    JOptionPane.showMessageDialog(null,"Please Click ok to stop Music");
//    clip.stop();
  }


}
