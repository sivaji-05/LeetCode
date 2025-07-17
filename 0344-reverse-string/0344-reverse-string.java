class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int low =0;
        int high=n-1;
        while(high > low){
           char temp = s[high];
            s[high]=s[low];
            s[low]=temp;
            high--;
            low++;
        }
        
    }
}