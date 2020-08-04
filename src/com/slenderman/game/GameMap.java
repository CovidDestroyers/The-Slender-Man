package com.slenderman.game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameMap {

  private static String sceneName;

  public JTextArea makeMap(String sceneName) {
    String cs = "";
    JTextArea result = new JTextArea(15, 55);
    result.setBackground(Color.BLACK);
    result.setForeground(Color.WHITE);
    result.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    Map<String, String> loc = new HashMap<>();
    loc.put("forest", "        ");
    loc.put("house", "        ");
    loc.put("shed", "        ");
    loc.put("cave", "        ");
    loc.put("pond", "        ");
    loc.put("field", "        ");
    loc.put("tree", "        ");

    setSceneName(sceneName);
    cs = getSceneName();

    Set<String> keys = loc.keySet();
    String[] keyArr = keys.toArray(new String[keys.size()]);
    for(String key : keyArr) {
      if (key.equals(cs)) {
        loc.put(key, "(Player)");
      }
    }

    result.append("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|  " + loc.get("forest") + " |  "+ loc.get("house") +" |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|  "+ loc.get("shed") +" |  "+ loc.get("cave") +" |  "+ loc.get("pond") +" |  "+ loc.get("field") +" |  "+ loc.get("tree") +" | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");

    return result;
  }
  public static String getSceneName() {
    return sceneName;
  }

  public static void setSceneName(String sceneName) {
    GameMap.sceneName = sceneName;
  }

}
