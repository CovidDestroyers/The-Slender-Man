package com.slenderman.scenes;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntroductionTest {


    @Test
    public void playIntro() throws InterruptedException {
    }

    @Test
    public void skipIntro() {
      Introduction introduction = new Introduction();
      assertEquals(3000, introduction.getSleep());
      introduction.skipIntro();
      assertEquals(0, introduction.getSleep());

    }

    @Test
    public void enter() {
    }
}
