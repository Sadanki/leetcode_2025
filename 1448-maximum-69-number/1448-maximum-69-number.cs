public class Solution {
    public int Maximum69Number (int num) {
        
        string str = num.ToString();

        for(int i =0; i<str.Length; i++){
            if(str[i]== '6'){
                str = str.Substring( 0, i) + '9'+ str.Substring(i+1);
                break;
            }
        }

        return int.Parse(str);
    }
}