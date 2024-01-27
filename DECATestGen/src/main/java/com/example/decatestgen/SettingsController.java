package com.example.decatestgen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class SettingsController {


    //MAKE SURE THE WHILE LOOPS (FOR 50 QUESTION TESTS) DONT GIVE CATEGORIES WITHOUT A QUESTION! MAY NEED TO ADD ANOTHER IF STATEMENT TO CHECK FOR THAT
    //MAKE SURE WHENEVER CHECKING A CATEGORY THAT ITS NOT 0 OTHERWISE JUST ADD FROM ANOTHER CATEGORY!!


    @FXML
    CheckBox cb1, cb2, cb3 = new CheckBox();

    @FXML
    AnchorPane settingsAnchor = new AnchorPane();

    @FXML
    private static ToggleGroup toggle1 = new ToggleGroup();
    @FXML
    private static ToggleGroup toggletest = new ToggleGroup();

    @FXML
    private static ToggleGroup toggleLength = new ToggleGroup();

    @FXML
    private RadioButton r1, r2, r3, r4, r5, r6;
    @FXML
    private RadioButton b1, b2, b3;
    @FXML
    private RadioButton l1, l2;

    private static ArrayList<question> currentTest = new ArrayList<question>();
    private static String blueprint = "";

    private static int testLength = 100;  //made a setter method

    private static boolean useDistrict = false;
    private static boolean useState = false;
    private static boolean useICDC = false;

    private static int BLCount = 0;
    private static int CMCount = 0;
    private static int COCount = 0;
    private static int CRCount = 0;
    private static int ECCount = 0;
    private static int EICount = 0;
    private static int ENCount = 0;
    private static int FICount = 0;
    private static int FMCount = 0;
    private static int HRCount = 0;
    private static int IMCount = 0;
    private static int KMCount = 0;
    private static int MPCount = 0;
    private static int MKCount = 0;
    private static int NFCount = 0;
    private static int OPCount = 0;
    private static int PICount = 0;
    private static int PMCount = 0;
    private static int PDCount = 0;
    private static int PRCount = 0;
    private static int PJCount = 0;
    private static int QMCount = 0;
    private static int RMCount = 0;
    private static int SECount = 0;
    private static int SMCount = 0;



    public void initialize() //testing
    {
        r1.setToggleGroup(toggletest);
        r2.setToggleGroup(toggletest);
        r3.setToggleGroup(toggletest);
        r4.setToggleGroup(toggletest);
        r5.setToggleGroup(toggletest);
        r6.setToggleGroup(toggletest);
        //System.out.println("Number of toggles in group: " + toggletest.getToggles().size());

        l1.setToggleGroup(toggleLength);
        l2.setToggleGroup(toggleLength);

        b1.setToggleGroup(toggle1);
        b2.setToggleGroup(toggle1);
        b3.setToggleGroup(toggle1);
    }

    public static void questionReset()
    {
        BLCount = 0;
        CMCount = 0;
        COCount = 0;
        CRCount = 0;
        ECCount = 0;
        EICount = 0;
        ENCount = 0;
        FICount = 0;
        FMCount = 0;
        HRCount = 0;
        IMCount = 0;
        KMCount = 0;
        MPCount = 0;
        MKCount = 0;
        NFCount = 0;
        OPCount = 0;
        PICount = 0;
        PMCount = 0;
        PDCount = 0;
        PRCount = 0;
        PJCount = 0;
        QMCount = 0;
        RMCount = 0;
        SECount = 0;
        SMCount = 0;
    }

    public static void MKTTest()
    {
        questionReset();
        if(blueprint.equals("District"))
        {
            BLCount = 2;
            CMCount = 5;
            COCount = 5;
            CRCount = 2;
            ECCount = 6;
            EICount = 9;
            ENCount = 1;
            FICount = 6;
            FMCount = 0;
            HRCount = 1;
            IMCount = 5;
            KMCount = 0;
            MPCount = 4;
            MKCount = 1;
            NFCount = 11;
            OPCount = 6;
            PICount = 3;
            PMCount = 11;
            PDCount = 6;
            PRCount = 9;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 6;
            SMCount = 1;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 2;
            CMCount = 6;
            COCount = 4;
            CRCount = 2;
            ECCount = 5;
            EICount = 8;
            ENCount = 0;
            FICount = 5;
            FMCount = 0;
            HRCount = 0;
            IMCount = 4;
            KMCount = 0;
            MPCount = 4;
            MKCount = 1;
            NFCount = 14;
            OPCount = 5;
            PICount = 4;
            PMCount = 13;
            PDCount = 5;
            PRCount = 11;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 7;
            SMCount = 0;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 1;
            CMCount = 7;
            COCount = 3;
            CRCount = 1;
            ECCount = 4;
            EICount = 6;
            ENCount = 0;
            FICount = 4;
            FMCount = 0;
            HRCount = 0;
            IMCount = 3;
            KMCount = 0;
            MPCount = 5;
            MKCount = 1;
            NFCount = 16;
            OPCount = 4;
            PICount = 4;
            PMCount = 15;
            PDCount = 5;
            PRCount = 13;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 8;
            SMCount = 0;
            createTestList();

        }
    }

    public static void BMATest()
    {
        questionReset();
        if(blueprint.equals("District"))
        {
            BLCount = 5;
            CMCount = 0;
            COCount = 7;
            CRCount = 2;
            ECCount = 6;
            EICount = 9;
            ENCount = 1;
            FICount = 7;
            FMCount = 0;
            HRCount = 1;
            IMCount = 7;
            KMCount = 6;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 21;
            PICount = 0;
            PMCount = 0;
            PDCount = 6;
            PRCount = 0;
            PJCount = 6;
            QMCount = 3;
            RMCount = 3;
            SECount = 0;
            SMCount = 9;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 6;
            CMCount = 0;
            COCount = 6;
            CRCount = 2;
            ECCount = 5;
            EICount = 8;
            ENCount = 0;
            FICount = 6;
            FMCount = 0;
            HRCount = 0;
            IMCount = 6;
            KMCount = 7;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 24;
            PICount = 0;
            PMCount = 0;
            PDCount = 5;
            PRCount = 0;
            PJCount = 7;
            QMCount = 4;
            RMCount = 4;
            SECount = 0;
            SMCount = 9;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 5;
            CMCount = 0;
            COCount = 6;
            CRCount = 1;
            ECCount = 4;
            EICount = 6;
            ENCount = 0;
            FICount = 5;
            FMCount = 0;
            HRCount = 0;
            IMCount = 6;
            KMCount = 9;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 26;
            PICount = 0;
            PMCount = 0;
            PDCount = 4;
            PRCount = 0;
            PJCount = 8;
            QMCount = 4;
            RMCount = 4;
            SECount = 0;
            SMCount = 11;
            createTestList();
        }
    }

    public static void BACTest()
    {
        questionReset();
        FirstScreenController.fileToQuestion();  //MAKE SURE YOU PUT THIS ON EVERYTHING!
        if(blueprint.equals("District"))
        {
            BLCount = 1;
            CMCount = 0;
            COCount = 15;
            CRCount = 5;
            ECCount = 7;
            EICount = 22;
            ENCount = 0;
            FICount = 15;
            FMCount = 0;
            HRCount = 1;
            IMCount = 10;
            KMCount = 0;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 11;
            PICount = 0;
            PMCount = 0;
            PDCount = 11;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 0;
            SMCount = 1;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 1;
            CMCount = 0;
            COCount = 15;
            CRCount = 5;
            ECCount = 7;
            EICount = 22;
            ENCount = 0;
            FICount = 15;
            FMCount = 0;
            HRCount = 1;
            IMCount = 10;
            KMCount = 0;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 11;
            PICount = 0;
            PMCount = 0;
            PDCount = 11;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 0;
            SMCount = 1;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 4;
            CMCount = 0;
            COCount = 11;
            CRCount = 4;
            ECCount = 12;
            EICount = 19;
            ENCount = 1;
            FICount = 12;
            FMCount = 0;
            HRCount = 1;
            IMCount = 11;
            KMCount = 0;
            MPCount = 0;
            MKCount = 2;
            NFCount = 0;
            OPCount = 13;
            PICount = 0;
            PMCount = 0;
            PDCount = 9;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 0;
            SECount = 0;
            SMCount = 1;
            createTestList();
        }
    }

    public static void ENTTest()
    {
        questionReset();
        if(blueprint.equals("District"))
        {
            BLCount = 4;
            CMCount = 3;
            COCount = 1;
            CRCount = 1;
            ECCount = 3;
            EICount = 6;
            ENCount = 14;
            FICount = 10;
            FMCount = 0;
            HRCount = 5;
            IMCount = 4;
            KMCount = 0;
            MPCount = 5;
            MKCount = 1;
            NFCount = 2;
            OPCount = 13;
            PICount = 2;
            PMCount = 4;
            PDCount = 5;
            PRCount = 6;
            PJCount = 0;
            QMCount = 1;
            RMCount = 2;
            SECount = 1;
            SMCount = 7;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 4;
            CMCount = 3;
            COCount = 0;
            CRCount = 1;
            ECCount = 3;
            EICount = 6;
            ENCount = 13;
            FICount = 9;
            FMCount = 0;
            HRCount = 4;
            IMCount = 3;
            KMCount = 0;
            MPCount = 6;
            MKCount = 1;
            NFCount = 3;
            OPCount = 13;
            PICount = 3;
            PMCount = 4;
            PDCount = 5;
            PRCount = 7;
            PJCount = 0;
            QMCount = 1;
            RMCount = 3;
            SECount = 1;
            SMCount = 7;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 3;
            CMCount = 3;
            COCount = 1;
            CRCount = 1;
            ECCount = 2;
            EICount = 4;
            ENCount = 14;
            FICount = 11;
            FMCount = 0;
            HRCount = 4;
            IMCount = 2;
            KMCount = 0;
            MPCount = 6;
            MKCount = 1;
            NFCount = 2;
            OPCount = 14;
            PICount = 2;
            PMCount = 4;
            PDCount = 4;
            PRCount = 8;
            PJCount = 0;
            QMCount = 1;
            RMCount = 4;
            SECount = 1;
            SMCount = 8;
            createTestList();

        }
    }

    public static void FINTest()
    {
        questionReset();
        if(blueprint.equals("District"))
        {
            BLCount = 7;
            CMCount = 0;
            COCount = 5;
            CRCount = 4;
            ECCount = 6;
            EICount = 9;
            ENCount = 1;
            FICount = 24;
            FMCount = 9;
            HRCount = 1;
            IMCount = 6;
            KMCount = 0;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 6;
            PICount = 0;
            PMCount = 0;
            PDCount = 14;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 6;
            SECount = 0;
            SMCount = 1;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 8;
            CMCount = 0;
            COCount = 4;
            CRCount = 5;
            ECCount = 5;
            EICount = 8;
            ENCount = 0;
            FICount = 27;
            FMCount = 10;
            HRCount = 0;
            IMCount = 6;
            KMCount = 0;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 5;
            PICount = 0;
            PMCount = 0;
            PDCount = 14;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 7;
            SECount = 0;
            SMCount = 0;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 8;
            CMCount = 0;
            COCount = 3;
            CRCount = 4;
            ECCount = 4;
            EICount = 6;
            ENCount = 0;
            FICount = 30;
            FMCount = 12;
            HRCount = 0;
            IMCount = 6;
            KMCount = 0;
            MPCount = 0;
            MKCount = 1;
            NFCount = 0;
            OPCount = 4;
            PICount = 0;
            PMCount = 0;
            PDCount = 15;
            PRCount = 0;
            PJCount = 0;
            QMCount = 0;
            RMCount = 8;
            SECount = 0;
            SMCount = 0;
            createTestList();

        }
    }

    public static void HTTest()
    {
        questionReset();
        if(blueprint.equals("District"))
        {
            BLCount = 3;
            CMCount = 0;
            COCount = 5;
            CRCount = 8;
            ECCount = 7;
            EICount = 9;
            ENCount = 1;
            FICount = 8;
            FMCount = 0;
            HRCount = 2;
            IMCount = 14;
            KMCount = 0;
            MPCount = 1;
            MKCount = 1;
            NFCount = 0;
            OPCount = 13;
            PICount = 1;
            PMCount = 6;
            PDCount = 7;
            PRCount = 2;
            PJCount = 0;
            QMCount = 1;
            RMCount = 1;
            SECount = 7;
            SMCount = 3;
            createTestList();

        }
        else if(blueprint.equals("State"))
        {
            BLCount = 3;
            CMCount = 0;
            COCount = 4;
            CRCount = 9;
            ECCount = 6;
            EICount = 8;
            ENCount = 0;
            FICount = 7;
            FMCount = 0;
            HRCount = 1;
            IMCount = 15;
            KMCount = 1;
            MPCount = 1;
            MKCount = 2;
            NFCount = 0;
            OPCount = 13;
            PICount = 1;
            PMCount = 7;
            PDCount = 7;
            PRCount = 3;
            PJCount = 0;
            QMCount = 1;
            RMCount = 1;
            SECount = 8;
            SMCount = 2;
            createTestList();

        }
        else if(blueprint.equals("ICDC"))
        {
            BLCount = 2;
            CMCount = 0;
            COCount = 3;
            CRCount = 10;
            ECCount = 5;
            EICount = 6;
            ENCount = 0;
            FICount = 7;
            FMCount = 0;
            HRCount = 1;
            IMCount = 16;
            KMCount = 1;
            MPCount = 2;
            MKCount = 1;
            NFCount = 0;
            OPCount = 13;
            PICount = 1;
            PMCount = 9;
            PDCount = 6;
            PRCount = 3;
            PJCount = 0;
            QMCount = 1;
            RMCount = 2;
            SECount = 9;
            SMCount = 2;
            createTestList();

        }
    }

    public static void createTestList()
    {
        int[] newList = {BLCount, CMCount, COCount, CRCount, ECCount, EICount, ENCount, FICount, FMCount, HRCount, IMCount, KMCount, MPCount, MKCount, NFCount, OPCount, PICount, PMCount, PDCount, PRCount, PJCount, QMCount, RMCount, SECount, SMCount};
        ArrayList<question> usedList = new ArrayList<question>();
        int added = 0;
        Random random = new Random();


        if(useDistrict && useState && useICDC)
        {

            for (int i=0; i<25; i++)
            {
                //make sure this works
                int cat=0;
                if(testLength == 100)
                {
                    cat = newList[i];
                }
                else if(testLength == 50)
                {
                    cat = newList[i]/2;
                }

                int[] numList = threeLevelCounter(cat);

                if(FirstScreenController.districtNotEmpty(i) && FirstScreenController.stateNotEmpty(i) && FirstScreenController.ICDCNotEmpty(i))
                {
                    for (int j=0; j<numList[0]; j++)
                    {
                        if (!usedList.contains(FirstScreenController.districtGetter(i)))
                        {
                            currentTest.add(FirstScreenController.districtGetter(i));
                            added++;
                            usedList.add(FirstScreenController.districtGetter(i));
                        }

                    }
                    for (int j=0; j<numList[1]; j++)
                    {
                        if (!usedList.contains(FirstScreenController.stateGetter(i)))
                        {
                            currentTest.add(FirstScreenController.stateGetter(i));
                            added++;
                            usedList.add(FirstScreenController.stateGetter(i));
                        }
                    }
                    for (int j=0; j<numList[2]; j++)
                    {
                        if (!usedList.contains(FirstScreenController.ICDCGetter(i)))
                        {
                            currentTest.add(FirstScreenController.ICDCGetter(i));
                            added++;
                            usedList.add(FirstScreenController.ICDCGetter(i));
                        }
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                if(FirstScreenController.districtNotEmpty(num))
                {
                    currentTest.add(FirstScreenController.ICDCGetter(num));
                }
            }
        }

        else if (useDistrict && useState)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength == 100)
                {
                    cat = newList[i];
                }
                else if(testLength == 50)
                {
                    cat = newList[i]/2;
                }

                int[] numList = twoLevelCounter(cat);

                for (int j=0; j<numList[0]; j++)
                {
                    if (!usedList.contains(FirstScreenController.districtGetter(i)))
                    {
                        currentTest.add(FirstScreenController.districtGetter(i));
                        added++;
                        usedList.add(FirstScreenController.districtGetter(i));
                    }
                }
                for (int j=0; j<numList[1]; j++)
                {
                    if (!usedList.contains(FirstScreenController.stateGetter(i)))
                    {
                        currentTest.add(FirstScreenController.stateGetter(i));
                        added++;
                        usedList.add(FirstScreenController.stateGetter(i));
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                currentTest.add(FirstScreenController.stateGetter(num));
            }
        }

        else if (useDistrict && useICDC)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength == 100)
                {
                    cat = newList[i];
                }
                else if(testLength == 50)
                {
                    cat = newList[i]/2;
                }

                int[] numList = twoLevelCounter(cat);

                for (int j=0; j<numList[0]; j++)
                {
                    if (!usedList.contains(FirstScreenController.districtGetter(i)))
                    {
                        currentTest.add(FirstScreenController.districtGetter(i));
                        added++;
                        usedList.add(FirstScreenController.districtGetter(i));
                    }
                }
                for (int j=0; j<numList[1]; j++)
                {
                    if (!usedList.contains(FirstScreenController.ICDCGetter(i)))
                    {
                        currentTest.add(FirstScreenController.ICDCGetter(i));
                        added++;
                        usedList.add(FirstScreenController.ICDCGetter(i));
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                currentTest.add(FirstScreenController.ICDCGetter(num));
            }
        }

        else if (useState && useICDC)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength == 100)
                {
                    cat = newList[i];
                }
                else if(testLength == 50)
                {
                    cat = newList[i]/2;
                }

                int[] numList = twoLevelCounter(cat);

                for (int j=0; j<numList[0]; j++)
                {
                    if (!usedList.contains(FirstScreenController.stateGetter(i)))
                    {
                        currentTest.add(FirstScreenController.stateGetter(i));
                        added++;
                        usedList.add(FirstScreenController.stateGetter(i));
                    }
                }
                for (int j=0; j<numList[1]; j++)
                {
                    if (!usedList.contains(FirstScreenController.ICDCGetter(i)))
                    {
                        currentTest.add(FirstScreenController.ICDCGetter(i));
                        added++;
                        usedList.add(FirstScreenController.ICDCGetter(i));
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                currentTest.add(FirstScreenController.ICDCGetter(num));
            }
        }

//////////////////////////////////////////////////////////////////////////////////////

        else if (useDistrict)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength==100)
                {
                    cat = newList[i];
                }
                else if(testLength==50)
                {
                    cat = newList[i]/2;
                }

                if(FirstScreenController.districtNotEmpty(i))
                {
                    for (int j=0; j<cat; j++) //make sure it's less than cat (it should be)
                    {
                        question q = FirstScreenController.districtGetter(i);
                        boolean carryOn = true;
                        for (question x : usedList)
                        {
                            if (q.getTag().equals(x.getTag()))
                            {
                                carryOn=false;
                            }
                        }
                        if (carryOn)
                        {
                            currentTest.add(q);
                            added++;
                            usedList.add(q);
                        }
                    }
                }
            }
            while (added < testLength-1)  //CHANGE THIS BACK BY REMOVING THE -1 ONCE MORE QUESTIONS ARE ADDED
            {
                int num = random.nextInt(25);
                if(FirstScreenController.districtNotEmpty(num))
                {
                    question q = FirstScreenController.districtGetter(num);
                    boolean carryOn = true;
                    for (question x : usedList)
                    {
                        if (q.getTag().equals(x.getTag()))
                        {
                            carryOn=false;
                        }
                    }
                    if (carryOn)
                    {
                        currentTest.add(q);
                        added++;
                        usedList.add(q);
                    }
                    carryOn=true;
                }
            }
        }

        else if (useState)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength==100)
                {
                    cat = newList[i];
                }
                else if(testLength==50)
                {
                    cat = newList[i]/2;
                }

                for (int j=0; j<cat; j++)
                {
                    if (!usedList.contains(FirstScreenController.stateGetter(i)))
                    {
                        currentTest.add(FirstScreenController.stateGetter(i));
                        added++;
                        usedList.add(FirstScreenController.stateGetter(i));
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                currentTest.add(FirstScreenController.stateGetter(num));
            }
        }

        else if (useICDC)
        {
            for (int i=0; i<25; i++)
            {
                int cat=0;
                if(testLength==100)
                {
                    cat = newList[i];
                }
                else if(testLength==50)
                {
                    cat = newList[i]/2;
                }

                for (int j=0; j<cat; j++)
                {
                    if (!usedList.contains(FirstScreenController.ICDCGetter(i)))
                    {
                        currentTest.add(FirstScreenController.ICDCGetter(i));
                        added++;
                        usedList.add(FirstScreenController.ICDCGetter(i));
                    }
                }
            }
            while (added < testLength)
            {
                int num = random.nextInt(25);
                currentTest.add(FirstScreenController.ICDCGetter(num));
            }
        }
    }

    //splits randomly between state, district, icdc for a chosen category
    public static int[] threeLevelCounter(int totalQuestions)
    {
        Random random = new Random();
        int count1 = random.nextInt(totalQuestions-2)+1;
        int count2 = random.nextInt(totalQuestions-count1-1)+1;
        int count3 = totalQuestions - count2 - count1;
        int[] resultList = {count1,count2,count3};
        return resultList;
    }


    //splits randomly between any two choices of level
    public static int[] twoLevelCounter(int totalQuestions)
    {
        Random random = new Random();
        int count1 = random.nextInt(totalQuestions-1)+1;
        int count2 = totalQuestions - count1;
        int[] resultList = {count1,count2};
        return resultList;
    }


    //takes everything from the instance variable list into another one so it can be returned and transferred to the testing/home page!
    public static ArrayList<question> returnTest()
    {
        ArrayList<question> finalQuestions = new ArrayList<question>();
        finalQuestions.addAll(currentTest);
        return finalQuestions;
    }

    public void setTestLength50(ActionEvent event)
    {
        testLength = 50;
    }

    public void setTestLength100(ActionEvent event)
    {
        testLength = 100;
    }

    public void setBlueprintDistrict(ActionEvent event)
    {
        blueprint = "District";
    }

    public void setBlueprintState(ActionEvent event)
    {
        blueprint = "State";
    }

    public void setBlueprintICDC(ActionEvent event)
    {
        blueprint = "ICDC";
    }


    public void loadTest(ActionEvent event) throws IOException {

        if (cb1.isSelected())
        {
            useDistrict = true;
        }

        if (cb2.isSelected())
        {
            useState = true;
        }

        if (cb3.isSelected())
        {
            useICDC = true;
        }

        currentTest.removeAll(currentTest);
        Toggle selected = toggletest.getSelectedToggle();
        if(selected != null)
        {
            RadioButton choice = (RadioButton) selected;
            String stringVal = choice.getText();
            switch (stringVal) {
                case "BAC" -> BACTest();
                case "BMA" -> BMATest();
                case "FIN" -> FINTest();
                case "MKT" -> MKTTest();
                case "ENT" -> ENTTest();
                case "HT" -> HTTest();
            }
        }
        SceneController controller = new SceneController();
        controller.switchTesting(event);
    }

    SceneController controller = new SceneController();
    public void homeSwitch(ActionEvent event) throws IOException
    {
        controller.switchFirstScreen(event);
    }


}

//                BL 0
//                CM 1
//                CO 2
//                CR 3
//                EC 4
//                EI 5
//                EN 6
//                FI 7
//                FM 8
//                HR 9
//                IM 10
//                KM 11
//                MP 12
//                MK 13
//                NF 14
//                OP 15
//                PI 16
//                PM 17
//                PD 18
//                PR 19
//                PJ 20
//                QM 21
//                RM 22
//                SE 23
//                SM 24


