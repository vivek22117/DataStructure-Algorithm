package com.ds.algo.examples.practice2.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class ReorderLogs {

    private static String[] logsData = {"log1 acd deeee add", "log2 3 4 5 6", "log7  addi ve ea  vdda", "log5 aedd xsda  dad",
                                        "log3 54 3434666  654", "log8  vivek ae aowo"};


    public static String[] reorderLogFiles(String[] logs) {
        if(logs.length == 1) {
            return logs;
        }

        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                int index1 = str1.indexOf(" ");
                String log1Id = str1.substring(0, index1);
                String log1Msg = str1.substring(index1 + 1);
            }
        });

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                int index1 = log1.indexOf(" ");
                String log1Id = log1.substring(0, index1);
                String log1Msg = log1.substring(index1 + 1);

                int index2 = log2.indexOf(" ");
                String log2Id = log2.substring(0, index2);
                String log2Msg = log2.substring(index2 + 1);

                boolean isLog1Digit = Character.isDigit(log1Msg.charAt(0));
                boolean isLog2Digit = Character.isDigit(log2Msg.charAt(0));

                if(!isLog1Digit && !isLog2Digit) {
                    int value = log1Msg.compareTo(log2Msg);
                    if(value == 0) {
                        return log1Id.compareTo(log2Id);
                    }
                    return value;
                }
                return isLog1Digit ? (isLog2Digit ? 0 : 1) : -1;
            }
        });

        return logs;
    }


    public static void main(String[] args) {
        String[] strings = reorderLogFiles(logsData);
        System.out.println(Arrays.toString(strings));
    }
}
