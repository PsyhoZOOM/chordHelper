package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class Scales {
 String name;
 String pattern;

 ArrayList<Scales> scalesArrayList = new ArrayList<>();



  public   void initScales(){
    //Major
    Scales scale = new Scales();
    scale.setName("Major");
    scale.setPattern("101011010101");
    scalesArrayList.add(scale);

    //Natural Minor
    scale = new Scales();
    scale.setName("Natural Minor");
    scale.setPattern("1011010110100");
    scalesArrayList.add(scale);

    //Harmonic Minor
    scale = new Scales();
    scale.setName("Harmonic Minor");
    scale.setPattern("101101011001");
    scalesArrayList.add(scale);

    //Melodic Minor
    scale = new Scales();
    scale.setName("Melodic Minor");
    scale.setPattern("101101010101");
    scalesArrayList.add(scale);

    //Pentatonic Minor
    scale = new Scales();
    scale.setName("Pentatonic Minor");
    scale.setPattern("101001010100");
    scalesArrayList.add(scale);

 }




public Keys shiftNotes(String rootNote){
    String notes="";

  char[] chars = pattern.toCharArray();
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
  int z=0;
  ArrayList<Keys> tmpKeys = new ArrayList<>();
  String[] keyNotes = new String[Keys.KEY_LENGHT];

  for (int i=0; i<Keys.KEY_LENGHT; i++){
    if(pos == Keys.KEY_LENGHT) {
      pos=0;
    }
    keyNotes[i] = keys.getKeysArrayList().get(pos).keyName;
    pos++;


  }


  Keys k = new Keys();
  for (int i=0; i<keyNotes.length;i++){
    Keys newKe= new Keys();
    newKe.setKeyName(keyNotes[i]);
    k.getKeysArrayList().add(i, newKe);
  }

  return k;




 }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public ArrayList<Scales> getScalesArrayList() {
    return scalesArrayList;
  }

  public void setScalesArrayList(
      ArrayList<Scales> scalesArrayList) {
    this.scalesArrayList = scalesArrayList;
  }

  @Override
  public String toString() {
    return name;
  }
}
