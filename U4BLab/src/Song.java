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
    public String toString(){
        return title+", "+artist+", "+album+", "+duration+", "+year+", "+genre;
    }
}
