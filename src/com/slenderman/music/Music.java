package com.slenderman.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music  {

  private Clip clip;

  public Music(File file) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(file));
  }

  public void play(){
    try
    {
      clip.start();
      Thread.sleep(clip.getMicrosecondLength()/1000);
    }
    catch (Exception exc)
    {
      exc.printStackTrace(System.out);
    }
  }


  public void playInLoop () throws InterruptedException {
    //Below thing will loop continuous
    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(-25.0f); // Reduce volume by 15 decibels.
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
  }

<<<<<<< HEAD

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




=======
  public void  stopMusic(){
    clip.stop();
>>>>>>> 584ec907c33910e5b4ff14654f7afc0067e0de6f
  }

}


