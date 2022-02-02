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

    public static int makeAnagram(String a, String b) {
        
        int Array_a[] = new int[26];
        int Array_b[] = new int[26];
        
        //Frequency count of each letter in  string a
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < a.length() ;j++){
                int ch = a.charAt(j);
                if(ch == i + 97){
                    Array_a[i] = Array_a[i] + 1; 
                }       
            }   
        }
        
        //Frequency count of each letter in  string b
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < b.length() ;j++){
                int ch = b.charAt(j);
                if(ch == i + 97){
                    Array_b[i] = Array_b[i] + 1; 
                }        
            }    
        }
        
       int no_of_deletions = 0;
       for(int i = 0; i < 26;i++){
           if(Array_a[i] < Array_b[i]){
               no_of_deletions = no_of_deletions + (Array_b[i] - Array_a[i]);
           }
           else if(Array_a[i] > Array_b[i]){
               no_of_deletions = no_of_deletions + (Array_a[i] - Array_b[i]);
           }
       }
        return no_of_deletions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
