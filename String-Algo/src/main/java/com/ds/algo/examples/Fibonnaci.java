import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'onesGroups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY grid
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {

        Map<Integer, Integer> map = new HashMap<>();
        int row = grid.size();
        int col = grid.get(0).size();
        for(int i =0; i< row; i++) {
            for(int j = 0; j < col; j++) {
                int count = 0;
                if(grid.get(i).get(j) == 1) {
                    count += dfs(grid, i, j, count);
                    System.out.println(count);
                    map.put(count, map.getOrDefault(count, 0) + 1);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Integer value : queries){
            result.add(map.getOrDefault(value, 0));
        }
        return result;
    }

    private static int dfs(List<List<Integer>> grid, int row, int col, int count) {
        if(grid == null || grid.size() == 0) {
            return 0;
        }

        if(row < 0 || row > grid.size() - 1 ||
                col < 0 || col > grid.get(row).size() -1 || grid.get(row).get(col) != 1){
            return 0 ;
        }

        grid.get(row).set(col, -1);

        if(col > 0 && col < grid.get(row).size() -1) {
            count += dfs(grid, row, col + 1, count + 1);
            count += dfs(grid, row, col - 1, count + 1);
        }

        if(row > 0 && row < grid.size() - 1) {
            count += dfs(grid, row -1, col, count + 1);
            count += dfs(grid, row + 1, col, count + 1);
        }


        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        IntStream.range(0, gridRows).forEach(i -> {
            try {
                grid.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.onesGroups(grid, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
