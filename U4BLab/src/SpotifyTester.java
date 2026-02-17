public class SpotifyTester {
    public static void main(String[] args) {
        Playlist p=new Playlist();
        p.read("spotify_unique_25");
        p.read("spotify_unique_years_artists");
        p.read("spotify_with_duplicates");
        System.out.println(p);
    }
}
