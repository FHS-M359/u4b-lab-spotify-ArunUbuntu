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
public String toString(){
    String result="";
    for(Song s: songs){
        result+=s+"\n";
    }
    return result;
}
}
