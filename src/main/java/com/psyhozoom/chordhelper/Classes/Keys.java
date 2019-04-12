package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class Keys {
  String keyName;
  String[] keys = {"A","A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
  ArrayList<Keys> keysArrayList = new ArrayList();


  public void initKeys() {
    for (int i =0;i<keys.length; i++){
      Keys k = new Keys();
      k.setKeyName(keys[i]);
      keysArrayList.add(k);
    }
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
