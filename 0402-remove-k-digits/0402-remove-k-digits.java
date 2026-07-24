class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        char[] arr = num.toCharArray();
        for(char ch : arr){
            while(!st.isEmpty() && k>0 && (ch - '0')< (st.peek() - '0')){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}