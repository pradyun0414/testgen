package com.example.decatestgen;

public class question {

    private String tag;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correct;
    private String correctExplanation;
    private String category;


    public question(String tag, String choiceA, String choiceB, String choiceC, String choiceD, String correct, String correctExplanation, String category)
    {
        this.tag = tag;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correct = correct;
        this.correctExplanation = correctExplanation;
        this.category = category;
    }

    public String getTag()
    {
        return tag;
    }

    public String getChoiceA()
    {
        return choiceA;
    }

    public String getChoiceB()
    {
        return choiceB;
    }

    public String getChoiceC()
    {
        return choiceC;
    }

    public String getChoiceD()
    {
        return choiceD;
    }

    public String getCorrect()
    {
        return correct;
    }

    public String getCorrectExplanation()
    {
        return correctExplanation;
    }

    public String getCategory()
    {
        return category;
    }

}
