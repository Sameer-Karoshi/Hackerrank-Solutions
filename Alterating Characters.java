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

    public static int alternatingCharacters(String s) {
    
        int no_of_deletions = 0;
        
        for(int i = 0;i < s.length();i++){
            
            int j;
            for(j = i + 1;j < s.length();j++){
                char ch_1 = s.charAt(i);
                char ch_2 = s.charAt(j);
                   
                if(ch_2 == ch_1){
                    no_of_deletions++;
                }
                else{
                    i = j;
                }
            }
            if((i == 0 && no_of_deletions == s.length() - 1) || j == s.length()){
                break;
            }
        }
        
        return no_of_deletions;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
