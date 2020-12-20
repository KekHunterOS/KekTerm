package com.team420.kekterm;

// 3 types of prompt: good old android, su and kali

// WHICH SU

// todo: Find a good way to get the paths

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ShellType {
    static final String ANDROID_SHELL =  whichCMD("sh") + " -";
    static final String ANDROID_SU_SHELL = whichCMD("su") + " -mm";
    static final String KALI_SHELL = whichCMD("su") + " -mm -c bootkali";
    static final String KALI_LOGIN_SHELL = whichCMD("su") + " -mm -c bootkali_login";

    private static String whichCMD(String theCmd){
        String output = null;
        try {
            Process p = Runtime.getRuntime().exec("which " + theCmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            output = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
