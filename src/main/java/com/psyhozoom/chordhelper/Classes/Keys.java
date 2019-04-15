package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class Keys {
  String keyName;
  String[] keys = {"A","A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
  ArrayList<Keys> keysArrayList = new ArrayList();
  public static int KEY_LENGHT = 12; //number of notes; 12 notes starting from 0;


  public void initKeys() {
    for (int i =0;i<keys.length; i++){
      Keys k = new Keys();
      k.setKeyName(keys[i]);
      keysArrayList.add(k);
    }
  }


  public static ArrayList<String> shiftKeys(String rootNote){
    ArrayList<String> notes = new ArrayList<>();

    Keys keys = new Keys();
    keys.initKeys();

    //shift array keys to the right position
    int pos=0;

    for (int i =0; i < keys.getKeysArrayList().size();i++){
      if (keys.getKeysArrayList().get(i).keyName.equals(rootNote)){
        pos=i; //position to shift array elements
        break;
      }
    }

    //shifting for pos times
    ArrayList<Keys> tmpKeys = new ArrayList<>();
    String[] keyNotes = new String[Keys.KEY_LENGHT];

    for (int i=0; i<Keys.KEY_LENGHT; i++){
      if(pos == Keys.KEY_LENGHT) {
        pos=0;
      }
      keyNotes[i] = keys.getKeysArrayList().get(pos).keyName;
      pos++;
    }

    for (int i=0; i<keyNotes.length;i++){
      notes.add(keyNotes[i]);
    }

    return notes;
  }


  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public ArrayList<Keys> getKeysArrayList() {
    return keysArrayList;
  }


  @Override
  public String toString() {
    return keyName;
  }
}
