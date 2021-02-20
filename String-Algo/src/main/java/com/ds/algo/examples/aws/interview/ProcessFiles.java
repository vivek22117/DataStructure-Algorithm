package com.ds.algo.examples.aws.interview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessFiles {

    public static void main(String[] args) throws IOException {

        List<String> ips = new ArrayList<>();
        final File folder = new File("/root/devops/");
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

        String regex = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;

        Pattern p = Pattern.compile(regex);

        List<String> allFiles = processFile(folder);

        for (String fileName : allFiles) {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                for(String word : words) {
                    Matcher m = p.matcher(word);
                    if(m.matches()) {
                        ips.add(word);
                    }
                }

            }
            br.close();
        }

    }

    public static List<String> processFile(final File folder) {
        List<String> result = new ArrayList<>();

        for (final File val : folder.listFiles()) {
            if (val.isDirectory()) {
                processFile(val);
            }

            if (val.isFile()) {
                result.add(val.getAbsolutePath());
            }
        }
        return result;
    }
}
