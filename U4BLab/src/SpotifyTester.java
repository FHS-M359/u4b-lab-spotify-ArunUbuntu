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
        while(choice!=6) {
            System.out.println("\n===== Spotify Menu =====");
            System.out.println("1-Sort by artist (A->Z)");
            System.out.println("2-Sort by artist (Z->A)");
            System.out.println("3-Search by genre");
            System.out.println("4-Sort by year(Oldest->Newest)");
            System.out.println("5-Sort by year(Newest->Oldest)");
            System.out.println("6-Quit");

            System.out.println("Choose: ");
            try {
                choice = scan.nextInt();
                scan.nextLine();
            }
            catch(Exception e){
                System.out.println("Invalid Input. Enter a number 1-6");
                scan.nextLine();
            }
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
            }
            else if(choice==4){
                p.sortByOldestYr();
                System.out.println(p);
            }
            else if(choice==5){
                p.sortByNewestYr();
                System.out.println(p);
            }
            else {
                System.out.println("Invalid choice. Please Input one of the listed choices.");
            }
        }
            scan.close();
    }
    }
