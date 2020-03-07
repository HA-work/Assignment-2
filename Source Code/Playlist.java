// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

// will be like a queue
public class Playlist {
  public Song first;
  public Song last;
  public int maxSize = 500;
  public int count;
  public SongHistoryList history; // so when a song leaves a playlist it goes to history
  
  
  
  // make a new song class that is doubly?
  // array of songs?
  // putting the same song in different lists causes a problem because of next
  // should make a deep copy of objects to fix this problem
  
  
  // cant be doubly because removed prev from song
  
  //No-Arg Constructor
 
 /* Method public Playlist():
  * 
  * Input:
  *    None
  * Process:
  *    creates Playlist object
  *    makes a SongHistoryList
  *    sets int values to 0
  *    sets next and last to null
  * Output:
  *    None
  */
  public Playlist(){
    
    first = null;
    last = null;
    count = 0;
    history = new SongHistoryList();
    
    
    
    
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
  *    if the list is empty it makes the object the first and last item
  *    if it is not it makes the new object the last item and makes the 
  *    objects point to eachother
  *    increments count
  * Output:
  *    None
  */      
  
  
  public void addSong(String trackName, String artistName,  int v){
    // push
    Song s = new Song( trackName,  artistName,   v);
    
    if ( isFull()){
      
      System.out.println("Playlist is full");
      
      
    } else {
      
      count++;
    
    if (last == null){
      
      first = s;
      last = s;
      
      
      
    } else{
      
      last.next = s;
      last = s;
      
    }
    

    
    
    }
  }

//*********************************************************************************    
/* Method public listenToSong():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song at the top of the playlist
  *    and removes it from the list
  * Output:
  *    Song temp
  */  
  
  public Song listenToSong(){
    // pop
    Song temp; // the value to send
    
    if ( isEmpty()){
      
      System.out.println("Playlist is empty");
      // how to not return a song type?
      // what if the playlist is empty?
      
      return new Song("Playlist is empty","",0);
      // not sure how to do this better
      
    } else {
      
      
      
      
      history.addSong(first.trackName, first.artistName, first.views);
      
      count--;
    
    if (last == first){
      
      temp = first;
      
      first = null;
      last = null;
      
      
      
      
    } else{
      
      temp = first;
      first = first.next;
      
    }
    

    return temp;
    
    }
    
    
    
  }
  
  
 //*********************************************************************************   
/* Method public boolean isEmpty():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the queue is empty
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
  *    checks if the queue is full
  *    returns true if it is
  *    false if its not
  * Output:
  *    boolean
  */   
  
  
  public boolean isFull(){
    
    
    return (count == 500);
    
  }
  
//*********************************************************************************    
/* Method public peekFront():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song at the top of the playlist
  *    does not remove
  * Output:
  *    Song first the first song in the queue
  */    
  
  
  public Song peekFront(){
    
    // error when queue is empty
    return first;
    
  }

//*********************************************************************************    
/* Method public peekRear():
  * 
  * Input:
  *    None
  * Process:
  *    returns the song at the bottom of the queue
  *    does not remove
  * Output:
  *    Songlast the last song in the queue
  */      
  
  
  public Song peekRear(){
    
    // error when queue is empty
    return last;
    
  }
  
  
  
  
//*********************************************************************************  
    
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the queue
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
   public String toString() {
     
    String str = String.format("Playlist %nNumber of Songs in Playlist: %d %n", count);
  
    String str2;
  
  
    
   
    
    // number playlist?
    
   
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
    // add an artist count?
  
     
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
   
  
  
  
  
  // needs a limit
}