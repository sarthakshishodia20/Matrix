import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<ArrayList<Integer>> ninjaCity(ArrayList<ArrayList<Integer>> mat) {

		// Write your code here
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		for(ArrayList<Integer> a:mat){
			Collections.reverse(a);
			ans.add(a);
		}
		return ans;
	}
}
