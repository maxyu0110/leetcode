public class Solution {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(start < end) {
            if(!isVowel(arr[start])){
                start++;
            }
            if(!isVowel(arr[end])){
                end--;
            }
            if(isVowel(arr[start]) && isVowel(arr[end])){
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}