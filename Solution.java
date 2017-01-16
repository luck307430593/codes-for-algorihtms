package cs61b;
import java.io.*;
import java.util.*;
public class Solution {
	    public static List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> result = new ArrayList<List<String>>();
	        if (strs == null) return result;

	        // one key to multiple value multiMap
	        Map<String, ArrayList<String>> multiMap = new HashMap<String, ArrayList<String>>();
	        for (String str : strs) {
	            char[] strChar = str.toCharArray();
	            Arrays.sort(strChar);
	            String strSorted = String.valueOf(strChar);
	            if (multiMap.containsKey(strSorted)) {
	                ArrayList<String> aList = multiMap.get(strSorted);
	                aList.add(str);
	                multiMap.put(strSorted, aList);
	            } else {
	                ArrayList<String> aList = new ArrayList<String>();
	                aList.add(str);
	                multiMap.put(strSorted, aList);
	            }
	        }

	        // add List group to result
	        Set<String> keySet = multiMap.keySet();
	        for (String key : keySet) {
	            ArrayList<String> aList = multiMap.get(key);
	            Collections.sort(aList);
	            result.add(aList);
	        }

	        return result;
	    }
	public static void main(String[] args) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.print(Solution.groupAnagrams(strs));
		

	}

}
