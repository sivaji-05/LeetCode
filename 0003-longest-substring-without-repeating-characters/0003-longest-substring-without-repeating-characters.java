class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*int n=s.length();
        int max=0;
        int cnt=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                cnt++;
            }
            else{
                cnt=0;
            }
            if(cnt>max){
                max=cnt;
            }

        }
        return max;*/

        int n=s.length();
        Set <Character> set= new HashSet<>();
        int maxlen=0;
        int left=0;
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen=Math.max(maxlen, (right-left)+1);
        }
        return maxlen;

    }
}