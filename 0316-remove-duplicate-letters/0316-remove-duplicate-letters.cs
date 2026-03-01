public class Solution {
    public string RemoveDuplicateLetters(string s) {

        // STEP 1: Count frequency of each char
        int[] count   = new int[26];
        bool[] inStack = new bool[26];
        foreach (char c in s)
            count[c - 'a']++;

        // STEP 2: Greedy pass with stack
        Stack<char> stack = new Stack<char>();

        foreach (char c in s) {
            count[c - 'a']--;               // reduce remaining count

            if (inStack[c - 'a']) continue; // skip duplicates

            // Pop larger chars only if they appear later
            while (stack.Count > 0
                   && stack.Peek() > c
                   && count[stack.Peek() - 'a'] > 0) {
                inStack[stack.Pop() - 'a'] = false;
            }

            stack.Push(c);
            inStack[c - 'a'] = true;
        }

        // STEP 4: Reverse stack → return result
        char[] arr = stack.ToArray();
        Array.Reverse(arr);
        return new string(arr);
    }
}