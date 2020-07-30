package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.URL;

public class Music {
  public static void gardenMusic() throws Exception {
    //when user/Gamer enter in garden relex music will play
    URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ForestDay_6095_24.wav");
    Clip clip = AudioSystem.getClip();

    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
    clip.open(ais);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    SwingUtilities.invokeLater(() -> {
      // Pop up will  display to user what user supposed to do.

      JOptionPane.showMessageDialog(null, "You are in Garden Relex!!!!");
    });

  }
  public static void gameStartMusic() throws Exception {
    //when user/Gamer enter in garden relex music will play
    URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_Timpani_6027_73_1.wav");
    Clip clip = AudioSystem.getClip();

    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
    clip.open(ais);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    SwingUtilities.invokeLater(() -> {
      // Pop up will  display to user what user supposed to do.

      JOptionPane.showMessageDialog(null, "Lets Play Game!!!!");
    });

  }

  public static void main(String[] args) throws Exception {
    Music music =new Music();
//    music.gardenMusic();
    gameStartMusic();
  }
}
