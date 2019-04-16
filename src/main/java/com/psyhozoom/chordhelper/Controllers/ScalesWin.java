package com.psyhozoom.chordhelper.Controllers;

import com.psyhozoom.chordhelper.Classes.Chords;
import com.psyhozoom.chordhelper.Classes.ChordsProg;
import com.psyhozoom.chordhelper.Classes.Keys;
import com.psyhozoom.chordhelper.Classes.OscJava;
import com.psyhozoom.chordhelper.Classes.Scales;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScalesWin implements Initializable {

  public ComboBox<Keys> cmbKey;
  public ComboBox<Scales> cmbScale;
  public Label lScale;
  public VBox vb_interval_I;
  public VBox vb_interval_II;
  public VBox vb_interval_III;
  public VBox vb_interval_IV;
  public VBox vb_interval_V;
  public VBox vb_interval_VI;
  public VBox vb_interval_VII;
  public Button btest;
  public Label lScaleNote;
  public Label lScaleChordNotes;
  public HBox hboxChords;


  private OscJava oscJava = new OscJava();

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    btest.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        setScale(cmbScale.getValue());
      }
    });
    cmbKey.valueProperty().addListener(new ChangeListener<Keys>() {


      @Override
      public void changed(ObservableValue<? extends Keys> observable, Keys oldValue,
          Keys newValue) {
        setKey(newValue);
      }
    });

    cmbScale.valueProperty().addListener(new ChangeListener<Scales>() {
      @Override
      public void changed(ObservableValue<? extends Scales> observable, Scales oldValue,
          Scales newValue) {
        //setScale(newValue);
      }
    });

    loadKeys();
    loadScales();
  }

  private void loadKeys() {
    Keys keys = new Keys();
    keys.initKeys();
    ObservableList keysOb = FXCollections.observableArrayList(keys.getKeysArrayList());
    cmbKey.setItems(keysOb);
    cmbKey.getSelectionModel().select(0);
  }


  private void loadScales() {
    Scales scales = new Scales();
    scales.initScales();
    ObservableList list = FXCollections.observableList(scales.getScalesArrayList());
    cmbScale.setItems(list);
    cmbScale.getSelectionModel().select(0);
  }

  private void setChords() {
    if (cmbScale.getSelectionModel().getSelectedIndex() == -1)
      return;
    if (cmbKey.getSelectionModel().getSelectedIndex() == -1)
      return;
    Scales selectedScale = cmbScale.getSelectionModel().getSelectedItem();
    Keys key = cmbKey.getSelectionModel().getSelectedItem();
    lScale.setText(selectedScale.getPattern());

    Chords chords = new Chords();
    chords.initChords();
    Scales scales = new Scales();
    scales.initScales();


    //getAll chords of given scale
    ArrayList<ChordsProg> allChords = Scales.getAllChords(key.getKeyName(), selectedScale.getPattern());
    clearVBOXChords();
    ArrayList<String> s = allChords.get(0).getNote();
    String scalenotes="";
    for (String scalenote :s ) {
      scalenotes+=scalenote+" ";
    }
    lScaleNote.setText(scalenotes);

    for (int i = 0; i < 7; i++){
      ChordsProg chordsProg = allChords.get(i);
      VBox node = (VBox) hboxChords.getChildren().get(i);
      node.getChildren().add(new Label(chordsProg.getName()));
      for (int c=0; c<chordsProg.getChords().size(); c++) {
        Button butChord = new Button();
        butChord.setText(chordsProg.getNoteNames()+" "+chordsProg.getChords().get(c).getCode());
        ArrayList<String> notes = chordsProg.getChords().get(c).getNotes();

        butChord.setOnMousePressed(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              playNotes(notes);
          }
        });

        butChord.setOnMouseReleased(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            stopNotes(notes);
          }

        });


        node = (VBox) hboxChords.getChildren().get(i);
        node.getChildren().add(butChord);

      }
    }


  }



  private void clearVBOXChords() {
    for (int i=0; i< hboxChords.getChildren().size();i++) {
      VBox node = (VBox) hboxChords.getChildren().get(i);
      node.getChildren().clear();
    }
  }

  private void playNotes(ArrayList<String> notes) {
    System.out.println(String.format("Playing notes: %s", notes));
    String notePlay = "";
    for (String note : notes){
      notePlay+=note+" ";
    }
    lScaleChordNotes.setText(notePlay);
    oscJava.sendNote(notes);
  }

  private void stopNotes(ArrayList<String> notes) {
    oscJava.stopNote(notes);
  }


  private void setScale(Scales newValue) {
    lScale.setText(newValue.getPattern());
    setChords();

  }

  private void setKey(Keys newValue) {
  }
}
