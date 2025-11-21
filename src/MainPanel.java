import java.sql.SQLException;
import java.util.Scanner;

public class MainPanel {
    static DbOperations dbo = new DbOperations();
    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("""
            +-----------------------+");
            | WELCOME TO DBMS MSPA4 |
            +-----------------------+
            +-------------------------------------------------------------------------------------------------------+
            | NOTE: Check whether data you are entering for any of category has existing reference in another table |
            +-------------------------------------------------------------------------------------------------------+
            +------------+
            | 1. INSERT  |
            +------------+
            | 2. DISPLAY |
            +------------+
            | 3. DELETE  |
            +------------+
            | 4. UPDATE  |
            +------------+
            CHOOSE OPERATION?""");
            int operation = ip.nextByte();
//
            while (operation<=4) {
                switch (operation) {
                    case 1:{
                        fullLine();
                        System.out.println("Which category to insert?\n1. Album\n2. Artist\n3. Events\n4. Royalty\n5. Track\n6. Exit");
                        int operationInsert = ip.nextInt();
                        ip.nextLine();
                        switch (operationInsert) {
                            case 1:
                                fullLine();
                                Object[] album = albumInsertion();
                                dbo.insertAlbum((int) album[0], (String) album[1], (String) album[2], (String) album[3], (int) album[4]);
                                break;
                            case 2:
                                fullLine();
                                Object[] artist = artistInsertion();
                                dbo.insertArtist((int) artist[0], (String) artist[1], (Boolean) artist[2]);
                                break;
                            case 3:
                                fullLine();
                                Object[] event = eventInsertion();
                                dbo.insertEvent((int) event[0], (String) event[1], (String) event[2], (String) event[3], (int) event[4]);
                                break;
                            case 4:
                                fullLine();
                                Object[] royalty = royaltyInsertion();
                                dbo.insertRoyalties((int) royalty[0], (int) royalty[1], (int) royalty[2], (double) royalty[3], (int) royalty[4], (double) royalty[5]);
                                break;
                            case 5:
                                fullLine();
                                Object[] track = trackInsertion();
                                dbo.insertTrack((int) track[0], (String) track[1], (int) track[2], (String) track[3], (int) track[4], (int) track[5]);
                                break;
                            default:
                                fullLine();
//                                System.out.println("Invalid Input");
                                return;
                        }}
                        break;
                    case 2:{
                        fullLine();
                        System.out.println("Which category to display?\n1. Album\n2. Artist\n3. Events\n4. Royalty\n5. Track\n6. Exit");
                        char operationDisplay = ip.next().charAt(0);
                        ip.nextLine();
                        switch (operationDisplay) {
                            case '1':
                                fullLine();
                                dbo.displayAlbums();
                                break;
                            case '2':
                                fullLine();
                                dbo.displayArtists();
                                break;
                            case '3':
                                fullLine();
                                dbo.displayEvents();
                                break;
                            case '4':
                                fullLine();
                                dbo.displayRoyalties();
                                break;
                            case '5':
                                fullLine();
                                dbo.displayTrack();
                                break;
                            default:
//                                System.out.println("Invalid Input");
                                return;
                        }
                    }
                        break;
                    case 3: {
                        fullLine();
                        System.out.println("Which category to delete?\n1. Album\n2. Artist\n3. Events\n4. Royalty\n5. Track\n6. Exit");
                        int operationDelete = ip.nextByte();
                        switch (operationDelete) {
                            case 1:
                                fullLine();
                                System.out.print("Enter Album ID:\t");
                                int albumId = ip.nextInt();
                                ip.nextLine();
                                dbo.deleteAlbum(albumId);
                                break;
                            case 2:
                                fullLine();
                                System.out.println("Enter Artist ID:\t");
                                int artistId = ip.nextInt();
                                ip.nextLine();
                                dbo.deleteArtist(artistId);
                                break;
                            case 3:
                                fullLine();
                                System.out.println("Enter Event ID:\t");
                                int eventId = ip.nextInt();
                                ip.nextLine();
                                dbo.deleteEvent(eventId);
                                break;
                            case 4:
                                fullLine();
                                System.out.println("Enter Royalty ID:\t");
                                int royaltyId = ip.nextInt();
                                ip.nextLine();
                                dbo.deleteRoyalty(royaltyId);
                                break;
                            case 5:
                                fullLine();
                                System.out.println("Enter Track ID:\t");
                                int trackId = ip.nextInt();
                                ip.nextLine();
                                dbo.deleteTrack(trackId);
                                break;
                            default:
//                                System.out.println("Invalid Input");
                                return;
                        }
                    }
                        break;
                    case 4: {
                        fullLine();
                        System.out.println("Which category to update?\n1. Album\n2. Artist\n3. Events\n4. Royalty\n5. Track\n6. Exit");
                        int operationUpdate = ip.nextInt();
                        ip.nextLine();
                        switch (operationUpdate) {
                            case 1: {
                                fullLine();
                                System.out.println("1. AlbumID\n2. Album Title\n3. Album Date\n4. Album Genre\n5. Artist ID for Album\n6. Exit\nWhat to Update?");
                                int UpdationChoice = ip.nextInt();
                                ip.nextLine();
                                switch (UpdationChoice) {
                                    case 1:
                                        fullLine();
                                        updateAlbumId();
                                        break;
                                    case 2:
                                        fullLine();
                                        updateAlbumTitle();
                                        break;
                                    case 3:
                                        fullLine();
                                        updateAlbumDate();
                                        break;
                                    case 4:
                                        fullLine();
                                        updateAlbumGenre();
                                        break;
                                    case 5:
                                        fullLine();
                                        updateAlbumArtistId();
                                        break;
                                    default:
//                                        System.out.println("Invalid Input");
                                        return;
                                }
                            }
                            break;
                            case 2:{
                                fullLine();
                                System.out.println("1. Arist ID\n2. Artist Name\n3. Is Solo\n4. Exit\nWhat to update?");
                                int UpdationChoice = ip.nextInt();
                                ip.nextLine();
                                switch (UpdationChoice) {
                                    case 1:
                                        fullLine();
                                        updateArtistId();
                                        break;
                                    case 2:
                                        fullLine();
                                        updateArtistName();
                                        break;
                                    case 3:
                                        fullLine();
                                        updateArtistIsSolo();
                                        break;
                                    default:
//                                        System.out.println("Invalid Input");
                                        return;

                                }
                            }
                            break;
                            case 3:{
                                fullLine();
                                System.out.println("1. Event ID\n2. Event Name\n3. Event Date\n4. Event Organizer\n5. Artist ID who performed\n6. Exit\nWhat to Update?");
                                int UpdationChoice = ip.nextInt();
                                ip.nextLine();
                                switch (UpdationChoice) {
                                    case 1:
                                        fullLine();
                                        updateEventId();
                                        break;
                                    case 2:
                                        fullLine();
                                        updateEventName();
                                        break;
                                    case 3:
                                        fullLine();
                                        updateEventDate();
                                        break;
                                    case 4:
                                        fullLine();
                                        updateEventOrganizer();
                                        break;
                                    case 5:
                                        fullLine();
                                        updateEventArtistId();
                                        break;
                                    default:
//                                        System.out.println("Invalid Input");
                                        return;
                                }
                            }
                            break;
                            case 4:{
                                fullLine();
                                System.out.println("1. Royalty ID\n2. Track ID\n3. Event ID\n4. Sales Amount\n5. Stream Count\n6. Royalty Amount\n7. Exit\nWhat to Update?");
                                int UpdationChoice = ip.nextInt();
                                ip.nextLine();
                                switch (UpdationChoice) {
                                    case 1:
                                        fullLine();
                                        updateRoyaltyId();
                                        break;
                                    case 2:
                                        fullLine();
                                        updateRoyaltyTrackId();
                                        break;
                                    case 3:
                                        fullLine();
                                        updateRoyaltyEventId();
                                        break;
                                    case 4:
                                        fullLine();
                                        updateRoyaltySalesAmount();
                                        break;
                                    case 5:
                                        fullLine();
                                        updateRoyaltyStreamCount();
                                        break;
                                    case 6:
                                        fullLine();
                                        updateRoyaltyAmount();
                                        break;
                                    default:
//                                        System.out.println("Invalid Input");
                                        return;
                                }
                            }
                            break;
                            case 5:{
                                fullLine();
                                System.out.println("1. TrackId\n2. Track Title\n3. Track Duration(in seconds)\n4. Track Genre\n5. AlbumID for Track\n6. ArtistID for track\n7. Exit\nWhat to Update?");
                                int UpdationChoice = ip.nextInt();
                                ip.nextLine();
                                switch (UpdationChoice) {
                                    case 1:
                                        fullLine();
                                        updateTrackId();
                                        break;
                                    case 2:
                                        fullLine();
                                        updateTrackTitle();
                                        break;
                                    case 3:
                                        fullLine();
                                        updateTrackDurationInSeconds();
                                        break;
                                    case 4:
                                        fullLine();
                                        updateTrackGenre();
                                        break;
                                    case 5:
                                        fullLine();
                                        updateTrackAlbumId();
                                        break;
                                    case 6:
                                        fullLine();
                                        updateTrackArtistId();
                                        break;
                                    default:
//                                        System.out.println("Invalid Input");
                                        return;
                                }
                            }
                            break;
                            default:
//                                System.out.println("Invalid Input");
                                return;
                        }
                    }
                        break;
                    default:
                        fullLine();
//                        System.out.println("Invalid Input");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("!!!INVALID INPUT!!!");
        }
    }

