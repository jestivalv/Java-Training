/* Calculate the area of a circle
   Anderson, Franceschi
*/

public class AreaOfCircle
{
  public static void main( String [] args )
  {
     // define the data we know
	  final double PI = 3.14159;

     // define other data we will use
	  double radius = 3.5;
	  	  	 	    
	  // perform the calculation and store the result
	  double area = PI * radius * radius;
	  	  
	  // output the result
	  System.out.println( "The area of the circle is " + area );
  }
}