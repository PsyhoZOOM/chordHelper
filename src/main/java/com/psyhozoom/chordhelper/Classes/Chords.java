package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class Chords {
  String name;
  String code;
  String pattern;
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

  public void getChords(String keyName, String pattern) {


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

}
