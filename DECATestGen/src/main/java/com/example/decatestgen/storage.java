package com.example.decatestgen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
//cant use xssf can only use hssf the methods threw a FileNotFoundError
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class storage {
    ArrayList<question> BL;
    ArrayList<question> CM;
    ArrayList<question> CO;
    ArrayList<question> CR;
    ArrayList<question> EC;
    ArrayList<question> EI;
    ArrayList<question> EN;
    ArrayList<question> FI;
    ArrayList<question> FM;
    ArrayList<question> HR;
    ArrayList<question> IM;
    ArrayList<question> KM;
    ArrayList<question> MP;
    ArrayList<question> MK;
    ArrayList<question> NF;
    ArrayList<question> OP;
    ArrayList<question> PI;
    ArrayList<question> PM;
    ArrayList<question> PD;
    ArrayList<question> PR;
    ArrayList<question> PJ;
    ArrayList<question> QM;
    ArrayList<question> RM;
    ArrayList<question> SE;
    ArrayList<question> SM;

    public storage()
    {
        BL = new ArrayList<question>();
        CM = new ArrayList<question>();
        CO = new ArrayList<question>();
        CR = new ArrayList<question>();
        EC = new ArrayList<question>();
        EI = new ArrayList<question>();
        EN = new ArrayList<question>();
        FI = new ArrayList<question>();
        FM = new ArrayList<question>();
        HR = new ArrayList<question>();
        IM = new ArrayList<question>();
        KM = new ArrayList<question>();
        MP = new ArrayList<question>();
        MK = new ArrayList<question>();
        NF = new ArrayList<question>();
        OP = new ArrayList<question>();
        PI = new ArrayList<question>();
        PM = new ArrayList<question>();
        PD = new ArrayList<question>();
        PR = new ArrayList<question>();
        PJ = new ArrayList<question>();
        QM = new ArrayList<question>();
        RM = new ArrayList<question>();
        SE = new ArrayList<question>();
        SM = new ArrayList<question>();
    }

    //exists because the arraylists are private instance variables and can not be accessed directly.. (verify)
    public void listAdd(ArrayList<question> target, question q)
    {
        target.add(q);
    }

    public void sheetReader(String name)   //make the parameter the sheet name so we can access every sheet in a file
    {

        //these are used to create question objects for each sheet
        ArrayList<String> tagList = new ArrayList<String>();
        ArrayList<String> AList = new ArrayList<String>();
        ArrayList<String> BList = new ArrayList<String>();
        ArrayList<String> CList = new ArrayList<String>();
        ArrayList<String> DList = new ArrayList<String>();
        ArrayList<String> correctList = new ArrayList<String>();
        ArrayList<String> explanationList = new ArrayList<String>();
        ArrayList<String> catList = new ArrayList<String>();

        //open file
        String fileName = name; //make sure you fix this to automate
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();

        for (int i=0; i < 100; i++) //we put 100 because we want this to go through the actual questions portion of the sheet, not the solutions
        {

            String Qtag = "";
            String A = "";
            String B = "";
            String C = "";
            String D = "";

            Row row = sheet.getRow(i);
            if (row==null) //make sure no bugs
            {
                continue;
            }
            int cellCount = row.getLastCellNum();
            for (int j=0; j<cellCount; j++)
            {
                Cell cell = row.getCell(j);
                Cell prevCell;
                String prevCellContent = "";

                if(j!=0)
                {
                    prevCell = row.getCell(j-1);
                    if(prevCell == null)
                    {
                        continue;
                    }
                    prevCellContent = prevCell.toString();
                }
                if (cell==null) //checks for null
                {
                    continue;
                }
                String cellContent = cell.toString();


                if (j==0)
                {
                    Qtag += cellContent;
                    //Qtag = Qtag.split(".",2)[0]; //split method splits after the first period into a list and then gets the 1st index (rest of question) FIX THIS!!!!
                }
                else if (cellContent.startsWith("A."))
                {
                    A += cellContent;
                }
                else if (cellContent.startsWith("B."))
                {
                    B += cellContent;
                }
                else if (cellContent.startsWith("C."))
                {
                    C += cellContent;
                }
                else if (cellContent.startsWith("D."))
                {
                    D += cellContent;
                }
                else
                {
                    if(prevCellContent.startsWith("A."))
                    {
                        A += " " + cellContent;
                    }
                    else if(prevCellContent.startsWith("B."))
                    {
                        B += " " + cellContent;
                    }
                    else if(prevCellContent.startsWith("C."))
                    {
                        C += " " + cellContent;
                    }
                    else if(prevCellContent.startsWith("D."))
                    {
                        D += " " + cellContent;
                    }
                    else
                    {
                        Qtag += " " + cellContent;
                    }
                }
            }
            tagList.add(Qtag);
            AList.add(A);
            BList.add(B);
            CList.add(C);
            DList.add(D);
        }

        //reads solutions

        for (int i=100; i < 199; i++) //we put 100 because we want this to go through the actual questions portion of the sheet, not the solutions
        {

            String correctAns = "";
            String explanation = "";
            String Qcat = ""; //category

            Row row = sheet.getRow(i);
            if (row==null) //make sure no bugs
            {
                continue;
            }
            int cellCount = row.getLastCellNum();
            for (int j=0; j<cellCount; j++)
            {
                Cell cell = row.getCell(j);

                if (cell==null) //checks for null
                {
                    continue;
                }

                String cellContent = cell.toString();

                if (j==0)
                {
                    if(cellContent.contains("A"))
                    {
                        correctAns += "A";
                    }
                    else if(cellContent.contains("B"))
                    {
                        correctAns += "B";
                    }
                    else if(cellContent.contains("C"))
                    {
                        correctAns += "C";
                    }
                    else if(cellContent.contains("D"))
                    {
                        correctAns += "D";
                    }
                }
                else if (cellContent.contains("SOURCE"))
                {
                    Qcat += catChecker(cellContent);
                }
                else
                {
                    explanation += cellContent;
                }
            }
            correctList.add(correctAns);
            explanationList.add(explanation);
            catList.add(Qcat);
        }

        //creates question objects and then adds it to correct list based on category

        String[] indexList = {"BL", "CM", "CO", "CR", "EC", "EI", "EN", "FI", "FM", "HR", "IM", "KM", "MP", "MK", "NF", "OP", "PI", "PM", "PD", "PR", "PJ", "QM", "RM", "SE", "SM"};
        ArrayList<ArrayList<question>> ListOfList = new ArrayList<ArrayList<question>>();
        ListOfList.add(BL);
        ListOfList.add(CM);
        ListOfList.add(CO);
        ListOfList.add(CR);
        ListOfList.add(EC);
        ListOfList.add(EI);
        ListOfList.add(EN);
        ListOfList.add(FI);
        ListOfList.add(FM);
        ListOfList.add(HR);
        ListOfList.add(IM);
        ListOfList.add(KM);
        ListOfList.add(MP);
        ListOfList.add(MK);
        ListOfList.add(NF);
        ListOfList.add(OP);
        ListOfList.add(PI);
        ListOfList.add(PM);
        ListOfList.add(PD);
        ListOfList.add(PR);
        ListOfList.add(PJ);
        ListOfList.add(QM);
        ListOfList.add(RM);
        ListOfList.add(SE);
        ListOfList.add(SM);



        for (int i=0; i<99; i++)
        {
            question adder = new question(tagList.get(i), AList.get(i), BList.get(i), CList.get(i), DList.get(i), correctList.get(i), explanationList.get(i), catList.get(i));
            for (int j=0; j<25; j++)
            {
                if (catList.get(i).contains(indexList[j]))
                {
                    ListOfList.get(j).add(adder);
                }
            }
        }

        //testing by printing
//        for (question x : BL)
//        {
//            System.out.println(x);
//            System.out.println();
//        }

        //tests by printing out each instance variable arraylist and showing question objects
//        for (ArrayList<question> x : ListOfList)
//        {
//            System.out.println(x);
//            System.out.println();
//        }

    }
    public String catChecker(String cat)
    {
        if (cat.contains("BL"))
        {
            return "BL";
        }
        if (cat.contains("CM"))
        {
            return "CM";
        }
        if (cat.contains("CO"))
        {
            return "CO";
        }
        if (cat.contains("CR"))
        {
            return "CR";
        }
        if (cat.contains("EC"))
        {
            return "EC";
        }
        if (cat.contains("EI"))
        {
            return "EI";
        }
        if (cat.contains("EN"))
        {
            return "EN";
        }
        if (cat.contains("FI"))
        {
            return "FI";
        }
        if (cat.contains("FM"))
        {
            return "FM";
        }
        if (cat.contains("HR"))
        {
            return "HR";
        }
        if (cat.contains("IM"))
        {
            return "IM";
        }
        if (cat.contains("KM"))
        {
            return "KM";
        }
        if (cat.contains("MP"))
        {
            return "MP";
        }
        if (cat.contains("MK"))
        {
            return "MK";
        }
        if (cat.contains("NF"))
        {
            return "NF";
        }
        if (cat.contains("OP"))
        {
            return "OP";
        }
        if (cat.contains("PI"))
        {
            return "PI";
        }
        if (cat.contains("PM"))
        {
            return "PM";
        }
        if (cat.contains("PD"))
        {
            return "PD";
        }
        if (cat.contains("PR"))
        {
            return "PR";
        }
        if (cat.contains("PJ"))
        {
            return "PJ";
        }
        if (cat.contains("QM"))
        {
            return "QM";
        }
        if (cat.contains("RM"))
        {
            return "RM";
        }
        if (cat.contains("SE"))
        {
            return "SE";
        }
        if (cat.contains("SM"))
        {
            return "SM";
        }
        return "";
    }

    public void listAdder(ArrayList<ArrayList<question>> finalBank)
    {
        finalBank.add(BL);
        finalBank.add(CM);
        finalBank.add(CO);
        finalBank.add(CR);
        finalBank.add(EC);
        finalBank.add(EI);
        finalBank.add(EN);
        finalBank.add(FI);
        finalBank.add(FM);
        finalBank.add(HR);
        finalBank.add(IM);
        finalBank.add(KM);
        finalBank.add(MP);
        finalBank.add(MK);
        finalBank.add(NF);
        finalBank.add(OP);
        finalBank.add(PI);
        finalBank.add(PM);
        finalBank.add(PD);
        finalBank.add(PR);
        finalBank.add(PJ);
        finalBank.add(QM);
        finalBank.add(RM);
        finalBank.add(SE);
        finalBank.add(SM);
    }

}