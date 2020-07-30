package com.slenderman.musicplayer;

import com.slenderman.actors.SlenderMan;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SimplePlayer {

  public SimplePlayer() {
    while (!SlenderMan.isGameDone) {
      try {
        FileInputStream fileInputStream = new FileInputStream("Paranormal_Lullaby.mp3");
        Player playMP3 = new Player(fileInputStream);
        playMP3.play();
      } catch (FileNotFoundException | JavaLayerException e) {
        e.printStackTrace();
      }
    }
  }
}
