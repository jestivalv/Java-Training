// Mi Clase SimpleDate
// Atributos de clase int date, day, year
// Constructor por defecto y sobre cargado. 
// Documentar javadoc
// Controlar que está en rango con operador condicional ternario
// Escribir una fucnión para ver si es Bisiesto isLeap

package Illuminated.Chapter3.PA1;

public class SimpleDate {
	private int mm, dd, yyyy;
	private static final int DEFAULT_MONTH = 1;
	private static final int DEFAULT_DAY = 1;
	private static final int DEFAULT_YEAR = 1979;
	

/** Constructor por defecto */
	public  SimpleDate() {
		this(DEFAULT_MONTH, DEFAULT_DAY, DEFAULT_YEAR);
	}
	
/** Constructor Sobrecargado */
	public SimpleDate (int mm, int dd, int yyyy) {
		// Este sería un modo pero vamos a asignar una función para controlar que el dato es correcto
		//this.dd=dd;
		
		setYear (yyyy);
		setMonth (mm);
		setDay (dd);
		
		
	}
	
	//GETTERS
	/** Esta es la función getter para recuperar el mes */
	public int getMonth () {
		return mm;
	}
	
	/** Esta es la funcion getter para recuperar el día. Escrito en una sola línea */
	public int getDay () { return dd;}
	public int getYear () { return yyyy;}
	
	
	//SETTERS
	/** Evaluamos si el dato  mm es correcto
	 * @param mm Valor del mes tipo:int*/
	public void setMonth (int mm) {
		//Una sentencia if tradicional sería
		/*
		if (1 <= mm <= 12) {
			this.mm = mm;
		}
		*/
		/** El condicional ternario sería */
		
		this.mm = (mm >= 1) && (mm <= 12)?mm:this.mm;
			
	}
	
	public void setDay (int dd) {
		this.dd = (dd>=1 && isValidDay(dd))?dd:this.dd;
	}
	
	public boolean isValidDay (int dd) {
		// recordar que this.mm representa el mm que ha recibido el objeto. 
		// la posición 1 pertencerá a enero, 2 a febrero, etc
		int [] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				
				// solo un mes puede ser mayor a lo especificado
				if (dd > daysInMonth[this.mm]) {
					
					if (this.mm == 2 && isLeapYear() && dd == 29)
						return true;
					else 
						return false;
		}
		return true;
		
	}
	
	 private boolean isLeapYear( )
	  {
		 return !( this.yyyy % 4 != 0 ||( this.yyyy % 100 == 0 && this.yyyy % 400 != 0 ));
	  }
	
	public void setYear (int yyyy) {
		this.yyyy = yyyy;
	}
	
// End of Class	
}
