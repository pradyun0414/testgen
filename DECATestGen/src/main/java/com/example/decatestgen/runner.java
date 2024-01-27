package com.example.decatestgen;

import java.util.ArrayList;
import java.io.*;

public class runner {

    public static void main(String[] args)
    {



        SettingsController.BACTest();
        ArrayList<question> eugh = SettingsController.returnTest();


        for (question x : eugh)
        {
            System.out.println(x.getTag());
        }









        //storage objects are used to read the sheet into data and is then added into the bank for test category (ICDC, State, District)


//        storage districtStorage = new storage();
//        ArrayList<ArrayList<question>> DistrictBank = new ArrayList<ArrayList<question>>();
//
//        storage stateStorage = new storage();
//        ArrayList<ArrayList<question>> StateBank = new ArrayList<ArrayList<question>>();
//
//        storage ICDCStorage = new storage();
//        ArrayList<ArrayList<question>> ICDCBank = new ArrayList<ArrayList<question>>();
//
//        File districtFolder = new File("DistrictSheets");
//        File[] districtList = districtFolder.listFiles();
//
//        File stateFolder = new File("StateSheets");
//        File[] stateList = stateFolder.listFiles();
//
//        File ICDCFolder = new File("ICDCSheets");
//        File[] ICDCList = ICDCFolder.listFiles();
//
//        for (File file : districtList)
//        {
//            String name = "DistrictSheets/" + file.getName();
//            districtStorage.sheetReader(name);
//            districtStorage.listAdder(DistrictBank);
//        }
//
//        for (File file : stateList)
//        {
//            String name = "StateSheets/" + file.getName();
//            stateStorage.sheetReader(name);
//            stateStorage.listAdder(StateBank);
//        }
//
//        for (File file : ICDCList)
//        {
//            String name = "ICDCSheets/" + file.getName();
//            ICDCStorage.sheetReader(name);
//            ICDCStorage.listAdder(ICDCBank);
//        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //testing printing

//        for (ArrayList<question> x : DistrictBank)
//        {
//            //putting a print statement here and removing the nested loop will print an arraylist for each category
//            for (question y : x)
//            {
//                //will print every question
//                System.out.println(y.getCorrectExplanation());
//                System.out.println();
//            }
//        }

    }
}
