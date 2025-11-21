import java.sql.*;

public class DbOperations {
    PreparedStatement stmt;

    public void insertArtist ( int artistId, String name,boolean issolo) throws SQLException {
        Connection conn = DbConnection.getConnection();
        int isSolo = (issolo) ? 1 : 0;
        stmt = conn.prepareStatement("INSERT INTO artists VALUES(?,?,?);");
        stmt.setInt(1, artistId);
        stmt.setString(2, name);
        stmt.setInt(3, isSolo);
        stmt.executeUpdate();
        System.out.println("Artist inserted successfully");
    }

    public void insertAlbum(int albumId, String title, String date, String genre, int artistId) throws SQLException {
//        System.out.println("\nAlbum Success");
        Connection conn = DbConnection.getConnection();
        stmt = conn.prepareStatement("INSERT INTO albums VALUES(?,?,?,?,?);");
        stmt.setInt(1, albumId);
        stmt.setString(2, title);
        stmt.setString(3, date);
        stmt.setString(4, genre);
        stmt.setInt(5, artistId);
        stmt.execute();
        System.out.println("Album inserted successfully");
    }

    public void insertTrack(int trackId,String title,double duration,String genre,int albumId,int artistId) throws SQLException {
//        System.out.println("\nTrack Success");
        Connection conn = DbConnection.getConnection();
        stmt = conn.prepareStatement("INSERT INTO tracks VALUES(?,?,?,?,?,?);");
        stmt.setInt(1, trackId);
        stmt.setString(2, title);
        stmt.setDouble(3, duration);
        stmt.setString(4, genre);
        stmt.setInt(5, albumId);
        stmt.setInt(6, artistId);
        stmt.executeUpdate();
        System.out.println("Track inserted successfully");
    }

    public void insertEvent(int eventId, String eventName, String eventDate, String organizer, int artistId) throws SQLException {
//        System.out.println("\nEvent Success");
        Connection conn = DbConnection.getConnection();
        stmt = conn.prepareStatement("INSERT INTO events VALUES(?,?,?,?,?)");
        stmt.setInt(1, eventId);
        stmt.setString(2, eventName);
        stmt.setString(3, eventDate);
        stmt.setString(4, organizer);
        stmt.setInt(5, artistId);
        stmt.executeUpdate();
        System.out.println("Event inserted successfully");
    }

    public void insertRoyalties(int royaltyId, int trackId, int eventId, double salesAmount, int streamCount, double amountDistributed) throws SQLException {
//        System.out.println("\nRoyalty Success");
        Connection conn = DbConnection.getConnection();
        stmt = conn.prepareStatement("INSERT INTO royalites VALUES(?,?,?,?,?,?);");
        stmt.setInt(1,royaltyId);
        stmt.setInt(2,trackId);
        stmt.setInt(3,eventId);
        stmt.setDouble(4,salesAmount);
        stmt.setInt(5,streamCount);
        stmt.setDouble(6,amountDistributed);
        stmt.executeUpdate();
        System.out.println("Royalty inserted successfully");
    }

