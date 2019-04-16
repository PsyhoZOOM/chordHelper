package com.psyhozoom.chordhelper.Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Scales {
 String name;
 String pattern;

 ArrayList<Scales> scalesArrayList = new ArrayList<>();



  public   void initScales(){

    URL scales = ClassLoader.getSystemResource("scales");

    try {
      FileReader fr = new FileReader(scales.getFile());
      BufferedReader bfr = new BufferedReader(fr);
      String line;
      while ((line = bfr.readLine()) != null){
        String[] split = line.split(",");
        Scales sc = new Scales();
        sc.setName(split[0].trim());
        sc.setPattern(split[1].trim());
        scalesArrayList.add(sc);
      }

      bfr.close();
      fr.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


 public static ArrayList<String> shiftScale(String scalePattern, int position){
    ArrayList<String> patterLlist = new ArrayList<>();
    char[] scaletmp = new char[scalePattern.length()];
    char[] scaleCh = scalePattern.toCharArray();

    for (int i =0; i < scalePattern.length(); i++){
      if (position== scalePattern.length())
        position=0;

      scaletmp[i] = scaleCh[position];
      patterLlist.add(String.valueOf(scaleCh[position]));
      position++;


    }

    return patterLlist;
 }



 public static ArrayList<ChordsProg> getAllChords(String note, String pattern){
    ArrayList<ChordsProg> chordsProgs = new ArrayList<>();
    Keys keys = new Keys();
    keys.initKeys();
    Chords chords = new Chords();
    chords.initChords();
    Scales scales = new Scales();
    scales.initScales();



    //note is key, pattern is scale
   //find all notes in scale
   ArrayList<String> notesOfScale = Keys.shiftNote(note);
   ArrayList<String> currentNote = Keys.getNotesOfScale(note, pattern);




   System.out.println(String.format("Scale: %s", note));
   for (int i=0; i <notesOfScale.size(); i++) {

     ArrayList<String> strings = Scales.shiftScale(pattern, i);
     String patternNew = Scales.PatternToString(strings);

     if (currentNote.contains(notesOfScale.get(i))){
       ArrayList<String> allNotesOfScale = Keys.getNotesOfScale(notesOfScale.get(i), patternNew);
       ArrayList<Chords> allCHords = Chords.getChordsOfNotePatter(notesOfScale.get(i), patternNew);

       ChordsProg chordsProg = new ChordsProg();
       chordsProg.setNoteNames(notesOfScale.get(i));
       chordsProg.setScaleName(getModeName(patternNew));
       chordsProg.setNote(allNotesOfScale);
       chordsProg.setPattern(patternNew);




       System.out.println(
           String.format("Chords starting with:%s, pattern: %s , mode: %s, Chords: ",
               notesOfScale.get(i),
                   patternNew,
               getModeName(patternNew)
           ));
       for(Chords ch : allCHords){
         System.out.println(String.format("%s %s %s",notesOfScale.get(i), ch.getCode(), ch.getNotes()));
         chordsProg.setChords(ch);
       }
       chordsProgs.add(chordsProg);
     }
   }


   return chordsProgs;
   }



   public static String getModeName(String pattern){
    Scales scales  = new Scales();
    scales.initScales();

    for (Scales scale : scales.getScalesArrayList()){
      String s = scale.getPattern();
      if (s.contains(pattern))
        return scale.getName();
    }
    return "Scala nije definisana";
   }




   public static String PatternToString(ArrayList<String> pat){
    String pattern = "";
    for (String s : pat){
      pattern+=s;
    }

    return pattern;

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
