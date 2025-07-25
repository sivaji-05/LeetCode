class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char [] si=s.toCharArray();
        char [] ti=t.toCharArray();
        Arrays.sort(si);
        Arrays.sort(ti);
        return Arrays.equals(si,ti);

        
    }
}