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

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    
        //Left rotation  
        List<Integer> L1 = new ArrayList<Integer>();
        List<Integer> L2 = new ArrayList<Integer>();
        
        int rot = d%(a.size());
        for(int i = 0;i < rot;i++){
            L1.add(a.get(i));
        }
        for(int i = rot;i < a.size();i++){
            L2.add(a.get(i));
        }
        
        List<Integer> L3 = new ArrayList<Integer>();
        L3.addAll(L2);
        L3.addAll(L1);
        return L3;
        
    // I have tried using inplace method but due to 2 for loops time limit excids :(
       /* int rot = d % (a.size()); 
        for(int i = 0;i < rot;i++){
            int temp = a.get(0);
            for(int j = 0;j < a.size()-1;j++){
               a.set(j,a.get(j+1)); 
            }
            a.set(a.size()-1,temp); 
        }
        return a;
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
