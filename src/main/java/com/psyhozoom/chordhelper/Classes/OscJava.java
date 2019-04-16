package com.psyhozoom.chordhelper.Classes;


import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortOut;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class OscJava  {
  int port = 8000;
  InetAddress ip;
  OSCPortOut osc;


  public OscJava() {
    try {
      ip = InetAddress.getByName("127.0.0.1");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    try {
      osc = new OSCPortOut(ip, port);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  public void sendNote(ArrayList<String> send){
    List<String> arg = send;
    arg.add("ee");
    arg.add("oo");

    OSCMessage message = new OSCMessage("/renoise");



  }
}
