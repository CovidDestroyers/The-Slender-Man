package com.slenderman.tools;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class SoundTest {

  @Test
  public void playPositive() throws FileNotFoundException {
    File file= new File("oneMinute.wav");
    Sound.play(file);
  }

  @Test
  public void playNegative() throws FileNotFoundException {
    File file= new File("cave.wav");
    Sound.play(file);
  }
}
