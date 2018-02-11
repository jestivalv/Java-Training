/* Count tokens in a sentence
*  Anderson, Franceschi
*/

import java.util.Scanner;
public class CountTokens
{
  public static void main( String [ ] args )
  {
     Scanner scan = new Scanner( System.in );
     
     System.out.println( "Enter a sentence:" );
     String sentence = scan.nextLine( );
     sentence = sentence.trim( ); // remove leading/trailing white space

     if ( sentence.length( ) == 0 )
     {
        System.out.println( "The sentence is empty." );
     }
     else 
     {
         boolean inWhiteSpace = false;         
         int countTokens = 1;
           
         for ( int i = 0; i < sentence.length( ); i++ )
         {
            char c = sentence.charAt( i );
            if ( c == ' ' || c == '\t' )
            { 
              if ( ! inWhiteSpace )
              {
                  countTokens++;
                  inWhiteSpace = true;
              }
            }   
            else // not a whitespace character
            {
                  inWhiteSpace = false;
            }
           
         }
         System.out.println( "The sentence contains " + countTokens 
                      + ( countTokens == 1 ? " token." : " tokens." ) );
     } 
  }
}