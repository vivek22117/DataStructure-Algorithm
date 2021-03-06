package test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseLogs {

    private static String logPath = "C:\\projects\\Development\\DataStructure-Algorithm\\data";

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(readAndParse(logPath));
    }

    private static String readAndParse(String logPath) throws URISyntaxException, IOException {
        Path path = Paths.get(logPath, "apache_log");

        Stream<String> lines = Files.lines(path);
        Map<String, Long> collect = lines.map(line -> line.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = -1L;
        String ip = null;
        for(Map.Entry<String, Long> entry :  collect.entrySet()) {

            if(entry.getValue() > max) {
                ip = entry.getKey();
                max = entry.getValue();
            }
        }

        lines.close();
        return ip;
    }
}
