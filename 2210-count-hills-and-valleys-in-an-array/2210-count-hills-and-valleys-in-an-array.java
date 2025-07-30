class Solution {
    public int countHillValley(int[] nums) {
      /*  int cnt=0;
        int i=0;
        int n=nums.length;
        for(int j=1;j<n-1;j++){
            if(nums[i]<nums[j] && nums[j]>nums[j+1]){
                cnt++;
                i++;
            }
            else if(nums[i]>nums[j] && nums[j]<nums[j+1]){
                cnt++;
                i++;
            }
        }
        return cnt;*/
        List <Integer> List= new ArrayList<>();
        List.add(nums[0]);
        int n=nums.length;
        for(int i=1;i<n;i++){
             if(nums[i-1]!=nums[i]){
             List.add(nums[i]);
            }
        }
        int cnt=0;
        for(int i=1;i<List.size()-1;i++){
            int prev=List.get(i-1);
            int current=List.get(i);
            int nxt=List.get(i+1);
            if(prev<current && current>nxt || prev>current && nxt>current ){
                cnt++;
            }
        }
        return cnt;
        
    }
}