package com.psyhozoom.chordhelper.Classes;


import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCSerializeException;
import com.illposed.osc.transport.udp.OSCPortOut;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

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
      int note = noteToMidi(send.get(i)+"4");
      System.out.println(note);
      Object[] arg = {new Integer(-1), new Integer(-1), new Integer(note), new Integer(100)};

      message = new OSCMessage("/renoise/trigger/note_on", Arrays.asList(arg));

      try {
        osc.send(message);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (OSCSerializeException e) {
        e.printStackTrace();
      }
    }
  }

  public void stopNote(ArrayList<String> send){

    for (int i=0; i<send.size(); i++) {
      int note = noteToMidi(send.get(i)+"4");
      Object[] arg = {new Integer(-1), new Integer(-1), new Integer(note)};

      message = new OSCMessage("/renoise/trigger/note_off", Arrays.asList(arg));

      try {
        osc.send(message);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (OSCSerializeException e) {
        e.printStackTrace();
      }
    }
  }



  private int noteToMidi(String noteAndOctave){
    System.out.println(String.format("contver %s",noteAndOctave));
    if (!noteAndOctave
        .matches("^(C|C#|D|D#|E|F|F#|G|G#|A|A#|B)(-1|[0-9])$")) {
      System.out.println("note " + noteAndOctave
          + " is not a muscial note.");
      System.exit(1);
    }

    char note = noteAndOctave.charAt(0);

    int noteValue = -100;

    switch (note) {
      case 'C':
        noteValue = 0;
        break;
      case 'D':
        noteValue = 2;
        break;
      case 'E':
        noteValue = 4;
        break;
      case 'F':
        noteValue = 5;
        break;
      case 'G':
        noteValue = 7;
        break;
      case 'A':
        noteValue = 9;
        break;
      case 'B':
        noteValue = 11;
        break;
      default:
        System.out.println("This should never be reached.");
        System.exit(1);
        break;
    }

    boolean sharp = noteAndOctave.contains("#");

    // if it's sharp, the note value goes up by one
    if (sharp) {
      //System.out.println("There is a sharp");
      noteValue += 1;
    }

    //System.out.println("notevalue: " + noteValue);

    int octaveIndex = -100;

    // set the starting index for the octave
    if (sharp)
      octaveIndex = 2;
    else
      octaveIndex = 1;

    //System.out.println("octaveIndex is " + octaveIndex);

    int octave = -100;

    try {
      // figure out the octave
      octave = Integer.parseInt(noteAndOctave.substring(octaveIndex));
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }

    //System.out.println("octave is " + octave);

    return (octave + 1) * 12 + noteValue;

  }
}
