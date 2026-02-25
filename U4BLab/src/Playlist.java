import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Playlist {
private ArrayList<Song> songs=new ArrayList<Song>();
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
public void searchByGenre(String g){
    boolean found=false;
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
public void sortByArtistZA() {
    for (int i = 0; i < songs.size() - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < songs.size(); j++) {
            if (songs.get(j).getArtist().compareToIgnoreCase(songs.get(maxIndex).getArtist()) > 0) {
                maxIndex=j;
            }
            Song have = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, have);
        }
    }
}
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
    public String toString(){
    String result="";
    for(Song s: songs){
        result+=s+"\n";
    }
    return result;
}
}
