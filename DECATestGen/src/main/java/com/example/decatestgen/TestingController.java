package com.example.decatestgen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestingController
{

    //this is for the warning popup
    private Stage popupStage;
    int submitClicked = 0;
    ArrayList<question> qList = SettingsController.returnTest(); //using static SettingsController and deleted the object instance of the class
    @FXML
    VBox vb = new VBox();

    @FXML
    ScrollPane scroller = new ScrollPane();

    HBox buttonHolder;
    Button submit;

    SceneController controller = new SceneController();

    public void setStage(Stage stage)
    {
        popupStage = stage;
    }

    public void initialize()
    {
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();
        double widthRatio = width / 1920.0;


        int counter = 1;
        vb.setPrefSize(1920, Region.USE_COMPUTED_SIZE);
        vb.setMaxHeight(Double.MAX_VALUE);
        for (question q : qList)
        {
            //removes the number and then any leading whitespace on a question
            String unedited = q.getTag();
            int periodIndex = unedited.indexOf("."); //first period (the one after the number)
            String newQuestion = unedited.substring(periodIndex+1);
            newQuestion = newQuestion.trim();
            String numberedQuestion = counter + ". " + newQuestion;
            counter++;

            QuestionComponent qComponent = new QuestionComponent(numberedQuestion, q.getChoiceA(), q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getCorrect(), q.getCorrectExplanation(), q.getCategory()); //might need to add category here
            qComponent.setMinSize(1920*widthRatio,110*widthRatio);
            qComponent.setMaxSize(1920*widthRatio,110*widthRatio);
            qComponent.setPrefSize(1920*widthRatio,110*widthRatio);
            qComponent.setPadding(new Insets(10*widthRatio,0,0,20*widthRatio));
            vb.getChildren().add(qComponent);

        }
        submit = new Button();
        submit.setAlignment(Pos.CENTER);
        submit.setText("Submit Test");
        submit.setPadding(new Insets(0,10*widthRatio,0,10*widthRatio));
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAnswers();
            }
        });

        buttonHolder = new HBox();
        buttonHolder.setPrefSize(1920*widthRatio,200*widthRatio);
        buttonHolder.setAlignment(Pos.CENTER);
        buttonHolder.getChildren().add(submit);
        vb.getChildren().add(buttonHolder);
        //extra space
        Region whiteSpace = new Region();
        whiteSpace.setPrefSize(1920*widthRatio,100*widthRatio);
        Color decaBlue = Color.web("#2A71B9");
        whiteSpace.setBackground(new Background( new BackgroundFill(decaBlue, CornerRadii.EMPTY, Insets.EMPTY)));
        vb.getChildren().add(whiteSpace);

    }

    public void checkAnswers()
    {
        if(submitClicked == 1)
        {
            return;
        }
        int correct = 0;
        int total = 0;
        int answersWithSelections = 0;

        for (Node node : vb.getChildren())
        {
            if (node instanceof QuestionComponent)
            {
                total++;
                QuestionComponent qc = (QuestionComponent) node;
                ToggleGroup tg = qc.getToggleGroup();
                RadioButton selected = (RadioButton) tg.getSelectedToggle();

                List<Toggle> answerList = tg.getToggles(); //gets the four toggles for each toggle group, then I need to cast to radiobutton since it is a type of toggle
                Toggle t1 = answerList.get(0);
                Toggle t2 = answerList.get(1);
                Toggle t3 = answerList.get(2);
                Toggle t4 = answerList.get(3);
                RadioButton rb1 = (RadioButton) t1;
                RadioButton rb2 = (RadioButton) t2;
                RadioButton rb3 = (RadioButton) t3;
                RadioButton rb4 = (RadioButton) t4;
                if (!(rb1.isSelected() == false && rb2.isSelected() == false && rb3.isSelected() == false && rb4.isSelected() == false))
                {
                    answersWithSelections++;
                }
            }
        }

        if(answersWithSelections == total)
        {
            for (Node node : vb.getChildren())
            {
                if (node instanceof QuestionComponent)
                {
                    QuestionComponent qc = (QuestionComponent) node;
                    ToggleGroup tg = qc.getToggleGroup();
                    RadioButton selected = (RadioButton) tg.getSelectedToggle();

                    String chosenText = "";
                    if (selected != null)
                    {
                        chosenText = selected.getText();
                    }
                    else {
                        System.out.println("Error");
                    }
                    String correctAnswer = qc.getAnswer();


                    //testing
                    System.out.println(correctAnswer);
                    System.out.println(chosenText);
                    //testing

                    List<Toggle> answerList = tg.getToggles(); //gets the four toggles for each toggle group, then I need to cast to radiobutton since it is a type of toggle
                    Toggle t1 = answerList.get(0);
                    Toggle t2 = answerList.get(1);
                    Toggle t3 = answerList.get(2);
                    Toggle t4 = answerList.get(3);
                    RadioButton rb1 = (RadioButton) t1;
                    RadioButton rb2 = (RadioButton) t2;
                    RadioButton rb3 = (RadioButton) t3;
                    RadioButton rb4 = (RadioButton) t4;
                    if(!(rb1.isSelected() == false && rb2.isSelected() == false && rb3.isSelected() == false && rb4.isSelected() == false))
                    {
                        if (rb1.getText().startsWith(correctAnswer.substring(0,1)))
                        {
                            rb1.setTextFill(Color.GREEN);
                            if(!rb1.isSelected())
                            {
                                selected.setTextFill(Color.RED);
                            }
                        }
                        if (rb2.getText().startsWith(correctAnswer.substring(0,1)))
                        {
                            rb2.setTextFill(Color.GREEN);
                            if(!rb2.isSelected())
                            {
                                selected.setTextFill(Color.RED);
                            }
                        }
                        if (rb3.getText().startsWith(correctAnswer.substring(0,1)))
                        {
                            rb3.setTextFill(Color.GREEN);
                            if(!rb3.isSelected())
                            {
                                selected.setTextFill(Color.RED);
                            }
                        }
                        if (rb4.getText().startsWith(correctAnswer.substring(0,1)))
                        {
                            rb4.setTextFill(Color.GREEN);
                            if(!rb4.isSelected())
                            {
                                selected.setTextFill(Color.RED);
                            }
                        }
                        if(chosenText.startsWith(correctAnswer.substring(0,1)))
                        {
                            correct++;
                        }
                    }
                    //try and make the label text wrap
                    //adds the correct explanation


                    //maybe change dimensions of the qc?
                    qc.setMinHeight(200);
                    qc.setPrefHeight(200);

                    Label explanation = new Label();
                    explanation.setWrapText(true);
                    explanation.setTextFill(Color.BLUE);
                    explanation.setMaxWidth(1800);
                    explanation.setPrefWidth(1800);
                    explanation.setPrefHeight(500);
                    explanation.setTextAlignment(TextAlignment.JUSTIFY);
                    String expWithCategory = qc.getCategory() + ": " + qc.getExplanation();
                    explanation.setText(expWithCategory);
                    qc.getChildren().add(explanation);
                }
            }
            submitClicked++;
            submit.setVisible(false);  //testing
            Button export = new Button();
            export.setAlignment(Pos.CENTER);
            export.setText("Export Test");
            export.setPadding(new Insets(0,10,0,10));
            buttonHolder.getChildren().add(export);

            Label score = new Label();
            double scorePercentage = (correct *1.0)/(total*1.0) * 100;
            scorePercentage = Math.round(scorePercentage);
            score.setPadding(new Insets(0,10,0,10));
            score.setText("Score: " + scorePercentage + " (" + correct + "/" + total + ")");
            buttonHolder.getChildren().add(score);

            //makes radiobuttons disabled so answers cant be changed
            for (Node node : vb.getChildren())
            {
                if (node instanceof QuestionComponent)
                {
                    QuestionComponent qc = (QuestionComponent) node;
                    ToggleGroup tg = qc.getToggleGroup();
                    for (Toggle toggle: tg.getToggles())
                    {
                        RadioButton rb = (RadioButton) toggle;
                        rb.setDisable(true);
                    }
                }
            }
        }

        else
        {
            Stage popup = new Stage();
            popup.initModality((Modality.APPLICATION_MODAL));
            popup.initOwner(popupStage);
            popup.setTitle("Error");
            //popup.getIcons().add(new Image("com.example.decatestgen.stageimages/RedX.png"));

            Label warningLabel = new Label("Warning: You have unanswered questions!");
            warningLabel.setTextFill(Color.RED);

            VBox vbox = new VBox(warningLabel);
            vbox.setAlignment(Pos.CENTER);
            warningLabel.setAlignment(Pos.CENTER);
            vbox.setPrefSize(300,300);

            Scene scene = new Scene(vbox);

            popup.setScene(scene);
            popup.show();

            //add X icon for the window and set the stage title to "Error"!

        }
    }

    public void BackWarning(ActionEvent event)
    {
        Stage popup = new Stage();
        popup.initModality((Modality.APPLICATION_MODAL));
        popup.initOwner(popupStage);
        popup.setTitle("Error");
        //popup.getIcons().add(new Image("com.example.decatestgen.stageimages/RedX.png"));

        Label warningLabel = new Label("Are you sure you want to exit? \nYou will not be able to come back!\n");
        warningLabel.setTextFill(Color.RED);
        warningLabel.setPadding(new Insets(0,0,10,0));

        Button goOn = new Button();
        goOn.setText("Continue");
        goOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.close();
                try {
                    controller.switchFirstScreen(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        VBox vbox = new VBox(warningLabel);
        vbox.getChildren().add(goOn);
        vbox.setAlignment(Pos.CENTER);
        warningLabel.setAlignment(Pos.CENTER);
        vbox.setPrefSize(300,300);

        Scene scene = new Scene(vbox);

        popup.setScene(scene);
        popup.show();
    }

}

