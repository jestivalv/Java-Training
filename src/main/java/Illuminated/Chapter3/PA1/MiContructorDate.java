package Illuminated.Chapter3.PA1;

// Cuidado con el import. Hay muchos simpledate en las capertas
import Illuminated.Chapter3.PA1.SimpleDate;

public class MiContructorDate {
	public static void main (String[] args) {
		
		SimpleDate independenceDay1;
		independenceDay1 = new SimpleDate(2,29,2024);
		
		SimpleDate independenceDay2;
		independenceDay2 = new SimpleDate(7,4,1776);
		
		
		System.out.println("Día "+ independenceDay1.getDay());
		System.out.println("Mes " + independenceDay1.getMonth());
		System.out.println("Año " + independenceDay1.getYear());
		
	}

}
