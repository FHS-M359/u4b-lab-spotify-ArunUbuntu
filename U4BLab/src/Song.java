public class Song {
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int duration;
    private int year;

    public Song(String t, String a,String al, int d, int y, String g){
        title=t;
        artist=a;
        album=al;
        duration=d;
        year=y;
        genre=g;
    }
    public String getGenre(){
        return genre;
    }
    public String getArtist(){
        return artist;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return String.format("%-25s %-20s %-25s %-8d %-6d %-12s", title, artist, album, duration, year,genre);
    }
}