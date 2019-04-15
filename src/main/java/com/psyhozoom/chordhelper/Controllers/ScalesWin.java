package com.psyhozoom.chordhelper.Controllers;

import com.psyhozoom.chordhelper.Classes.Chords;
import com.psyhozoom.chordhelper.Classes.Keys;
import com.psyhozoom.chordhelper.Classes.Scales;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;

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
    lScaleNote.setText("");
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
    ArrayList<Chords> allChords = Scales.getAllChords(key.getKeyName(), selectedScale.getPattern());

    for (Chords ch : allChords){
      System.out.println(ch.getName());
    }

  }


  private void setScale(Scales newValue) {
    lScale.setText(newValue.getPattern());
    setChords();

  }

  private void setKey(Keys newValue) {
  }
}
