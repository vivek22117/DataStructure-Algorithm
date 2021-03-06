package test;

import java.util.Arrays;

public class ParseString {

    private static String input = "40|20|18|21|4|38|45|16";

    public static void main(String[] args) {
        String[] sort = sort(input);
    }

    private static String[] sort(String input) {
        String[] split = input.split("\\|");

        //for i in split:
        //

        for(int i = 0; i < split.length; i++) {
            for(int j = i + 1; j < split.length; j++) {
                if(Integer.valueOf(split[i]) > Integer.valueOf(split[j])) {
                    swap(split, i, j);
                }
            }
        }

        return split;
    }

    private static void swap(String[] split, int i, int j) {
        String value = split[i];
        split[i] = split[j];
        split[j] = value;
    }
}
