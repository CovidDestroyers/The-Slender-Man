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


  public void playInLoop () {
    //Below thing will loop continuous
    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(-25.0f); // Reduce volume by 25 decibels.
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
  }

  public void  stopMusic(){
    clip.stop();
  }

}


