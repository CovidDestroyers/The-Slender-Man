package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Console;

import java.util.*;

public class Tree extends Scene {
  public final String FILE_BASE_NAME = "storyTreeNoColor";
  public final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  public Tree(){
    setDescription("You have reached a Tree.");
    setSceneName("tree");
  }

  @Override
  public void enter(Scanner in, Player player) {
    Console.updateMap(this.getSceneName());
    Console.clearScreen();

    String tree =
      "<pre color='lime'><small>              v .   ._, |_  .,            </pre>"+
        "<pre color='lime'><small>            `-._\\/  .  \\ /    |/_     </pre>"+
        "<pre color='lime'><small>                \\  _\\, y | \\//       </pre>"+
        "<pre color='lime'><small>          _\\_.___\\, \\/ -.\\||        </pre>"+
        "<pre color='lime'><small>            `7-,--.`._||  / / ,         </pre>"+
        "<pre color='lime'><small>            /'     `-. `./ / |/_.'      </pre>"+
        "<pre color='green'><small>                      |    |//          </pre>"+
        "<pre color='green'><small>                      |_    /           </pre>"+
        "<pre color='red'><small>                      |-   |            </pre>"+
        "<pre color='red'><small>                      |   =|            </pre>"+
        "<pre color='red'><small>                      |    |            </pre>"+
        "<pre color='green'><small> --------------------/ ,  . \\--------._</pre>";

    Console.updateImage(tree);
    if (player.getNumItemsPlayerHas() < player.TOTAL_NUM_ITEMS_TO_FINISH_GAME){
      System.out.println(bundle.getString("enter_0"));
      System.out.println(bundle.getString("enter_1") + " " + player.TOTAL_NUM_ITEMS_TO_FINISH_GAME);
      System.out.println(bundle.getString("enter_2") + " " + player.getNumItemsPlayerHas() + " "+ bundle.getString("enter_3"));
    }
  }
}
