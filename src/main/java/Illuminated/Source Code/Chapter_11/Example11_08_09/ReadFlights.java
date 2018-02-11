 /* Reading structured data from a text file
    Anderson, Franceschi
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 
 import java.util.Scanner;
 import java.util.InputMismatchException;
 import java.util.ArrayList;

 public class ReadFlights
 {
   public static void main( String [ ] args )
   {
     // instantiate ArrayList to hold FlightRecord objects
     ArrayList<FlightRecord> listFlightRecords =
                                      new ArrayList<FlightRecord>( );

     try
     {
       Scanner file = new Scanner( new File( "flights.txt" ) );

       while ( file.hasNext( ) ) // test for the end of the file
       {
         // read a line
         String stringRead = file.nextLine( );

         // process the line read
         Scanner parse = new Scanner( stringRead );
         parse.useDelimiter( "," );
         String flightNumber = parse.next( );
         String origin = parse.next( );
         String destination = parse.next( );

         try
         {
           int numPassengers = parse.nextInt( );
           double avgTicketPrice = parse.nextDouble( );

           FlightRecord frTemp = new FlightRecord(
                                        flightNumber, origin, destination,
                                        numPassengers, avgTicketPrice );

           // add FlightRecord obj to listFlightRecords
           listFlightRecords.add( frTemp );
         }

         catch ( InputMismatchException ime )
         {
           System.out.println( "Error in flight record: "
           + stringRead + "; record ignored" );
         }
       }

       // release resources associated with flights.txt
       file.close( );
     }

     catch ( FileNotFoundException fnfe )
     {
       System.out.println( "Unable to find flights.txt" );
     }

     catch ( Exception e )
     {
       e.printStackTrace( );
     }

     // print the FlightRecords read
     for ( FlightRecord flight : listFlightRecords )
       System.out.println( flight );
   }
 }
