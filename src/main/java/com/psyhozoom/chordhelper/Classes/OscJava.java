package com.psyhozoom.chordhelper.Classes;


import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortOut;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class OscJava  {
  int port = 8000;
  InetAddress ip;
  OSCPortOut osc;
  private OSCMessage message;


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
    for (int i=0; i<send.size(); i++) {
      int note = noteToMidi(send.get(i));
      Object[] arg = {new Integer(-1), new Integer(-1), note, new Integer(100)};

      message = new OSCMessage("/renoise/trigger/note_on", Arrays.asList(arg));

      try {
        osc.send(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void stopNote(ArrayList<String> send){

    for (int i=0; i<send.size(); i++) {
      int note = noteToMidi(send.get(i));
      Object[] arg = {new Integer(-1), new Integer(-1), new Integer(note)};

      message = new OSCMessage("/renoise/trigger/note_off", Arrays.asList(arg));

      try {
        osc.send(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }



  private int noteToMidi(String note){
    String sym = "";
    int oct = 0;
    String[][] notes = { {"C"}, {"Db", "C#"}, {"D"}, {"Eb", "D#"}, {"E"},
        {"F"}, {"Gb", "F#"}, {"G"}, {"Ab", "G#"}, {"A"}, {"Bb", "A#"}, {"B"} };

    char[] splitNote = note.toCharArray();

    // If the length is two, then grab the symbol and number.
    // Otherwise, it must be a two-char note.
    if (splitNote.length == 2) {
      sym += splitNote[0];
      oct = splitNote[1];
    } else if (splitNote.length == 3) {
      sym += Character.toString(splitNote[0]);
      sym += Character.toString(splitNote[1]);
      oct = splitNote[2];
    }

    // Find the corresponding note in the array.
    for (int i = 0; i < notes.length; i++)
      for (int j = 0; j < notes[i].length; j++) {
        if (notes[i][j].equals(sym)) {
          return Character.getNumericValue(oct) * 12 + i;
        }
      }

    // If nothing was found, we return -1.
    return -1;
  }
}
