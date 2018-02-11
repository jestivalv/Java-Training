package Illuminated;

public class SimpleDate {
	private int mm, dd, yy;
	public static final int DEFAULT_DATE = 1;
	public static final int DEFAULT_MONTH = 1;
	public static final int DEFAULT_YEAR = 1970;
	
	
	SimpleDate () {
		this(DEFAULT_MONTH, DEFAULT_DATE, DEFAULT_YEAR);
		
	}
	
	SimpleDate (int mm, int dd, int yy){
		
		
		this.mm = mm;
		this.dd = dd;
		this.yy = yy ;
		
	}

	int getMonth() {
		
		return mm;
	}
	int getDay() {
		
		return dd;
	}
	int getYear() {
		return yy;
		
	}
	
	
	
}

