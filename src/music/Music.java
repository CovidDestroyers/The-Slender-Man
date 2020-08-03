package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Music {

  public static void forestMusic(File file) throws Exception {
//    gardenMusic =true;
    //when user/Gamer enter in Forestmusic will play
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

  }


}
