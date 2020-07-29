package com.slenderman.scenes;

import com.slenderman.actors.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaveTest {

  String currentDirectory = null;
  Cave cave = null;
  Player player = null;

  @Before
  public void get_fileDirectory() {
    // Get current directory where a text file is
    currentDirectory = System.getProperty("user.dir");
    //System.out.println(currentDirectory);
    currentDirectory = currentDirectory + "/test/com/slenderman/scenes/files/cave/";
    cave = new Cave();
    player = new Player();
  }

  @Test
  public void adding_unlockBoatDoor_to_localCollection(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qRYcr.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.getLocalItems().contains("UNLOCK_BOAT_DOOR"));
  }

  @Test
  public void check_pick_up_boat_flag_initial_status(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qRYcr.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertFalse(cave.getIsPlayerWithBoat());
  }

  @Test
  public void check_pick_up_boat_flag(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrRYcrY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.getIsPlayerWithBoat());
  }


  @Test
  public void inFrontOfCave_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern.txt");

    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void stepIntoTheCave_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void walkAroundInFrontOfCave_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern1.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void walkAroundInFrontOfCave_option2_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern12.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void investigateTheBushes_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0q.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_LookLeft_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrL.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_LookRight_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrR.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_UnlockCode_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrRYcr.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_TryCombination_Successful_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrRYcrY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_TryCombination_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_UnlockCodeByBook_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRYwc.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_UnlockCodeByBookFlip_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRYwcY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_TryCombination_goBack_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern0qrRYwr.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_LookLeft_withBoat_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRYYprcrYL.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void exploreCave_LookLeft_withBoat_y_for_iteration_within_boundary(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRYYprcrYLY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.is_max_iteration_not_reached());
  }

  @Test
  public void adding_notebook_to_localCollection(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.getLocalItems().contains("NOTEBOOK"));
  }

  @Test
  public void test_execute(){
    Scanner sc = setUpScanner(currentDirectory, "userInputCavePattern10Y0qrRYYprcrYLY.txt");
    // Set Scanner -> pass the scanner into enter()
    executeCaveEnter(sc);
    // Compare
    assertTrue(cave.getIsPlayerWithBoat());
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

  private void executeCaveEnter(Scanner sc){
    try {
      cave.enter(sc, player);
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}
