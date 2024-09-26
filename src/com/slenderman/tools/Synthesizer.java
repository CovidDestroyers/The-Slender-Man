package com.slenderman.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Synthesizer {
  public static void getAudioTxt() throws IOException {
    URL obj = new URL("https://texttospeech.googleapis.com/v1/text:synthesize");
    HttpURLConnection postConnection=(HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("POST");

    postConnection.setDoOutput(true);
    OutputStream os = postConnection.getOutputStream();
  }
}
