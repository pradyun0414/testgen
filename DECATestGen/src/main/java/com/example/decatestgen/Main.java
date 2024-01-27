package com.example.decatestgen;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;



public class Main extends Application {

    @FXML
    AnchorPane anchor = new AnchorPane();

    @Override
    public void start(Stage stage) throws IOException {

        //stage.setFullScreen(true);
        Parent root = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add()

        //MULTIPLY POSITIONS TOO YOU ONLY MULTIPLIED SCALE
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();
        System.out.println(width);
        System.out.println(height);
        double widthRatio = width / 1920.0;
        double heightRatio = height / 1080.0;


        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        //stage.setMaximized(true);

        stage.show();
        stage.setTitle("Reedy DECA Test Generator");

        //Image blue = new Image("stageimages/BlueDECADiamond.png");
        //stage.getIcons().add(blue);

        //remember to set the icon too

    }

    public static void main(String[] args) {

        //remember to set up databases here before you launch
        launch();
    }

}