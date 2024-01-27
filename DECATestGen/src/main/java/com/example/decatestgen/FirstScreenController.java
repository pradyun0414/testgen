package com.example.decatestgen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FirstScreenController {


    //storage objects are used to read the sheet into data and is then added into the bank for test category (ICDC, State, District)
    static storage districtStorage = new storage();
    static ArrayList<ArrayList<question>> DistrictBank = new ArrayList<ArrayList<question>>();

    static storage stateStorage = new storage();
    static ArrayList<ArrayList<question>> StateBank = new ArrayList<ArrayList<question>>();

    static storage ICDCStorage = new storage();
    static ArrayList<ArrayList<question>> ICDCBank = new ArrayList<ArrayList<question>>();

    static File districtFolder = new File("DistrictSheets");
    static File[] districtList = districtFolder.listFiles();

    static File stateFolder = new File("StateSheets");
    static File[] stateList = stateFolder.listFiles();

    static File ICDCFolder = new File("ICDCSheets");
    static File[] ICDCList = ICDCFolder.listFiles();
    static Random random = new Random();



    public FirstScreenController()
    {
        //make sure instance variables are ok if theyre already declared above. I don't need to declare here, right?
    }

    public static void fileToQuestion()
    {
        for (File file : districtList)
        {
            String name = "DistrictSheets/" + file.getName();
            districtStorage.sheetReader(name);
            districtStorage.listAdder(DistrictBank);
        }

        for (File file : stateList)
        {
            String name = "StateSheets/" + file.getName();
            stateStorage.sheetReader(name);
            stateStorage.listAdder(StateBank);
        }

        for (File file : ICDCList)
        {
            String name = "ICDCSheets/" + file.getName();
            ICDCStorage.sheetReader(name);
            ICDCStorage.listAdder(ICDCBank);
        }
    }


    //gets a random question from a specific category
    public static question districtGetter(int index)  //make back to question return type
    {
//        copied from initialize method for purpose of testing
//


        int len = DistrictBank.get(index).size();
        int chosen = random.nextInt(len);

        return DistrictBank.get(index).get(chosen);
        //ill have to add a size checker method in this class which will then be called in the settings class (checks size of each index and the list it holds).
    }

    public static question stateGetter(int index)
    {
        int len = StateBank.get(index).size();
        int chosen = random.nextInt(len);
        return StateBank.get(index).get(chosen);
    }

    public static question ICDCGetter(int index)
    {
        int len = ICDCBank.get(index).size();
        int chosen = random.nextInt(len);
        return ICDCBank.get(index).get(chosen);
    }

    //checks to see if a specific category is an empty list (has no questions for that category)
    public static boolean districtNotEmpty(int index)
    {
            return DistrictBank.get(index).size() > 0;
    }

    public static boolean stateNotEmpty(int index)
    {
        return StateBank.get(index).size() > 0;
    }

    public static boolean ICDCNotEmpty(int index)
    {
        return ICDCBank.get(index).size() > 0;
    }



    //sets up database on opening of software
    public void initialize()
    {
        for (File file : districtList)
        {
            String name = "DistrictSheets/" + file.getName();
            districtStorage.sheetReader(name);
            districtStorage.listAdder(DistrictBank);
        }

        for (File file : stateList)
        {
            String name = "StateSheets/" + file.getName();
            stateStorage.sheetReader(name);
            stateStorage.listAdder(StateBank);
        }

        for (File file : ICDCList)
        {
            String name = "ICDCSheets/" + file.getName();
            ICDCStorage.sheetReader(name);
            ICDCStorage.listAdder(ICDCBank);
        }
    }

    SceneController controller = new SceneController();
    SettingsController controller2 = new SettingsController();

    public void instructionSwitch(ActionEvent event) throws IOException
    {
        controller.switchInstructions(event);
    }

    public void settingsSwitch(ActionEvent event) throws IOException
    {
        controller.switchSettings(event);
    }

    public void testSwitch(ActionEvent event) throws IOException
    {
        controller.switchTesting(event);
    }



}
