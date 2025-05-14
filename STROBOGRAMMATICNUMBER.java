import java.util.* ;
import java.io.*; 
public class Solution {
   
   	public static boolean isStrobogrammatic(String n){
    	// Write your code here.
        int l=0;
        int r=n.length()-1;
        while(l<=r){
            char left=n.charAt(l);
            char right=n.charAt(r);
            if(!((left=='1' && right=='1') || (left=='6' && right=='9') || (left=='8' && right=='8') || (left=='9' && right=='6')||(left=='0' && right=='0'))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
