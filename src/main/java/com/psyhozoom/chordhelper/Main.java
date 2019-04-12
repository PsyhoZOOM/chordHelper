package com.psyhozoom.chordhelper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root;
    FXMLLoader fxmlLoader;
    fxmlLoader= new FXMLLoader(ClassLoader.getSystemResource("fxml/ScalesWin.fxml"));
    root = fxmlLoader.load();
    Scene scene =new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
