package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class Chords {
  String name;
  String code;
  String pattern;
  String key;
  String notes;
  ArrayList<Chords> chordsArrayList = new ArrayList<>();


  public void  initChords() {
    setChords();
  }

  private void setChords() {
    Chords chord = new Chords();
    chord.setName("Major");
    chord.setCode("Maj");
    chord.setPattern("10001001");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Minor");
    chord.setCode("min");
    chord.setPattern("10010001");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Augmented");
    chord.setCode("aug");
    chord.setPattern("100010001");
    chordsArrayList.add(chord);

  }

  //pat        101011010101
  //chord AMaj 10001001
  //chord Amin 10010001

  public Chords getChords(String keyName, Scales pattern,
      ArrayList<Keys> keysArrayList) {
    Chords chords = new Chords();
    chords.setKey(keyName);

    String notes = "";

    for (int i=0; i< chordsArrayList.size();i++){
      Chords chCheck = chordsArrayList.get(i);
      String patCheck = chCheck.getPattern();

      char[] scalePatter = patCheck.toCharArray();

      for (int z=0; z<scalePatter.length;z++){
        if (patCheck.toCharArray()[z] == '1' && pattern.getPattern().toCharArray()[z] != '1')
          break;

        if (patCheck.toCharArray()[z] =='1' && pattern.getPattern().toCharArray()[z] =='1'){
          Chords chordFiting=new Chords();
          chordFiting.setKey(keyName);
          chords.getChordsArrayList().add(chordFiting);
          notes = notes+keysArrayList.get(z);
        }
      }

    }

    System.out.println(notes);

    return chords;





  }


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public ArrayList<Chords> getChordsArrayList() {
    return chordsArrayList;
  }

  public void setChordsArrayList(
      ArrayList<Chords> chordsArrayList) {
    this.chordsArrayList = chordsArrayList;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
