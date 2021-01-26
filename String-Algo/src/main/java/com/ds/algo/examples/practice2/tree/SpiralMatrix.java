package com.ds.algo.examples.practice2.tree;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static List<Integer[]> inputData = new ArrayList<>();

    private static List<Integer> spiralOrder(List<Integer[]> inputData) {
        List<Integer> nums = new ArrayList<>();
        if(inputData == null || inputData.size() == 0) {
            return nums;
        }

        int top = 0;
        int bottom = inputData.size() - 1;
        int left = 0;
        int right = inputData.get(0).length - 1;

        int size = inputData.size() * inputData.get(0).length;
        while (nums.size() < size) {
            for(int i = left; i <= right && nums.size() < size; i++) {
                nums.add(inputData.get(top)[i]);
            }
            top++;
            for(int i = top; i <= bottom && nums.size() < size; i++) {
                nums.add(inputData.get(i)[right]);
            }
            right--;
            for(int i = right; i >= left && nums.size() < size; i--) {
                nums.add(inputData.get(bottom)[i]);
            }
            bottom--;
            for(int i = bottom; i >= top && nums.size() < size; i--) {
                nums.add(inputData.get(i)[left]);
            }
            left++;
        }
        return nums;
    }


    public static void main(String[] args) {
        Integer[] i1 = {1,2,3, 4};
        Integer[] i2 = {7,9,5, 8};
        Integer[] i3 = {6,0,4, 2};
        List<Integer[]> data = new ArrayList<>();

        data.add(i1);
        data.add(i2);
        data.add(i3);
        List<Integer> integers = spiralOrder(data);
        System.out.println(integers);

    }
}
