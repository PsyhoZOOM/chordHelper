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


  public static ArrayList<String> shiftNote(String rootNote){
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


  public static ArrayList<String> shiftKeys(String note, int position){
    ArrayList<String> stringNotes = new ArrayList<>();
    Keys keys  = new Keys();
    keys.initKeys();
    ArrayList<Keys> keysArrayList = keys.getKeysArrayList();
    int pos =0;
    for (int i=0; i<KEY_LENGHT; i++){
      if (position==KEY_LENGHT)
        position=0;
      stringNotes.add(pos, keysArrayList.get(position).keyName);
      position++;
      pos++;


    }

    return stringNotes;

  }

  public static ArrayList<String> getNotesOfScale(String note, String pattern){
    int pos =0;
    Keys keys = new Keys();
    keys.initKeys();
    ArrayList<String> strings = Keys.shiftNote(note);
    ArrayList<String> notesArr = new ArrayList<>();


    char[] patChar = pattern.toCharArray();
    for (int i =0; i < patChar.length;i++){
      if (patChar[i] == '1')
        notesArr.add(strings.get(i));
    }

    return notesArr;
  }

  public static int getPosition(String note){
    Keys keys = new Keys();
    keys.initKeys();
    for (int i = 0; i < keys.getKeysArrayList().size(); i++){
      if (note.equals(keys.getKeysArrayList().get(i).keyName)){
        return i;
      }
    }
    return 0;
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
