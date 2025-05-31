import java.util.* ;
import java.io.*; 
public class Solution {
    public static int countColumns(String[] strings){
        // Write your code here.
        char[][] arr=new char[strings.length][strings[0].length()];
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=strings[i].charAt(j);
            }
        }
        int count=0;
        for(int j=0;j<arr[0].length;j++){
            for(int i=0;i<n-1;i++){
                if(arr[i+1][j]<arr[i][j]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
