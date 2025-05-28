class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        List<List<Integer>> matrix = new ArrayList<>();
        while(map.size() > 0){
            List<Integer> row = new ArrayList<>();
            List<Integer> toRemove = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int element = entry.getKey();
                row.add(element);
                map.put(element, map.get(element) - 1);
                if(map.get(element) == 0){
                    toRemove.add(element); 
                }
            }
            for(int key : toRemove){
                map.remove(key); // during running of loop update nahi kr skte islye list se remove kie sb 
            }
            matrix.add(row);
        }
        return matrix;
    }
}
