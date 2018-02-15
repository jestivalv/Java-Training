package Java6src;
import java.util.*;

/* Comparable es una interfaz suministrada por el propio java.lang */
public class Item implements Comparable {
	private int quantity;
	private String id, name;
	private double retail, price;
	
	// Recibe 4 de los 5 parametros. Los recibe todos como string
	Item (String name, String id, String quantity, String retail) {
		this.id = id;
		this.name = name;
		this.retail = Double.parseDouble(retail);
		this.quantity = Integer.parseInt(quantity);
		
		//Vemos que price devuelve según la cantidad
		if (this.quantity > 400) {
			this.price = (this.retail * .5D);
			
		}
		else if (this.quantity>200){
			this.price = this.retail * .6D;
 			
		}
		else this.price = this.retail * .6D;
		
	}
	
	//a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
	public int compareTo (Object obj) {
		Item temp = (Item)obj;
		if (this.price < temp.price) return 1;
		else if (this.price > temp.price) return -1;
		else return 0;
		
	}
	
	public String getId () {
		return this.id;
	}
	public String getName() {
		return this.name;
		
	}
	public double getRetail () {
		return this.retail;
		
	}
	public double getPrice () {
		return this.price;
	}
	public int getQuantity () {
		return this.quantity;
	}
	
	

}