    // INSERT CODE STARTS HERE...
    public static Object[] artistInsertion() {
        System.out.print("Enter Artist ID(numeric):\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Artist Name:\t");
        String artistName = ip.nextLine();
        System.out.print("Enter whether Artist is Solo or not:(true | false)\t");
        boolean isSolo = ip.nextBoolean();
        return new Object[]{artistId, artistName, isSolo};
    }

    public static Object[] albumInsertion() {
        System.out.print("Enter Album ID(numeric):\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Album Title:\t");
        String albumTitle = ip.nextLine();
        System.out.print("Enter Album Date(put in format YYYY-MM-DD):\t");
        String albumDate = ip.nextLine();
        System.out.print("Enter Album Genre:\t");
        String albumGenre = ip.nextLine();
        System.out.print("ID of Artist who created it:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        return new Object[]{albumId, albumTitle, albumDate, albumGenre, artistId};
    }

    public static Object[] eventInsertion() {
        System.out.print("Enter Event ID(numeric):\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Event Name:\t");
        String eventName = ip.nextLine();
        System.out.print("Enter Event Date (YYYY-MM-DD)\t");
        String eventDate = ip.nextLine();
        System.out.print("Enter Event Organizer:\t");
        String eventOrganizer = ip.nextLine();
        System.out.print("Enter ID of Artist Associated with it:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        return new Object[]{eventId, eventName, eventDate, eventOrganizer, artistId};
    }

    public static Object[] royaltyInsertion() {
        System.out.print("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Track ID for which Royalty is claimed:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter ID of event related to Royalty:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter sales amount:\t");
        double salesAmount = ip.nextDouble();
        System.out.print("Enter stream count:\t");
        int streamCount = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter amount distributed:\t");
        double amount = ip.nextDouble();
        return new Object[]{royaltyId, trackId, eventId, salesAmount, streamCount, amount};
    }

    public static Object[] trackInsertion() {
        System.out.print("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Track title:\t");
        String trackTitle = ip.nextLine();
        System.out.print("Enter Duration in seconds: \t");
        int durationSeconds = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Genre:\t");
        String genre = ip.nextLine();
        System.out.print("Enter AlbumID associated: \t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Artist ID:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        return new Object[]{trackId, trackTitle, durationSeconds, genre, albumId, artistId};
    }

    // UPDATE CODE STARTS HERE...
    public static void updateArtistId() throws SQLException {
        System.out.println("Enter Original Artist ID:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        System.out.print("Enter Updated ID:\t");
        int updatedArtistId = ip.nextInt();
        ip.nextLine();
        dbo.ArtistId(artistId, updatedArtistId);

    }

    public static void updateArtistName() throws SQLException {
        System.out.println("Enter Artist ID:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Artist Name:\t");
        String artistName = ip.nextLine();
        dbo.ArtistName(artistId, artistName);
    }

    public static void updateArtistIsSolo() throws SQLException {
        System.out.println("Enter Artist ID:\t");
        int artistId = ip.nextInt();
        ip.nextLine();
        System.out.println("Update whether Artist is Solo or not(TYPE ONLY true/false):\t");
        boolean isSolo = Boolean.parseBoolean(ip.next());
        dbo.ArtistIsSolo(artistId, isSolo);
    }

    public static void updateAlbumId() throws SQLException {
        System.out.println("Enter Original Album ID:\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Album ID:\t");
        int updatedAlbumId = ip.nextInt();
        ip.nextLine();
        dbo.AlbumId(albumId, updatedAlbumId);
    }

    public static void updateAlbumTitle() throws SQLException {
        System.out.println("Enter Album ID:\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Album Title:\t");
        String albumTitle = ip.nextLine();
        dbo.AlbumTitle(albumId, albumTitle);
    }

    public static void updateAlbumDate() throws SQLException {
        System.out.println("Enter Album ID:\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Album Date(IN FORMAT OF 'YYYY-MM-DD'):\t");
        String albumDate = ip.nextLine();
        dbo.AlbumDate(albumId, albumDate);
    }

    public static void updateAlbumGenre() throws SQLException {
        System.out.println("Enter Album ID:\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Album Genre:\t");
        String albumGenre = ip.nextLine();
        dbo.AlbumGenre(albumId, albumGenre);
    }

    public static void updateAlbumArtistId() throws SQLException {
        System.out.println("Enter Album ID:\t");
        int albumId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Artist ID for the Album:\t");
        int updatedAlbumArtistId = ip.nextInt();
        ip.nextLine();
        dbo.AlbumArtistId(albumId, updatedAlbumArtistId);
    }

    public static void updateEventId() throws SQLException {
        System.out.println("Enter Event ID:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Event ID:\t");
        int updatedEventId = ip.nextInt();
        ip.nextLine();
        dbo.EventId(eventId, updatedEventId);
    }

    public static void updateEventName() throws SQLException {
        System.out.println("Enter Event ID:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Event Name:\t");
        String eventName = ip.nextLine();
        dbo.EventName(eventId, eventName);
    }

    public static void updateEventDate() throws SQLException {
        System.out.println("Enter Event ID:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Event Date to Update(IN FORMAT OF 'YYYY-MM-DD'):\t");
        String eventDate = ip.nextLine();
        dbo.EventDate(eventId, eventDate);
    }

    public static void updateEventOrganizer() throws SQLException {
        System.out.println("Enter Event ID:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Organizer Name:\t");
        String organizerName = ip.nextLine();
        dbo.EventOrganizer(eventId, organizerName);
    }

    public static void updateEventArtistId() throws SQLException {
        System.out.println("Enter Event ID:\t");
        int eventId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Artist ID:\t");
        int updatedEventArtistId = ip.nextInt();
        ip.nextLine();
        dbo.EventArtistId(eventId, updatedEventArtistId);
    }

    public static void updateTrackId() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Track ID:\t");
        int updatedTrackId = ip.nextInt();
        ip.nextLine();
        dbo.TrackId(trackId, updatedTrackId);
    }

    public static void updateTrackTitle() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Track Title to be Updated:\t");
        String trackTitle = ip.nextLine();
        dbo.TrackTitle(trackId, trackTitle);
    }

    public static void updateTrackDurationInSeconds() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Track Duration:\t");
        int updatedTrackDurationInSeconds = ip.nextInt();
        ip.nextLine();
        dbo.TrackDurationInSeconds(trackId, updatedTrackDurationInSeconds);
    }

    public static void updateTrackGenre() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Track Genre for this Track ID:\t");
        String updatedTrackGenre = ip.nextLine();
        dbo.TrackGenre(trackId, updatedTrackGenre);
    }

