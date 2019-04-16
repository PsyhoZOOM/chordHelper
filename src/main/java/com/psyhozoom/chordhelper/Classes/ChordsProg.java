package com.psyhozoom.chordhelper.Classes;

import java.util.ArrayList;

public class ChordsProg {
  ArrayList<String> note = new ArrayList<>();
  ArrayList<Chords> chords = new ArrayList<>();
  String name;
  String scaleName;
  String pattern;
  String intervals;
  String noteNames;

  public final int lenght = 7;

  public void setScaleName(String scaleName) {
    this.scaleName = scaleName;
  }

  public ArrayList<String> getNote() {
    return note;
  }



  public ArrayList<Chords> getChords() {
    return chords;
  }

  public void setChords(Chords chords) {
    this.chords.add(chords);
  }

  public String getScaleName() {
    return scaleName;
  }

  public void setNote(ArrayList<String> note) {
    this.note = note;
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

  public String getIntervals() {
    return intervals;
  }

  public void setIntervals(String intervals) {
    this.intervals = intervals;
  }

  public String getNoteNames() {
    return noteNames;
  }

  public void setNoteNames(String noteNames) {
    this.noteNames = noteNames;
  }
}
