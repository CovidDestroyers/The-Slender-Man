package com.slenderman.scenes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SceneImage {
  public static String mapForest(){
    return "\n" +
      "+-----------+-----------+\n" +
      "|  Forest   |   House   |\n" +
      "|           |           |\n" +
      "|  (Player) |           |\n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }
  public static String mapHouse() {
    return "\n" +
      "+-----------+-----------+\n" +
      "|  Forest   |   House   |\n" +
      "|           |           |\n" +
      "|           |  (Player) |\n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static String mapShed() {
    return "\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|  (Player) |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static String mapCave() {
    return "\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |  (Player) |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static String mapPond() {
    return "\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |  (Player) |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static String  mapField() {
    return "\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |  (Player) |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static String mapTree() {
    return "\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |  (Player) | \n" +
      "+-----------+-----------+-----------+-----------+-----------+";
  }

  public static Map<String, Function> sceneMap=new HashMap(){
    {
      put("forest",mapForest());
      put("house",mapHouse());
      put("cave",mapCave());
      put("field",mapField());
      put("pond",mapPond());
      put("shed",mapShed());
      put("tree",mapTree());
    }
  };
}
