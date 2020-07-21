package com.slenderman.scenes;

public class Tree extends Scene {
  public Tree(){
    setDescription("You have reached a Tree.");
  }
  @Override
  public void enter() {
    System.out.println("tree class working");
  }
}
