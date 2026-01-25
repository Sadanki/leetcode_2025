using System;
using System.Collections.Generic;

public class Solution {
    public int CalPoints(string[] operations) {
        var stack = new List<int>();

        foreach (var op in operations) {
            if (int.TryParse(op, out int num)) {
                stack.Add(num);
            } else if (op == "+") {
                int last = stack[stack.Count - 1];
                int secondLast = stack[stack.Count - 2];
                stack.Add(last + secondLast);
            } else if (op == "D") {
                int last = stack[stack.Count - 1];
                stack.Add(last * 2);
            } else if (op == "C") {
                stack.RemoveAt(stack.Count - 1);
            }
        }

        int total = 0;
        foreach (var score in stack) {
            total += score;
        }

        return total;
    }
}