import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class PollingPlaces
{
  public static void main( String [] args ) 
  {
    final int ZIP_CODE_DIGITS = 5;
	 String fileName = "https://data.baltimorecity.gov/api/views/"
                    + "u7bw-gha5/rows.json?accessType=DOWNLOAD";
    
	 try 
    {
      URL url = new URL( fileName ) ;
      InputStream is = url.openStream( );
      Scanner dataSource = new Scanner( is );
      String json = "";
      String s = null;
      while ( dataSource.hasNext( ) )
      {
        s = dataSource.nextLine( );
        json += s;
      }
     
      JSONObject jsonObject = new JSONObject( json );
      JSONArray dataJsonArray = jsonObject.getJSONArray( "data" );
      System.out.println( "There are " + dataJsonArray.length( ) 
                        + " polling places in Baltimore" );
      
      // Build ArrayList of zip codes
      ArrayList<String> zipCodes = new ArrayList<String>( );
      for ( int i = 0; i < dataJsonArray.length( ); i++ )
      {
        JSONArray pollPlaceJsonArray = dataJsonArray.getJSONArray( i );
        // Clean up data, discard bad zip codes
        String currentZip = pollPlaceJsonArray.getString( 11 );
        if ( currentZip.length( ) != ZIP_CODE_DIGITS )
          System.out.println( "Discarding invalid code " + currentZip );
        else
          zipCodes.add( currentZip );
      }
            
       // Retrieve min and max zip codes
       String minZip = zipCodes.stream( )
                               .min( String::compareTo )
                               .get( );
       String maxZip = zipCodes.stream( )
                               .max( String::compareTo )
                               .get( );    
            
      // Ask user to enter a valid zip code
      Scanner scan = new Scanner( System.in );
      System.out.print( "\nPlease enter a zip code between " 
                        + minZip + " and " + maxZip + " > " );
      String zip = scan.next( );
      
      // Retrieve number of polling places in that zip code
      long count = zipCodes.stream( )
                           .filter( zipCode -> zipCode.equals( zip ) )
                           .count( );
      System.out.println( "There are " + count 
            + " polling places in the " + zip + " zip code" );
	 }
     
    catch ( MalformedURLException murle ) 
    {
		System.out.println( murle.getMessage( ) );
	 }
    
    catch ( IOException ioe ) 
    {
		System.out.println( ioe.getMessage( ) );
	 }
    
    catch ( JSONException e )
    {
      System.out.println( e.getMessage( ) );
    }
  }
}