    public void displayAlbums() throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM albums;");
        while(rs.next()) {
            int albumId = rs.getInt("albumId");
            String title = rs.getString("title");
            String date = rs.getString("date");
            String genre = rs.getString("genre");
            int artistId = rs.getInt("artistId");
            System.out.println("Album ID: " + albumId);
            System.out.println("Title: " + title);
            System.out.println("Date: " + date);
            System.out.println("Genre: " + genre);
            System.out.println("Artist ID: " + artistId);
            System.out.println();
        }
    }

    public void displayArtists() throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM artists;");
        while(rs.next()) {
            int artistId = rs.getInt("artistId");
            String name = rs.getString("name");
            int isSolo = rs.getInt("isSolo");
            System.out.println("Artist ID: " + artistId);
            System.out.println("Name: " + name);
            System.out.println("isSolo: " + (isSolo == 1));
            System.out.println();
        }
    }

    public void displayEvents() throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM events;");
        while(rs.next()) {
            int eventId = rs.getInt("eventId");
            String eventName = rs.getString("name");
            String eventDate = rs.getString("date");
            String organizer = rs.getString("organizer");
            int artistId = rs.getInt("artistId");
            System.out.println("Event ID: " + eventId);
            System.out.println("Event Name: " + eventName);
            System.out.println("Event Date: " + eventDate);
            System.out.println("Organizer: " + organizer);
            System.out.println("Artist ID: " + artistId);
            System.out.println();
        }
    }

    public void displayRoyalties() throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM royalties;");
        while(rs.next()) {
            int royaltyId = rs.getInt("royaltyId");
            int trackId = rs.getInt("trackId");
            int eventId = rs.getInt("eventId");
            double salesAmount = rs.getDouble("salesAmount");
            int streamCount = rs.getInt("streamCount");
            int amountDistributed = rs.getInt("amountDistributed");
            String reportedDate = rs.getString("reportedDate");
            System.out.println("Royalty ID: " + royaltyId);
            System.out.println("Track ID: " + trackId);
            System.out.println("Event ID: " + eventId);
            System.out.println("SalesAmount: " + salesAmount);
            System.out.println("Stream Count: " + streamCount);
            System.out.println("Amount Distributed: " + amountDistributed);
            System.out.println();
        }
    }

    public void displayTrack() throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tracks;");
        while(rs.next()) {
            int trackId = rs.getInt("trackId");
            String title = rs.getString("title");
            int duration = rs.getInt("durationSeconds");
            int genre = rs.getInt("genre");
            int albumId = rs.getInt("albumId");
            int artistId = rs.getInt("artistId");
            System.out.println("Track ID: " + trackId);
            System.out.println("Title: " + title);
            System.out.println("Duration: " + duration);
            System.out.println("Genre: " + genre);
            System.out.println("Album ID: " + albumId);
            System.out.println("Artist ID: " + artistId);
            System.out.println();
        }
    }

    public void deleteArtist(int artistId) throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        stmt.executeUpdate("DELETE FROM artists where  artistId = "+artistId+";");
    }

    public void deleteEvent(int eventId) throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        stmt.executeUpdate("DELETE FROM events where eventId = "+eventId+";");
    }

    public void deleteRoyalty(int royaltyId) throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        stmt.executeQuery("DELETE FROM royalties where royaltyId = "+royaltyId+";");
    }

    public void deleteTrack(int trackId) throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        stmt.executeUpdate("DELETE FROM tracks where trackId = "+trackId+";");
    }

    public void deleteAlbum(int albumId) throws SQLException {
        Statement stmt = DbConnection.getConnection().createStatement();
        stmt.executeUpdate("DELETE FROM albums where albumId = "+albumId+";");
    }

    Statement statement;

    {
        try {
            statement = DbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ArtistId(int artistId, int updatedArtistId) throws SQLException {
        statement.executeQuery("update artists set artistId = "+updatedArtistId+" where artistId = "+artistId+";");
    }
    public void ArtistName(int artistId, String updatedName) throws SQLException {
        statement.executeQuery("update artists set name = '"+updatedName+"' where artistid = "+artistId+";");
    }
    public void ArtistIsSolo(int artistId, boolean updatedIsSolo) throws SQLException {
        statement.executeQuery("update artists set isSolo = "+(updatedIsSolo?1:0)+" where artistid = "+artistId+";");
    }

    public void AlbumId(int albumId, int updatedAlbumId) throws SQLException {
        statement.executeQuery("update albums set albumid = "+updatedAlbumId+" where albumid = "+albumId+";");
    }
    public void AlbumTitle(int albumsId, String updatedTitle) throws SQLException {
        statement.executeQuery("update albums set title = '"+updatedTitle+"' where albumid = "+albumsId+";");
    }
    public void AlbumDate(int albumID, String updatedDate) throws SQLException {
        statement.executeQuery("update albums set date = '"+updatedDate+"' where albumid = "+albumID+";");
    }
    public void AlbumGenre(int albumid, String updatedGenre) throws SQLException {
        statement.executeQuery("update albums set genre = '"+updatedGenre+"' where albumid = "+albumid+";");
    }
    public void AlbumArtistId(int albumid, int updatedArtistId) throws SQLException {
        statement.executeQuery("update albums set artistid = "+updatedArtistId+" where albumid = "+albumid+";");
    }

    public void EventId(int eventid, int updatedEventId) throws SQLException {
        statement.executeQuery("update events set eventid = "+updatedEventId+" where albumid = "+eventid+";");
    }
    public void EventName(int eventid, String updatedEventName) throws SQLException {
        statement.executeQuery("update events set name = '"+updatedEventName+"' where albumid = "+eventid+";");
    }
    public void EventDate(int eventid, String updatedDate) throws SQLException {
        statement.executeQuery("update events set date = '"+updatedDate+"' where albumid = "+eventid+";");
    }
    public void EventOrganizer(int eventid, String updatedOrganizer) throws SQLException {
        statement.executeQuery("update events set organizer = '"+updatedOrganizer+"' where albumid = "+eventid+";");
    }
    public void EventArtistId(int eventid, int updatedEventArtistId) throws SQLException {
        statement.executeQuery("update events set artistid = "+updatedEventArtistId+" where albumid = "+eventid+";");
    }

    public void TrackId(int trackid, int updatedTrackId) throws SQLException {
        statement.executeQuery("update tracks set trackid = "+updatedTrackId+" where albumid = "+trackid+";");
    }
    public void TrackTitle(int tracksId, String updatedTrackTitle) throws SQLException {
        statement.executeQuery("update tracks set title = '"+updatedTrackTitle+"' where albumid = "+tracksId+";");
    }
    public void TrackDurationInSeconds(int trackid, int updatedTrackDurationInSeconds) throws SQLException {
        statement.executeQuery("update tracks set durationSeconds = "+updatedTrackDurationInSeconds+" where albumid = "+trackid+";");
    }
    public void TrackGenre(int trackid, String updatedTrackGenre) throws SQLException {
        statement.executeQuery("update tracks set genre  = '"+updatedTrackGenre+"' where albumid = "+trackid+";");
    }
    public void TrackAlbumId(int trackid, int updatedTrackAlbumId) throws SQLException {
        statement.executeQuery("update tracks set albumid = "+updatedTrackAlbumId+" where albumid = "+trackid+";");
    }
    public void TrackArtistId(int  trackid, int updatedTrackArtistId) throws SQLException {
        statement.executeQuery("update tracks set artistid = "+updatedTrackArtistId+" where albumid = "+trackid+";");
    }

    public void RoyaltyId(int royaltyid, int updatedRoyaltyId) throws SQLException {
        statement.executeQuery("update royalties set royaltyid = "+updatedRoyaltyId+" where royaltyid = "+royaltyid+";");
    }
    public void RoyaltyTrackId(int royaltyid, int updatedRoyaltyTrackId) throws SQLException {
        statement.executeQuery("update royalties set trackid ="+updatedRoyaltyTrackId+" where royaltyid = "+royaltyid+";");
    }
    public void RoyaltyEventId(int royaltyid, int updatedRoyaltyEventId) throws SQLException {
        statement.executeQuery("update royalties set eventid = "+updatedRoyaltyEventId+" where royaltyid = "+royaltyid+";");
    }
    public void RoyaltySalesAmount(int royaltyid, double updatedRoyaltySalesAmount) throws SQLException {
        statement.executeQuery("update royalties set salesamount = "+updatedRoyaltySalesAmount+" where royaltyid = "+royaltyid+";");
    }
    public void RoyaltyStreamCount(int  royaltyid, int updatedRoyaltyStreamCount) throws SQLException {
        statement.executeQuery("update royalties set streamcount = "+updatedRoyaltyStreamCount+" where royaltyid = "+royaltyid+";");
    }
    public void RoyaltyAmount(int royaltyid, double updatedRoyaltyAmount) throws SQLException {
        statement.executeQuery("update royalties set amount = "+updatedRoyaltyAmount+" where royaltyid = "+royaltyid+";");
    }

}
