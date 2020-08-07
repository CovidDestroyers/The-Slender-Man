package com.slenderman.tools;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Sound {

  public static void play(File file){
    try {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start();
      Thread.sleep(clip.getMicrosecondLength() / 1000);
    }catch (FileNotFoundException noFileErr){
      System.out.println(noFileErr.getMessage());
    } catch (Exception exc) {
      exc.printStackTrace(System.out);
    }
  }
}
