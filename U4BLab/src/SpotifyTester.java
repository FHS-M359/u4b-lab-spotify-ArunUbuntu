import java.util.Scanner;
public class SpotifyTester {
    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.read("spotify_unique_25");
        p.read("spotify_unique_years_artists");
        p.read("spotify_with_duplicates");
        System.out.println(p);

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while(choice!=4) {
            System.out.println("\n===== Spotify Menu =====");
            System.out.println("1-Sort by artist (A->Z)");
            System.out.println("2-Sort by artist (Z->A)");
            System.out.println("3-Search by genre");

            System.out.println("Choose: ");
            choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                p.sortByArtistAZ();
                System.out.println("\n Sorted by Artists A-Z!");
                System.out.println(p);
            } else if (choice == 2) {
                p.sortByArtistZA();
                System.out.println("\n Sorted by Artists Z-A!");
                System.out.println(p);
            } else if (choice == 3) {
                System.out.println("Enter genre: ");
                String genre = scan.nextLine();
                p.searchByGenre(genre);
            } else {
                System.out.println("Invalid choice. Please Input one of the listed choices.");
            }
        }
            scan.close();
    }
    }
//Working on Insertion Sort