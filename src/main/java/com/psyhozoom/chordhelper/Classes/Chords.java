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

    chord = new Chords();
    chord.setCode("dim");
    chord.setName("Diminished");
    chord.setPattern("1001001");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Suspended second");
    chord.setCode("sus2");
    chord.setPattern("10100001");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Suspended fourth");
    chord.setCode("sus4");
    chord.setPattern("10000101");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Major sixth");
    chord.setCode("maj6");
    chord.setPattern("1000100101");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Minor sixth");
    chord.setCode("min6");
    chord.setPattern("1001000101");
    chordsArrayList.add(chord);


    chord = new Chords();
    chord.setName("Seventh");
    chord.setCode("7");
    chord.setPattern("10001001001");
    chordsArrayList.add(chord);

    chord = new Chords();
    chord.setName("Major seventh");
    chord.setCode("maj7");
    chord.setPattern("100010010001");
    chordsArrayList.add(chord);

  }

  //pat        101011010101
  //chord AMaj 10001001
  //chord Amin 10010001

  public static ArrayList<String> getChordNotesOfScale(String note, String pattern){
    Chords chords = new Chords();
    chords.initChords();
    Keys keys = new Keys();
    keys.initKeys();
    ArrayList<String> notesOfScale = new ArrayList<>();

    ArrayList<String> notes = Keys.shiftKeys(note, Keys.getPosition(note));

    char[] pat = pattern.toCharArray();

    for (int i=0; i < pat.length; i++){
      if (pat[i]=='1')
        notesOfScale.add(notes.get(i));
    }


    return notesOfScale;
  }


  public static ArrayList<Chords> getChordsOfNotePatter(String note, String pattern){
    Chords chords = new Chords();
    chords.initChords();
    ArrayList<Chords> chordsArrayList = new ArrayList<>();

    char[] patChars = pattern.toCharArray();

    for (Chords cord : chords.getChordsArrayList()){
      char[] chars = cord.getCode().toCharArray();
      for (int i=0; i < chars.length; i++){
        if (chars[i] == '1' && patChars[i] !=1) continue;
      }
      chordsArrayList.add(cord);
    }

    return chordsArrayList;
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
