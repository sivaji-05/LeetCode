class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map= new HashSet<>();
        for(int n:nums){
          if(map.contains(n)){
            return true;
            }
            map.add(n);
        }
        return false;

    }
}