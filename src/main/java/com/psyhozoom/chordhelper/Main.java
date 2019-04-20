package com.psyhozoom.chordhelper;

import java.net.URL;
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
    scene.getStylesheets().add(ClassLoader.getSystemResource("css/Main.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
