/* DiskMove
*  Anderson, Franceschi
*/

public class DiskMove
{ 
  private int diskNumber;
  private int fromTower;
  private int toTower;
   
  public DiskMove( int diskNumber, int fromTower, int toTower )
  {
     this.diskNumber = diskNumber;
     this.fromTower = fromTower;
     this.toTower = toTower;
  }   

  public int getDiskNumber( )
  {
    return diskNumber;
  } 
   
  public int getFromTower( )
  {
    return fromTower;
  } 
  
  public int getToTower( )
  {
    return toTower;
  }
     
  public String toString( )
  {
     return "Moving disk # " + diskNumber + " from Tower " + fromTower + " to Tower " + toTower;            
  }
}