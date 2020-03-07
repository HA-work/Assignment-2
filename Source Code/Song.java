// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

 public class Song {
  
    public String trackName; // track name
    public String artistName; // artist name
    public Song next; // next artist in the list
    public int views;
    public int appears; // add to display and titles
    
    // removed previous to make easier
    // could use a copy constructor
    // should try a doubly linked list
    
//*********************************************************************************    
    
 //No-Arg Constructor
 
 /* Method public Song():
  * 
  * Input:
  *    None
  * Process:
  *    creates Song object
  *    Sets Strings data members to null string
  *    sets int values to 0
  *    sets next to null
  * Output:
  *    None
  */
    
    public Song() {
  
     trackName = "";
     artistName = "";
     views = 0;
     next = null;
     appears = 0;

   }
    
    
//*********************************************************************************    
//Parametized Constructor
 
 /* Method public Song(String tn, String an, int v)):
  * 
  * Input:
  *    String tn the track name
  *    String an the artist name
  *    int v the views of the artist
  * Process:
  *    creates Artist object
  *    Sets the parameters to the input
  *    
  * Output:
  *    None
  */
   
 public Song(String tn, String an, int v){
      
      trackName = tn; // set track name
      
      artistName = an; // set artist name
     
     
      //views = Integer.parseInt(v); // set the number of views need to parse the String
      
      views = v;
      appears = 1;
      // use a copy or find a way to increment appears
      // maybe make a second method that has appears as a parameter
      // appears is not really needed for playlist or history
     
      next = null; // set next to null
     
    }
    
//*********************************************************************************    
    
    
 /* Method String toString():
  * 
  * Input:
  *    None
  * Process:
  *    makes a formatted string
  * Output:
  *    Returns a formated string of the Artist object for printing
  */
 //toString() method - uses String static method .format()
 public String toString() {
  String str = String.format("%-70s %-30s %-25d %-25d ", trackName, artistName, views, appears);
  
  return str;
 }

    
//*********************************************************************************   
    
}