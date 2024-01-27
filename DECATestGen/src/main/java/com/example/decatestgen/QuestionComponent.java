package com.example.decatestgen;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuestionComponent extends VBox
{
    private Label questionLabel;
    private RadioButton answer1button;
    private RadioButton answer2button;
    private RadioButton answer3button;
    private RadioButton answer4button;
    private ToggleGroup toggleGroup;

    private String correctAns;
    private String explanation;
    private String category;

    public QuestionComponent(String question, String answer1, String answer2, String answer3, String answer4, String correctAns, String explanation, String category)
    {

        questionLabel = new Label(question);
        answer1button = new RadioButton(answer1);
        answer2button = new RadioButton(answer2);
        answer3button = new RadioButton(answer3);
        answer4button = new RadioButton(answer4);
        toggleGroup = new ToggleGroup();

        answer1button.setToggleGroup(toggleGroup);
        answer2button.setToggleGroup(toggleGroup);
        answer3button.setToggleGroup(toggleGroup);
        answer4button.setToggleGroup(toggleGroup);

        this.correctAns = correctAns;
        this.explanation = explanation;
        this.category = category;

        this.getChildren().addAll(questionLabel, answer1button, answer2button, answer3button, answer4button);

    }

    public String getAnswer()
    {
        return correctAns;
    }

    public String getCategory()
    {
        return category;
    }

    public String getExplanation()
    {
        return explanation;
    }

    public ToggleGroup getToggleGroup()
    {
        return toggleGroup;
    }
//
//    public boolean isAnswerCorrect()
//    {
//
//    }


















}
