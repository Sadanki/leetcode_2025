class Solution {
    public int dayOfYear(String date) {
      int year= Integer.parseInt(date. substring(0,4));
      int month= Integer.parseInt(date.substring(5,7));
      int day= Integer.parseInt(date.substring(8,10));  

      int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 
                             31, 31, 30, 31, 30, 31};

     if(isLeapYear(year)){
        daysInMonth[1]=29;
     }

     int dayOfYear = day;
     for(int i=0; i< month-1; i++){
        dayOfYear = dayOfYear+daysInMonth[i];
     }
     return dayOfYear;

    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

}