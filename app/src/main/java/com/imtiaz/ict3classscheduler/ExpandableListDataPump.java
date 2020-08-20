package com.imtiaz.ict3classscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> SMSR = new ArrayList<String>();
        SMSR.add("01769021808");
        SMSR.add("salim.reza@bup.edu.bd");

        List<String> JR = new ArrayList<String>();
        JR.add("01911701485");
        JR.add("mjrashid@du.ac.bd");

        List<String> SK = new ArrayList<String>();
        SK.add("01711932323");
        SK.add("mskaiser@juniv.edu");

        List<String> HM = new ArrayList<String>();
        HM.add("01844056187");
        HM.add("hasan@iut-dhaka.edu");


        List<String> ZT = new ArrayList<String>();
        ZT.add("01769021809");
        ZT.add("zarin@bup.edu.bd");


        List<String> EK = new ArrayList<String>();
        EK.add("01769021830");
//        EK.add("Email");


        List<String> FR = new ArrayList<String>();
        FR.add("01769021816");
//        FR.add("Email");


        expandableListDetail.put("SM Salim Reza (BUP)-ICT Project Management", SMSR);
        expandableListDetail.put("Dr. Md. Junayebur Rashid (DU) - Multimedia Comm.", JR);
        expandableListDetail.put("Dr. M. Shamim Kaiser (JU)-Info Theory and Coding", SK);
        expandableListDetail.put("Hasan Mahmud (IUT)-Web Engineering", HM);
        expandableListDetail.put("Zarin Tasnim - Batch Cordinator", ZT);
        expandableListDetail.put("Md. Ehsanul Kabir - Section Officer", EK);
        expandableListDetail.put("Md. Faizur Rahman - Section Officer", FR);
        return expandableListDetail;
    }
}