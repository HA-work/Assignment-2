// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

// stack
public class SongHistoryList {
  
  public Song top;
  public Song bot;
  public int maxSize = 50;
  public int count;
  // need a last because when history is full the last item should be removed
  // technically not a proper stack though because of this
  // will not allow peek to bot though
  // no limit is easier to implement
  
 
 //*********************************************************************************   
 //No-Arg Constructor
 
 /* Method public SongHistoryList():
  * 
  * Input:
  *    None
  * Process:
  *    creates SongHistoryList() object
  *    sets int values to 0
  *    sets top and bot to null
  * Output:
  *    None
  */ 
  
  
  public SongHistoryList(){
    // constructor for creating a new list
    top = null;
    bot = null;
    count = 0;
    
    
    
  }
  
  
  
  
  
  
  //*********************************************************************************  
  /* public void addSong(String trackName, String artistName,  int v):
  * 
  * Input:
  *    String name the artist name
  *    String num the number of times the artist appeared
  *    String v the total views of the artist
  *    
  * Process:
  *    creates a new song object
  *    adds the song to the top of the stack
  *    increments count
  * Output:
  *    None
  */      
  // push
  public void addSong(String trackName, String artistName,  int v){
    
    
    Song s = new Song(trackName, artistName,  v);
    // makes a new song object so next does not get mixed up
    // a get song or song copy constructor would be useful
    
    
    if (isFull()){
      
      // check if full
      // hard to remove the last item from a stack without knowing the
      // one right before bot
      // having bot complicates things
      // removing bot makes it difficult to drop the last item from a stack though
      // maybe needs a doubly linked list?
      
      bot = bot.next;
      top.next = s;
      top = s;
      
    } else if (isEmpty()){
      
      bot = s;
      
      top = s;
      
      count++;
      
    } else {
      
      s.next = top;
      top = s;
      
      
      count++;
      
    }
    
    
    
  }
  
//*********************************************************************************    
 /* Method public boolean isEmpty():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the stack is empty
  *    returns true if it is
  *    false if its not
  * Output:
  *    boolean
  */         
  public boolean isEmpty(){
    
    
    return (count == 0);
    
  }
  
 //*********************************************************************************   
 /* Method public boolean isFull():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the stack is full
  *    returns true if it is
  *    false if its not
  * Output:
  *    boolean
  */   
    
  public boolean isFull(){
    
    
    return (count == 50);
    
  }
  
  
 //*********************************************************************************   
  /* Method public peekFront():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song at the top of the history
  *    does not remove
  * Output:
  *    Song top the first song in the stack
  */    
  public Song peekFront(){
    
    // error when stack is empty
    // how to fix?
    return top;
    
  }
  
//*********************************************************************************    
   /* Method public peekRear():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song at the bottom of the history
  *    does not remove
  * Output:
  *    Song bot the last song in the stack
  */    
  
  public Song peekRear(){
    
    // error when stack is empty
    return bot;
    
  }
 //*********************************************************************************   
/* public void deleteHistory():
  * 
  * Input:
  *    None
  * Process:
  *    Deletes the history list by setting top and bot to null
  * Output:
  *    None
  */         
  public void deleteHistory(){
    
    
    top = null;
    bot = null;
    
  }
  
 
//*********************************************************************************    
  
/* Method public lastListened():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song on top of the stack
  * Output:
  *    Song temp
  */    
  // technically same as front peak
   public Song lastListened(){
    // peek
    
    
    if ( isEmpty()){
      
      System.out.println("History is empty");
      // how to not return a song type?
      // what if the playlist is empty?
      
      return new Song("History is empty","",0);
      // not sure how to do this better
      // error when empty
      // needs to return a song item
      // could use exception handling
      
    } else {
      
     

      return bot;
    
  }
    
    
    
 }
  

  
  
  
  
  
  //*********************************************************************************  
    
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the stack
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
   public String toString() {
     
    String str = String.format("Song History%n");
  
    String str2;
  
  
    // str2 =  String.format("Number of Artists Read in: %d %n", count);
    // str = str + str2;
    
   
    str2 =  String.format("Number of Songs: %d %n", count);
    str = str + str2;
    

    
   
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
    // add an artist count?
  
     
    str2 = String.format("%-70s %-30s %-25s %-25s %n","Track Name" , "Artist Name","Views", "Appears");
     
    str = str + str2;
     
      
   
     
     
     //current starts from first
    Song current = top;
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
   
  
  
  
  
  
  
  
}

