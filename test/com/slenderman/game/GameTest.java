package com.slenderman.game;

import com.slenderman.scenes.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest {

  String currentDirectory = null;
  Game game = null;

  @Before
  public void test(){
    // Get current directory where a text file is
    currentDirectory = System.getProperty("user.dir");
    //System.out.println(currentDirectory);
    currentDirectory = currentDirectory + "/test/com/slenderman/game/files/";

    game = new Game();
    game.setDisableIntroduction(true);
  }

  @After
  public void tear_down_process(){
    game.setDisableIntroduction(false);
  }

  @Test
  public void command_quit() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGame.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Forest().getClass());
  }

  @Test
  public void command_goSouth_to_Shed() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShed.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Shed().getClass());
  }

  @Test
  public void command_to_Shed_Cave() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShedCave.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Cave().getClass());
  }

  @Test
  public void command_to_Shed_Cave_House() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShedCaveHouse.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new House().getClass());
  }

  @Test
  public void command_to_Shed_Cave_Pond() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShedCavePond.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Pond().getClass());
  }

  @Test
  public void command_to_Shed_Cave_Pond_Field() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShedCavePondField.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Field().getClass());
  }

  @Test
  public void command_to_Shed_Cave_Pond_Field_Tree() {
    Scanner sc = setUpScanner(currentDirectory, "userInputGameShedCavePondFieldTree.txt");
    // Set Scanner -> pass the scanner into enter()
    executeGameStart(sc);
    System.out.println(game.getCurrentScene().getClass());
    assertEquals(game.getCurrentScene().getClass(), new Tree().getClass());
  }

  private Scanner setUpScanner(String fileDirectory, String filename) {
    Scanner sc = null;
    try{
      String path = fileDirectory + filename;
      //System.out.println(path);
      sc = new Scanner(new File(path));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return sc;
  }

  private void executeGameStart(Scanner sc){
    try {
      game.start(sc);
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}
