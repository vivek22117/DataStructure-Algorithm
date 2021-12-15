package test;

import javax.print.attribute.IntegerSyntax;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseLogs {

    private static String logPath = "C:\\projects\\Development\\DataStructure-Algorithm\\data";

    public static void main(String[] args) throws IOException, URISyntaxException {
//        System.out.println(readAndParse(logPath));

//        System.out.println(solve("59"));
//        System.out.println(solveSecond("ababa", new int[]{1,2,1,2,1,2}));
        System.out.println(breakIntoTwo(new int[]{15, 12, 14, 11, 16, 1, 11, 10, 22}));
//        System.out.println(breakIntoTwoWithMin(new int[]{15, 12, 14, 6, 13, 1, 11, 10, 22}));
    }

    private static String readAndParse(String logPath) throws URISyntaxException, IOException {
        Path path = Paths.get(logPath, "apache_log");

        Stream<String> lines = Files.lines(path);
        Map<String, Long> collect = lines.map(line -> line.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = -1L;
        String ip = null;
        for (Map.Entry<String, Long> entry : collect.entrySet()) {

            if (entry.getValue() > max) {
                ip = entry.getKey();
                max = entry.getValue();
            }
        }

        lines.close();
        return ip;
    }

    public static int solve(String S) {
        if (S.length() == 2) {
            return Integer.parseInt(S);
        }

        int max = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 1;
        int N = S.length() - 1;
        while (startIndex <= N && endIndex <= N - 1) {
            int value = Integer.parseInt(S.substring(startIndex, endIndex + 1));
            if (max < value) {
                max = value;
            }
            startIndex++;
            endIndex++;
        }

        int value = Integer.parseInt(S.substring(startIndex));
        if (max < value) {
            max = value;
        }
        return max;

    }

    public static int solveSecond(String S, int[] C) {
        int sum = 0;

        for (int i = 0; i <= S.length() - 2; i++) {
            char ch = S.charAt(i);
            char secondChar = S.charAt(i + 1);

            if (ch == secondChar) {
                sum += Math.min(C[i], C[i + 1]);
            }
        }
        return sum;

    }

    public static int breakIntoTwo(int[] A) {
        int min = Integer.MAX_VALUE;

        for (int x = 1; x <= A.length - 2; x++) {
            for (int y = x + 2; y <= A.length - 2; y++) {
                if (A[x] + A[y] < min) {
                    min = A[x] + A[y];
                }
            }
        }

        return min;

    }

    public static int breakIntoTwoWithMin(int[] A) {
        int min = Integer.MAX_VALUE;
        int indexWithMin = 0;

        for(int i = 0; i < A.length - 3; i++) {
            if(A[i] < min) {
                min = A[i];
                indexWithMin = i;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int x = indexWithMin; x <= A.length - 2; x++) {
            for (int y = x + 2; y <= A.length - 2; y++) {
                if (A[x] + A[y] < result) {
                    result = A[x] + A[y];
                }
            }
        }

        return result;

    }

}
