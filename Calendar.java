/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {

		int InputYear = Integer.parseInt(args[0]);
		String Date = "";
		int numOfSunday = 0;
	 	while (year != InputYear) {
			advance();

		}
	 		 while (year != (InputYear + 1)) {
				if (dayOfWeek == 1) {
					Date = dayOfMonth + "/" + month + "/" + year + " Sunday";
					System.out.println(Date);
				} else {
					Date = dayOfMonth + "/" + month + "/" + year;
					System.out.println(Date);
				}
				advance();
			}
        }
	

	 private static void advance() {
		dayOfWeek++;
		dayOfWeek = ((dayOfWeek+7)%7);

		dayOfMonth++;
		if (dayOfMonth > nDaysInMonth){
			dayOfMonth = 1;
			month++;

			if(month > 12){
				month =1;
				year++;
				nDaysInMonth = nDaysInMonth(month,year);
			}else{
				nDaysInMonth = nDaysInMonth(month,year);
			}
		}

	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear;
		isLeapYear = ((year % 400) == 0);
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int nDaysInMonth = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			nDaysInMonth = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			nDaysInMonth = 30;
		} else if ((month == 2)) {
			if(isLeapYear(year)){
				nDaysInMonth = 29;
			} else {
				nDaysInMonth = 28;
			}
		}
		return nDaysInMonth;
	}
}
