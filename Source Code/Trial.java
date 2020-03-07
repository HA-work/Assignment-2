// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 1



//*********************************************************************************

import java.io.*; // import file class
import java.util.ArrayList; // import array using arraylist to store any number of files


public class Trial {
  
//*********************************************************************************
 public static void main(String[] args) throws IOException {
   

   
   
   ArrayList<String> fileList = new ArrayList<String>();
   
   
   ArrayList<TopStreamingSongs> allTheWeeks = new ArrayList<TopStreamingSongs>();
   
   fileList.add("input1.txt");
   fileList.add("input2.txt");
   fileList.add("input3.txt");
   fileList.add("input4.txt"); // the 4 input files
   

  
   
//*********************************************************************************   
   
   // use a loop to go through all the items
   for (int i = 0; i < fileList.size() ; i++){
     
    // put the data into an array of linked lists
     
    TopStreamingSongs dataExtract = new TopStreamingSongs(fileList.get(i));
    allTheWeeks.add(dataExtract);
     
     
   }
   
   
//*********************************************************************************   
   
   PrintWriter outFile1 = new PrintWriter("output1.txt");
   
   outFile1.println("Song lists of different weeks");
   
   // print to outpur 1 the contents of each linked list for each week
   
   for (int j = 0; j < allTheWeeks.size() ; j++){
     
     outFile1.println(allTheWeeks.get(j));
     
     // print in different files?
     
     
   }
   
   outFile1.close();
   
//*********************************************************************************   
   
   TopStreamingSongs finalList = mergeFiles(allTheWeeks);
    
   PrintWriter outFile2 = new PrintWriter("output2.txt");
   
   outFile2.println("List of all songs together");
   
   outFile2.println(finalList);
   // output the merged linked list of all weeks to a file
   
   outFile2.close();
   
   
//*********************************************************************************   
   
   // populate playlist
   // finallist
   // could be a method
   
   Playlist weeksPlaylist = new Playlist();
   // make a playlist
   
   Song current = finalList.first;
    
     
     while (current != null){
       
       
      weeksPlaylist.addSong(current.trackName, current.artistName , current.views );
      
      
      current = current.next; 
      // put songs from linkedlist into playlist queue
     
     
     
     }
     
     
//*********************************************************************************     
   PrintWriter outFile3 = new PrintWriter("output3.txt");
   
   outFile3.println("Songs in Playlist");
   
   outFile3.println(weeksPlaylist);
   // print the full playlist
   
   
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   weeksPlaylist.listenToSong();
   
   outFile3.println(weeksPlaylist);
   // print the playlist after listening to some songs in the same file
   
   outFile3.close();
     
     
     
//*********************************************************************************
   
   PrintWriter outFile4 = new PrintWriter("output4.txt");
   
   outFile3.println("Songs in History");
   
   outFile4.println(weeksPlaylist.history);
   
   // output history list
  
   
   
   outFile4.close();
    
      
//*********************************************************************************
     
    System.out.println("****************************************"+
                       "*********************************************");
    System.out.println("The program is terminating");
    System.out.println("********************************************"+
                       "********************************************");
    // outputs to the screen the program has finished
     
 }
 

     
 
 
 
 
 //*********************************************************************************
 
 
 
 /* Method public static TopStreamingSongs mergeFiles(ArrayList<TopStreamingSongs> listsToMerge):
  * 
  * Input:
  *    ArrayList<TopStreamingSongs> listsToMerge an array of lists to merge together
  * Process:
  *    goes through the array
  *    goes through the list and adds each song to another list to hold them all
  * Output:
  *    TopStreamingSongs sortedList a list that holds all the songs
  */
 
  
public static TopStreamingSongs mergeFiles(ArrayList<TopStreamingSongs> listsToMerge) {
     
     
     TopStreamingSongs sortedList = new TopStreamingSongs();
     
     TopStreamingSongs temp = new TopStreamingSongs();
     Song current;
     
     for (int j = 0; j < listsToMerge.size() ; j++){
     
      temp = listsToMerge.get(j);
     
     
      current = temp.first;
  
     
      while (current != null){
       
        
       sortedList.insertSong(current.trackName, current.artistName, current.views);
       // done to avoid problems with next
       // song with a copy would be better
       // copy should not copy next
      
       current = current.next; 
      
   
     
     
     }
     
     

     
     
   }
     
     
     
    return sortedList;
    
   }
    
 
 
 
//*********************************************************************************
 
}
