import java.util.Scanner;
public class SpotifyTester {
    private static final int sortartistaz = 1;
    private static final int sortartistza = 2;
    private static final int sortyearoldnew = 3;
    private static final int sortyearnewold = 4;
    private static final int searchgenre = 5;
    private static final int displayall = 6;
    private static final int quit = 7;

    /**
     * Main base for the Spotify Playlist Program:
     * Loads song files, displays menu, and performs
     * sorting and searching features based off user input
     * @param args
     */
    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.read("spotify_unique_25");
        p.read("spotify_unique_years_artists");
        p.read("spotify_with_duplicates");
        System.out.println(p);
        //Options user can pick from
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (choice != quit) {
            System.out.println("\n===== Spotify Menu =====");
            System.out.println("1-Sort by artist (A->Z)");
            System.out.println("2-Sort by artist (Z->A)");
            System.out.println("3-Sort by year(Oldest->Newest)");
            System.out.println("4-Sort by year(Newest->Oldest)");
            System.out.println("5-Search by genre");
            System.out.println("6-Display all songs");
            System.out.println("7-Quit");
            //If it's not a valid choice, it won't crash
            System.out.println("Choose(1-7): ");
            boolean valNum = true;
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input. Input 1-7");
                scan.nextLine();
                choice = 0;
                valNum = false;
            }
            if (valNum) {
                if (choice == sortartistaz) {
                    p.sortByArtistAZ();
                    System.out.println("Everything sorted A-Z by artist!");
                    System.out.println(p);
                } else if (choice == sortartistza) {
                    p.sortByArtistZA();
                    System.out.println("Everything sorted Z-A by artist!");
                    System.out.println(p);
                } else if (choice == sortyearoldnew) {
                    p.sortByOldestYr();
                    System.out.println("Everything sorted oldest-newest by year!");
                    System.out.println(p);
                } else if (choice == sortyearnewold) {
                    p.sortByNewestYr();
                    System.out.println("Everything sorted newest-oldest by year!");
                    System.out.println(p);
                } else if (choice == searchgenre) {
                    System.out.println("Enter genre: ");
                    String genre=scan.nextLine();
                    p.searchByGenre(genre);
                    System.out.println("Done searching that genre!");
                } else if (choice == displayall) {
                    System.out.println("Displaying all songs!");
                    System.out.println(p);
                } else if (choice == quit) {
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Invalid choice. Please Input one of the listed choices.");
                }
            }
        }
            scan.close();
        }
    }

