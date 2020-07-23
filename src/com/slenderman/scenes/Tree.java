package com.slenderman.scenes;

public class Tree extends Scene {
  public Tree(){
    setDescription("This is the last destination .");
  }
  @Override
  public void enter() {
    System.out.println("tree class working");
  }
}
