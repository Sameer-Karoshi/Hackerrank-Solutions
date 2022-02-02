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

    public static int countingValleys(int steps, String path) {
    // Write your code here
    //if Up then +1 and if down then -1
    
    int result = 0;
    int valley = 0;
    boolean flag = false;
    for(int i = 0;i < steps;i++){
        char ch = path.charAt(i);
        if(ch == 'U'){
            result = result + 1;
            if(flag && (result == 0)){
                valley++;
            }          
        }
        else if(ch == 'D'){
            if(result == 0){
                flag = true;
            }
            result = result - 1;        
        }
        
    }
    
    return valley;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
