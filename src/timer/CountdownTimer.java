package timer;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
  //User have to finish task in 10 sec
  int second= 10;
  Timer time= new Timer();

  TimerTask task = new TimerTask() {

    public void run() {
      second--;
      SwingUtilities.invokeLater(() -> {
        // Pop up will  display to user what user supposed to do.

        JOptionPane.showMessageDialog(null, "You have "+second+ " Second left");
      });
      System.out.println("Second Left "+second);
      if (second == 15){
        System.out.println("------------Your are running out of time----------------");

      }
      else if (second ==0 ){
        System.out.println("-----------Oops!!!! Time out----------");
        System.exit(0);
      }

    }
  };

  public void startTimer(){
    time.scheduleAtFixedRate(task,1000,1000);


  }

  public static void main(String[] args) {
    CountdownTimer count = new CountdownTimer();
    count.startTimer();
  }

}
