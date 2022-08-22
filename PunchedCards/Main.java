import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<Integer, String> sortedMap() {
        Scanner myObj = new Scanner(System.in);
        int T = myObj.nextInt();
        myObj.nextLine();
        Map<Integer, String> casesMap = new HashMap<>();

        int x = 1;
        while (x <= T) {
            String pair = myObj.nextLine();
            casesMap.put(x, pair);
            x ++;
        }

        Map<Integer, String> sortedMap = casesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        return sortedMap;
    }

    public static String[][] createMatrix(int R, int C) {
        String[][] arr = new String[(2 * R) + 1][(2 * C) + 1];

        for(int i = 0; i < (2 * R) + 1 ; i ++) {
            for(int j = 0; j < (2 * C) + 1 ; j ++) {
                if((i == 0 && j == 0)  || (i == 0 && j == 1) || (i == 1 && j == 0) || (i == 1 & j == 1)) {
                    arr[i][j] = ".";
                } else {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            arr[i][j] = "+";
                        } else {
                            arr[i][j] = "-";
                        }
                    } else if (i % 2 != 0) {
                        if (j % 2 == 0) {
                            arr[i][j] = "|";
                        } else {
                            arr[i][j] = ".";
                        }
                    }
                }
            }
        }
        return arr;
    }


    public static void main (String args[]) {

        for(Map.Entry map : sortedMap().entrySet()) {

            String[] cases = map.getValue().toString().split(" ");
            String[][] matrix = createMatrix(Integer.valueOf(cases[0]), Integer.valueOf(cases[1]));

            String createdCase = "case #" + map.getKey() + "\nR = " + Integer.valueOf(cases[0]) + ", C = " + Integer.valueOf(cases[1]);
            for(int i = 0; i < matrix.length; i ++) {
                String row = "";
                for(int j = 0; j < matrix[i].length; j++) {
                    row += matrix[i][j];
                }
                createdCase += ":\n" + row;
            }
            System.out.println(createdCase);

        }

    }
}
