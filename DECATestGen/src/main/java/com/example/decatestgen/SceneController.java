package com.example.decatestgen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    Screen screen = Screen.getPrimary();
    double width = screen.getBounds().getWidth();
    double height = screen.getBounds().getHeight();
    double widthRatio = width / 1920.0;
    double heightRatio = height / 1080.0;

    public SceneController()
    {

    }
    public void switchFirstScreen(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();

    }

    public void switchSettings(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("SettingsScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();
    }

    public void switchResults(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ResultsScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();
    }

    public void switchTesting(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("TestingScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();
    }

    public void switchQuickStudy(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("QuickStudy.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();
    }

    public void switchInstructions(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        root.setScaleX(widthRatio);
        root.setScaleY(heightRatio);
        root.setLayoutX((root.getLayoutX() * widthRatio));
        root.setLayoutY((root.getLayoutY() * heightRatio));

        stage.show();
    }
}