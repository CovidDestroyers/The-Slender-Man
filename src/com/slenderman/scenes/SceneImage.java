package com.slenderman.scenes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SceneImage {
  public static void printForest(){
    System.out.println("\n" +
      "+-----------+-----------+\n" +
      "|  Forest   |   House   |\n" +
      "|           |           |\n" +
      "|  (Player) |           |\n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }
  public static void printHouse() {
    System.out.println("\n" +
      "+-----------+-----------+\n" +
      "|  Forest   |   House   |\n" +
      "|           |           |\n" +
      "|           |  (Player) |\n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  public static void printShed() {
    System.out.println("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|  (Player) |           |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  public static void printCave() {
    System.out.println("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |  (Player) |           |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  public static void printPond() {
    System.out.println("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |  (Player) |           |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  public static void printField() {
    System.out.println("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           | \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |  (Player) |           | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  public static void printTree() {
    System.out.println("\n" +
      "+-----------+-----------+ \n" +
      "|  Forest   |   House   | \n" +
      "|           |           |  \n" +
      "|           |           | \n" +
      "+-----------+-----------+-----------+-----------+----------+ \n" +
      "|   Shed    |    Cave   |    Pond   |   Field   |   Tree    | \n" +
      "|           |           |           |           |  The End  | \n" +
      "|           |           |           |           |  (Player) | \n" +
      "+-----------+-----------+-----------+-----------+-----------+");
  }

  // return instead of print
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
