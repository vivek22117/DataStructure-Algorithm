package test;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseLogsFetchTopK {

    private static String logPath = "C:\\projects\\Development\\DataStructure-Algorithm\\data";
    private static String apacheLogPath = "C:\\projects\\Development\\DataStructure-Algorithm\\data\\apache_log";

    public static void main(String[] args) throws IOException {
        ParseLogsFetchTopK parser = new ParseLogsFetchTopK();
//        parser.readAndParseLogs(logPath);

        parser.processLogFile(apacheLogPath, 10);
        parser.processApacheLogs(apacheLogPath, 10);
        parser.parseApacheLogs(apacheLogPath, 2);
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
        sortedList.sort(Comparator.comparingLong(new ToLongFunction<Map.Entry<String, Long>>() {
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

        lines.close();
    }



    public void processLogFile(String path, int k) throws IOException {

        Path logFilePath = Paths.get(path);

        Stream<String> logs = Files.lines(logFilePath);

        Map<String, Long> mapOfIpAndFrequency = logs.map(line -> {
            return line.split(" ")[0];
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> sortedMap = mapOfIpAndFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, new BinaryOperator<Long>() {
                    @Override
                    public Long apply(Long e1, Long e2) {
                        return e1;
                    }
                }, new Supplier<Map<String, Long>>() {
                    @Override
                    public Map<String, Long> get() {
                        return new LinkedHashMap<>();
                    }
                }));

        LinkedHashMap<String, Long> sortedMap2 = mapOfIpAndFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        System.out.println(sortedMap2);

        logs.close();
//        new ArrayList<>(mapOfIpAndFrequency.entrySet()).sort(Map.Entry.comparingByValue().reversed());
    }

    public void processApacheLogs(String path, Integer topK) throws IOException {
        Path logPath = Paths.get(path);

        Stream<String> lines = Files.lines(logPath);

       Map<String, Long> mapOfFrequency = lines.map(line -> {
            return line.split(" ")[0];
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       List<Map.Entry<String, Long>> listOfMapSet = new ArrayList<>(mapOfFrequency.entrySet());

       Map<String, Long> sortedMap = listOfMapSet.stream().limit(topK).sorted(Map.Entry.<String, Long>comparingByValue().reversed())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

       lines.close();
       System.out.println(sortedMap);
    }

    public void parseApacheLogs(String filePath, Integer topK) throws IOException {
        Path path = Paths.get(filePath);

        Stream<String> lines = Files.lines(path);

        Map<String, Long> mapOfFrequency = lines.map(line -> {
            return line.split(" ")[0];
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Frequency of IPs: " + mapOfFrequency);

        List<Map.Entry<String, Long>> listOfFrequency = new ArrayList<>(mapOfFrequency.entrySet());

        Map<String, Long> sortedMap = listOfFrequency.stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int size = 0;
        for(Map.Entry<String, Long> value : sortedMap.entrySet()) {
            if(size < topK) {
                System.out.println(value.getKey() + " ==> " + value.getValue());
                size++;
            }

        }
        lines.close();;

    }
}
