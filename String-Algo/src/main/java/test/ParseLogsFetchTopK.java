package test;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseLogsFetchTopK {

    private static String logPath = "C:\\projects\\Development\\DataStructure-Algorithm\\data";

    public static void main(String[] args) throws IOException {
        ParseLogsFetchTopK parser = new ParseLogsFetchTopK();
        parser.readAndParseLogs(logPath);
    }

    public void readAndParseLogs(String logPath) throws IOException {
        Path path = Paths.get(logPath, "apache_log");

        Stream<String> lines = Files.lines(path);
        Map<String, Long> map = lines.map(value -> value.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sortedList = new ArrayList<>();

//        List<Map.Entry<String, Long>> sortedList = new ArrayList<>(map.entrySet());
//        sortedList.addAll(map.entrySet());

        for(Map.Entry<String, Long> val : map.entrySet()) {
            sortedList.add(val);
        }

//        AscendingOrder
        Collections.sort(sortedList, Comparator.comparingLong(new ToLongFunction<Map.Entry<String, Long>>() {
            @Override
            public long applyAsLong(Map.Entry<String, Long> entry) {
                return entry.getValue();
            }
        }));

        System.out.println(sortedList);

//        ReverserOrder
        Collections.sort(sortedList, Comparator.comparingLong(new ToLongFunction<Map.Entry<String, Long>>() {
            @Override
            public long applyAsLong(Map.Entry<String, Long> entry) {
                return entry.getValue();
            }
        }).reversed());

        System.out.println(map);
        System.out.println(sortedList);

        sortedList.stream().limit(2).forEach(value -> {
            System.out.println(value.getKey() + " " + value.getValue());
        });
    }
}
