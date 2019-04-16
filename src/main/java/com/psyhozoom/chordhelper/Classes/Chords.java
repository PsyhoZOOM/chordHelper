package com.psyhozoom.chordhelper.Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Chords {
  String name;
  String code;
  String pattern;
  String key;
  ArrayList<String> notes = new ArrayList<>();
  ArrayList<Chords> chordsArrayList = new ArrayList<>();


  public void  initChords() {
    setChords();
  }

  private void setChords() {
    Chords chord;


    try {
      FileReader fr = new FileReader("chords");
      BufferedReader br = new BufferedReader(fr);
      String line ;
      while ((line = br.readLine()) != null){
        String[] split = line.split(",");
        chord = new Chords();
        chord.setName(split[0].trim());
        chord.setCode(split[1].trim());
        chord.setPattern(split[2].trim());
        chordsArrayList.add(chord);


      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

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
    ArrayList<String> notes = Keys.shiftNote(note);

    char[] patChars = pattern.toCharArray();

    for (Chords ch : chords.getChordsArrayList()){
      boolean match = false;
      char[]  chordChars = ch.getPattern().toCharArray();
      for (int i =0; i < chordChars.length; i++){
        if (chordChars[i] == '1' && patChars[i] != '1') {
          match = false;
          break;
        }
        match=true;
      }
      if (match){
        ch.setNotes(getNotesOfPatterNote(note, ch.getPattern()));
       chordsArrayList.add(ch);
      }
    }

    return chordsArrayList;
  }

  private static ArrayList<String> getNotesOfPatterNote(String note, String pattern) {
    ArrayList<String> strings = Keys.shiftNote(note);
    ArrayList<String> notes = new ArrayList<>();

    char[] patChars = pattern.toCharArray();
    for (int i=0; i<patChars.length; i++){
      if (patChars[i] == '1')
        notes.add(strings.get(i));
    }

    return notes;
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

  public ArrayList<String> getNotes() {
    return notes;
  }

  public void setNotes(ArrayList<String> notes) {
    this.notes = notes;
  }
}
