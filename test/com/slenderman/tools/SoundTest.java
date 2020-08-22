package com.slenderman.tools;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SoundTest {

  @Test
  public void playPositive() {
    File file= new File("oneMinute.wav");
    Sound.play(file);
  }
}
