package com.ds.algo.examples.practice2.tree;

public class ReverseVowels {

    private static String data = "ALPPKIEieoslndoR";


    public String reverseData(String data) {
        char[] dataList = data.toCharArray();

        int leftIndx = 0;
        int rightIndx = dataList.length - 1;
        while (leftIndx < rightIndx) {

            boolean isLeftVowel = isVowel(dataList[leftIndx]);
            boolean isRightVowel = isVowel(dataList[rightIndx]);

            if(isLeftVowel && isRightVowel){
                swap(dataList, leftIndx, rightIndx);
                leftIndx++;
                rightIndx--;
            }
            if(!isLeftVowel) {
                leftIndx++;
            }
            if(!isRightVowel) {
                rightIndx--;
            }
        }
        return new String(dataList);
    }

    private void swap(char[] dataList, int leftIndx, int rightIndx) {
        char temp = dataList[leftIndx];
        dataList[leftIndx] = dataList[rightIndx];
        dataList[rightIndx] = temp;
    }

    private boolean isVowel(char ch) {
        char chLower = Character.toLowerCase(ch);
        return chLower == 'a' || chLower == 'e' || chLower == 'i' || chLower == 'o' || chLower == 'u';
    }
}
