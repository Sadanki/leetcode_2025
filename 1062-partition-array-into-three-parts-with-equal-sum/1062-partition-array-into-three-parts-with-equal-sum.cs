public class Solution {
    public bool CanThreePartsEqualSum(int[] arr) {
        int total =0;
        foreach(int n in arr) total +=n;
        if(total % 3!=0) return false;
        int target = total/3;

        int runningSum = 0;
        int partsFound =0;
        for(int i =0; i< arr.Length; i++){
            runningSum += arr[i];
            if(runningSum == target){
                partsFound++;
                runningSum =0;
            }
        }
        return partsFound>=3;
    }
}