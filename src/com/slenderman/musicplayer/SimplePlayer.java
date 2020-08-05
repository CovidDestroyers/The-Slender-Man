package com.slenderman.musicplayer;

import com.slenderman.actors.SlenderMan;
import com.slenderman.game.Game;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class SimplePlayer {


  public SimplePlayer(String filename){
      try {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Player playMP3 = new Player(fileInputStream);
        playMP3.play();
      } catch (JavaLayerException | FileNotFoundException e) {
        e.printStackTrace();
      }
    }

}
