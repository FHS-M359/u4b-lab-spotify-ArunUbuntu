import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
//Stores a list of songs
public class Playlist {
private ArrayList<Song> songs;
//Initializes the playlist
public Playlist(){
    songs=new ArrayList<Song>();
}

    /**
     *Read songs data from a txt file and puts song objects into the Playlist
     * Expects:title,artist,album,duration,releaseYear,genre
     *
     * @param filename file name to read in from
     */
    public void read(String filename){
    try{
        Scanner file=new Scanner(new File(filename));
        while(file.hasNextLine()){
            String line=file.nextLine();
            String[]parts=line.split(",");
            songs.add(new Song(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),parts[5]));
        }
        file.close();
    }
    catch(Exception e){
        System.out.println("File error");
    }
}

    /**
     * Does linear search through the playlist to display all songs in a specific genre and prints
     * @param g
     */
    public void searchByGenre(String g){
    boolean found=false;
    System.out.println(String.format("%-25s %-20s %-30s %-6s %-12s\n","Title", "Artist", "Album", "Year", "Genre"));
    System.out.println("-----------------------------------------------------------------------------------------------------------------");
    for(Song s: songs){
        if(s.getGenre().equalsIgnoreCase(g)){
            System.out.println(s);
            found=true;
        }
    }
    if(!found){
        System.out.println("No songs found in that genre. Input a different one.");
    }
}

    /**
     * Sorts the playlist by artist name(A-Z) using selection sort features
     */
    public void sortByArtistAZ(){
    for(int i=0;i<songs.size()-1;i++){
        int minIndex=i;
        for(int j=i+1;j<songs.size();j++){
            if(songs.get(j).getArtist().compareToIgnoreCase(songs.get(minIndex).getArtist())<0) {
                minIndex = j;
            }
        }
        Song have=songs.get(i);
        songs.set(i,songs.get(minIndex));
        songs.set(minIndex,have);
    }
}

    /**
     * Sorts the playlist by artist name(Z-A) using selection sort features
     */
    public void sortByArtistZA() {
    for (int i = 0; i < songs.size() - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < songs.size(); j++) {
            if (songs.get(j).getArtist().compareToIgnoreCase(songs.get(maxIndex).getArtist()) > 0) {
                maxIndex = j;
            }
        }
            Song have = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, have);
    }
}

    /**
     * Sorts the playlist by release year from oldest to newest using insertion sort features
     */
    public void sortByOldestYr(){
    for(int i=1;i<songs.size();i++){
        Song put=songs.get(i);
        int j=i-1;
        while(j>=0&&songs.get(j).getYear()>put.getYear()){
            songs.set(j+1,songs.get(j));
            j--;
        }
        songs.set(j+1,put);
    }
}

    /**
     * Sorts the playlist by release year from newest to oldest using insertion sort features
     */
    public void sortByNewestYr(){
    for(int i=1;i<songs.size();i++){
        Song put=songs.get(i);
        int j=i-1;
        while(j>=0&&songs.get(j).getYear()<put.getYear()){
            songs.set(j+1,songs.get(j));
            j--;
        }
        songs.set(j+1,put);
    }
}

    /**
     *
     * @return a neatly formatted String of the table to match the Song rows
     */
    public String toString(){
    String result="";
    result+=String.format("%-25s %-20s %-30s %-6s %-12s\n", "Title", "Artist", "Album", "Year", "Genre");
    result+="----------------------------------------------------------------------------------------------------------------------------\n";
    for(Song s: songs){
        result+=s.toString()+ "\n";
    }
    return result;
}
}
