// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1);
//         int maxLength =0;

//         for( int i =0; i<s.length(); i++){
//             char c = s.charAt(i);

//             if(c == '('){
//                 stack.push(i);
//             }else{
//                 stack.pop();
//                 if(stack.isEmpty()){
//                     stack.push(i);
//                 }else{
//                     maxLength= Math.max(maxLength, i-stack.peek());
//                 }
//             }
//         }
//         return maxLength;
//     }
// }


class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) maxLength = Math.max(maxLength, 2 * right);
            else if (right > left) left = right = 0; // reset counters
        }

        left = right = 0;
        // Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) maxLength = Math.max(maxLength, 2 * left);
            else if (left > right) left = right = 0; // reset counters
        }

        return maxLength;
    }
}
