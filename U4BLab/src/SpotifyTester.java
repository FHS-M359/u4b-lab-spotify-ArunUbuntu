import java.util.Scanner;
public class SpotifyTester {
    public static void main(String[] args) {
        Playlist p=new Playlist();
        p.read("spotify_unique_25");
        p.read("spotify_unique_years_artists");
        p.read("spotify_with_duplicates");
        System.out.println(p);

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter genre: ");
        String genre=scan.nextLine();
        p.searchByGenre(genre);
        scan.close();
        //Genre Checked
        //Implementing SelectionS Sort
    }
}
