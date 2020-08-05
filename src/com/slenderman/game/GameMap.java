package com.slenderman.game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameMap {
  private static String sceneName;
  private Map<String, String> loc = new HashMap<>();

  public JTextArea makeMap(String sceneName) {
    setLoc(sceneName);
    JTextArea result = new JTextArea(15, 55);
    result.setBackground(Color.BLACK);
    result.setForeground(Color.GREEN);
    result.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    result.append("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|  " + getLoc().get("forest") + " |  "+ getLoc().get("house") +" |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|  "+ getLoc().get("shed") +" |  "+ getLoc().get("cave") +" |  "+ getLoc().get("pond") +" |  "+ getLoc().get("field") +" |  "+ getLoc().get("tree") +" | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");

    return result;
  }

  private void setLoc(String sceneName) {
    String cs = "";
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
  }

  public static String getSceneName() {
    return sceneName;
  }

  public static void setSceneName(String sceneName) {
    GameMap.sceneName = sceneName;
  }

  public Map<String, String> getLoc() {
    return loc;
  }
}
