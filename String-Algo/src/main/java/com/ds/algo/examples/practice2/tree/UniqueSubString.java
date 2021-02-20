package com.ds.algo.examples.practice2.tree;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubString {

    public static int lengthOfUniqueSubString(String data) {
        if(data == null || data.length() == 0) {
            return 0;
        }

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (i < data.length()) {
            char ch = data.charAt(i);

            while (set.contains(ch)){
                set.remove(data.charAt(j));
                j++;
            }

            set.add(ch);
            max = Math.max(max, i - j+1);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int pwwtrsken = UniqueSubString.lengthOfUniqueSubString("PWWTRRSKENN");
        System.out.println(pwwtrsken);
    }
}
