package com.slenderman.music;

import com.slenderman.scenes.Scene;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Music  {



  private Clip clip;
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




    public static void gameMusic (File file) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {


      AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();

      clip.open(audioInput);
//      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//      gainControl.setValue(-20.0f);

      clip.start();

      //Below thing will loop continuous
      clip.loop(Clip.LOOP_CONTINUOUSLY);


      Thread.sleep(clip.getMicrosecondLength() / 10000);


    }




  }


