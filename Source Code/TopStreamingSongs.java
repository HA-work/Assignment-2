// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

// linked list for the songs
// will take items from this to put in playlist

// decided to make a linked list first and then a queue so i have one list that can sort
// and one list that acts like a proper queue

// the queue will not act like a cue as the data has been presorted
// since the data needs to be sorted insertion is different
// might not need

import java.io.*; // import file class
import java.util.Scanner; // import scanner
// should not print from a class
// should find another way to read an make the error file


 public class TopStreamingSongs {
  
    public Song first; // first artist in the list
    
    public int count; // number of artists in the list
    // could do artists read for added info but a lot of work
    public int totalViews; // total views of all artists
    // using a linked list as a base for the que
    
    
    // does not need a limit
    // find a way to make it a doubly linked list? with insertion sort?
    public int maxSize = 500;
    //public TopStreamingSongs list = new TopStreamingSongs();
    //public Song front;
    //public Song rear;
    // public int count;
    
    
    
    // removed previous to make easier
    
    //when merging should remove duplicates
    
//*********************************************************************************  
    
 //No-Arg Constructor
 
 /* Method public TopStreamingSongs():
  * 
  * Input:
  *    None
  * Process:
  *    creates TopStreamingSongs object
  *    Sets first to null
  *    sets int data members to 0
  * Output:
  *    None
  */    
    
    public TopStreamingSongs(){
      first = null;
      
      count = 0;
      
      totalViews = 0;
      
    }
    
    
//*********************************************************************************    
    
 //Parametized Constructor
 
 /* Method public TopStreamingSongs(String fileName):
  * 
  * Input:
  *    String fileName the name of the file to read in
  * Process:
  *    reads in a file and parses the data nad inserts it
  *    into the list
  *    also writes errors to the error file
  *    and inserts the song into the linked list
  * Output:
  *    None
  */   
    
  // constructor creates a linked list that stores songs from one text file
  public TopStreamingSongs(String fileName) throws IOException {
    
    
    
   //list.insertSong("a","c", 2);
    
   // open and read the input file
   // could be made a method
   // this makes it easier to keep track of counts because we are using an array though
   // could make a method that returns an object with the relevant data though
  
   
   // error file
   // will have any errors
    
   String errorFileName = ( "errors" + fileName );
   
   // is there a way to append instead?
    
   PrintWriter errorFile = new PrintWriter(errorFileName);   // file
   
   int problemEntries = 0 ;
   
   int lineCount = 3;
    
   errorFile.println(" Hassan Akbar"); 
   errorFile.println(" CISC 3130");
   errorFile.println(" Professor Chuang");
   errorFile.println(" HW 1");
   errorFile.println();
     
   // maybe add a way to check if the errors in the file have been corrected  
   // someone would need to manually remove the extra commas
   
   // assummed entries are unique from a single weekly chart
   
   errorFile.println("List of errors and line they appear on" );
   
   errorFile.println("File: " + fileName );
   // print file name
     
   errorFile.println();
   
   // Inputfile
   File inFile = new File(fileName);
     
   // reading input in main so it is easier to count the artists and songs
   // a normal array makes this difficult

   //create Scanner object
   Scanner sc = new Scanner(inFile, "UTF-8");
   // fixed the scanner problem by adding "UTF-8" to the creation of the scanner object
   // this increases the character limit of the scanner
       
   String line;
     
   
   line = sc.nextLine(); // skip unneeded line
   line = sc.nextLine(); // skip unneeded line
  
   // 3rd line is where the data starts
   // deleted junk lines
     
   //TopStreamingSongs linkedList= new TopStreamingSongs() ;
     
   while (sc.hasNext() && count < maxSize ) {
     // could just be hasNext
     // used song limit as well so we dont have a potential problem
     // an arraylist would avoid this
      
     //read next line of data 
     line = sc.nextLine();
     

       
     // data stored as
     // position,    track name,    artist,     streams,      url
   
     String[] tokens = line.split(","); //tokenize a String using method split()
     // problem with splitting when song names have , in the title
     // can't think of a way to account for it
     // could count the number of tokens and if it is greater than index 4
     // this means a problem happened
     // dont know how to tell where the problem happened and correct for it though
     // can use the array.length data member to see how many tokens are made
     // if length is gretater > that 5 there is a problem
     // could skip this entry
     // not sure how to fix it without actually seeing where the problem is
     // errors are placed into a file
     
     
     
     // search for the error
     
     if (tokens.length > 5){
       
       do {
         
         
           
        problemEntries++;
        
        errorFile.println("File: " + fileName );
        errorFile.println("Error Number: " + problemEntries  );
        errorFile.println("Error on Line Number : " + lineCount);
        
        // add number to the start?
        
        errorFile.println(line);
        errorFile.println();
        line = sc.nextLine();
        lineCount++; // increase line count
        tokens = line.split(",");
        // checks if a problem occurs
        // skips the problem
        // needs a has next
        // need to watch out for the end of the file
        // error at entry 67 and others
        // could save the errors to an array
        // this way the error file can have statistics at the top instead of the bottom
        // decided to print immediately though
         
        // could use a better way to skip
         
       } while (tokens.length > 5);
     
     
      
       
     }
     
     
   
     String artistName = tokens[2];
     
    
   
     artistName = artistName.replaceAll("\"" , "");
     //remove the "" around some names
   
     String trackName = tokens[1];
     
     trackName = trackName.replaceAll("\"" , "");
     
     String views = tokens[3];
   
     int v = Integer.parseInt(views);
   
    
   
     insertSong(trackName,artistName, v);
     
   
     lineCount++;
     // song count up
   
 
   }
     
     
   sc.close();
   
   
   
   errorFile.println();
   errorFile.println("Number of Errors in file " + fileName + " : " + problemEntries);
   
   
   errorFile.flush();
   errorFile.close();
   
    
    
    // take the filename, open it and convert to queue
  }
  
  
  
  
  
  
  //*********************************************************************************  
  
  
  
  
  
    
/* Method public boolean isEmpty():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the linked list is empty
  *    returns true if it is
  *    false if its not
  * Output:
  *    boolean
  */      
    
    
    
    public boolean isEmpty(){
     return (first == null);
    }
    
    
//*********************************************************************************   
    
     
/* public void insertArtistLast(String name, String num, String v):
  * 
  * Input:
  *    String name the artist name
  *    String num the number of times the artist appeared
  *    String v the total views of the artist
  *    
  * Process:
  *    creates a new song object
  *    if the list is empty it makes the object the first and last item
  *    if it is not it makes the new object the last item and makes the 
  *    objects point to eachother
  * 
  *    uses insertion sort to sort the list
  *    also checks for duplicates and avoids them
  * 
  *    increments count
  *    adds to the song limit and total views
  * 
  *    the data being inserted is already sorted in alphabetical order
  *    so we use this method
  *   
  * Output:
  *    None
  */    
    
    
    // could make one that takes a song item
    // would need a copy constructor to avoid pointer problems though
    
  public void insertSong(String trackName, String artistName,  int v){ 
     
     // could have a sort method instead
     
     
    // should have an insert method where appears is a parameter
    // this way it can be checked more
    
    
    // Create the new node
     
    Song add = new Song(trackName, artistName, v);
    
    
    
      
    
    boolean songRepeated = false;
    
    
    Song previous = null;
    Song current = first;
    
    
    
      
      
      while ( current != null && add.trackName.compareToIgnoreCase(current.trackName) >= 0) {
        
        // had to change to >= so repeated songs would be found
        
        
        // add and artist and track name not equal
      
      
        
        
        if ( add.trackName.compareToIgnoreCase(current.trackName) == 0  &&  add.artistName.compareTo(current.artistName) == 0  ){
          
         
           current.appears++;
        
           current = null;
           // break out of loop
        
           songRepeated = true;
      
      
      
      
        } else {
        
        
        
        
        
        
        previous = current;
        current = current.next;
        
    }
     
      
  }
      
      
      
      
      if (songRepeated == false){
      
       if (previous == null) {
        
        first = add;
        //last = add;
        
       } else {
        
        previous.next = add;
        
        
        
      }
      
      
      count++;
      
      //songsRead = songsRead + add.timesAppeared; // increases songs read in
      totalViews = totalViews + add.views; // increases total views
    
      
      
      add.next = current;
      
      
      
      
  }
    
  
}


//*********************************************************************************    
    
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the linked list
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
   public String toString() {
     
    String str = String.format("List of songs %nNumber of Songs Read in: %d %n", count);
  
    String str2;
  
  
   // str2 =  String.format("Number of Artists Read in: %d %n", count);
   // str = str + str2;
    
   
    
    str2 =  String.format("Total Views: %d %n", totalViews);
    str = str + str2;
    
   
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
    // add an artist count?
    // add list numbers?
  
     
    str2 = String.format("%-70s %-30s %-25s %-25s %n","Track Name" , "Artist Name","Views", "Appears");
     
    str = str + str2;
     
      
   
     
     
     //current starts from first
     Song current = first;
     //move forward
     while(current != null) {
     
     
      //    for (int index = 0; index < count; index++){} // alternate loop using count
       
      str2 =  current.toString();
      str = str + str2;
       
      str2 =  String.format("%n");
      str = str + str2;
    
      
      current = current.next;
       
     }
    
    
     return str;
   
   }
   
//*********************************************************************************   
}
    
    