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


 public static String shiftScale(String scalePattern, int position){
    char[] scaletmp = new char[scalePattern.length()];
    char[] scaleCh = scalePattern.toCharArray();

    for (int i =0; i < scalePattern.length(); i++){
      if (position== scalePattern.length())
        position=0;

      scaletmp[i] = scaleCh[position];
      position++;


    }

   System.out.println(scaletmp);



    return scaletmp.toString();
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
