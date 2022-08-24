package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimeNumber {

    private static int inputNumber = 17;

    public static void main(String[] args) {
        Date date1 = null;
    }

    private static boolean isPrimeNumber(int inputNumber) {
        if(inputNumber <= 1) {
            return false;
        }

        for(int i = 2; i <= inputNumber; i++){
            if(inputNumber % i == 0) {
                return false;
            }
        }

        return true;

    }
}