    public static void updateTrackAlbumId() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Album ID that contains this Track:\t");
        int updatedTrackAlbumId = ip.nextInt();
        ip.nextLine();
        dbo.TrackAlbumId(trackId, updatedTrackAlbumId);
    }

    public static void updateTrackArtistId() throws SQLException {
        System.out.println("Enter Track ID:\t");
        int trackId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Artist ID associated with this Track ID:\t");
        int updatedTrackArtistId = ip.nextInt();
        ip.nextLine();
        dbo.TrackAlbumId(trackId, updatedTrackArtistId);
    }

    public static void updateRoyaltyId() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Updated Royalty ID:\t");
        int updatedRoyaltyId = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltyId(royaltyId, updatedRoyaltyId);
    }

    public static void updateRoyaltyTrackId() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Track ID to be updated for this Royalty:\t");
        int updatedRoyaltyTrackId = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltyTrackId(royaltyId, updatedRoyaltyTrackId);
    }

    public static void updateRoyaltyEventId() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Event ID to be updated for this Royalty:\t");
        int updatedRoyaltyEventId = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltyEventId(royaltyId, updatedRoyaltyEventId);
    }

    public static void updateRoyaltySalesAmount() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Sales Amount to be updated for this Royalty:\t");
        int updatedRoyaltySalesAmount = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltySalesAmount(royaltyId, updatedRoyaltySalesAmount);
    }

    public static void updateRoyaltyStreamCount() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Event ID to be updated for this Royalty:\t");
        int updatedRoyaltyStreamCount = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltyStreamCount(royaltyId, updatedRoyaltyStreamCount);
    }

    public static void updateRoyaltyAmount() throws SQLException {
        System.out.println("Enter Royalty ID:\t");
        int royaltyId = ip.nextInt();
        ip.nextLine();
        System.out.println("Enter Royalty Amount to be updated for this Royalty:\t");
        int updatedRoyaltyAmount = ip.nextInt();
        ip.nextLine();
        dbo.RoyaltyAmount(royaltyId, updatedRoyaltyAmount);
    }

    public static void fullLine(){
        System.out.println("==========================================================================================================");
    }

}