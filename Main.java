import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.File;
import java.io.PrintStream;

/**
 * Main for demonstrating the MusicTrack class.
 *
 * @author Hwansu Kim (Billy)
 * @version 03/13/2022
 */
public class Main {
    public static void main(String[] args) {
        System.out.print('\u000c');

        // Instantiating array lists of MusicTrack objects //
        ArrayList<MusicTrack> favoriteList = new ArrayList<MusicTrack>();
        ArrayList<MusicTrack> friendsList = new ArrayList<MusicTrack>();
        ArrayList<MusicTrack> partyList = new ArrayList<MusicTrack>();

        // Instatiating MusicTrack objects //
        MusicTrack track1 = new MusicTrack("BRADIO", "Flyers");
        MusicTrack track2 = new MusicTrack("湘南乃風", "Grand Blue");
        MusicTrack track3 = new MusicTrack("SPYAIR", "I Wanna Be...");
        MusicTrack track4 = new MusicTrack("ALI feat. AKLO", "LOST IN PARADISE");
        MusicTrack track5 = new MusicTrack("SPYAIR", "サクラミツツキ");
        MusicTrack track6 = new MusicTrack("Daoko", "BANG!");
        MusicTrack track7 = new MusicTrack("BIGBANG", "뱅뱅뱅");
        MusicTrack track8 = new MusicTrack("DJみそしるとMCごはん", "エプロンボーイ");
        MusicTrack track9 = new MusicTrack("sumika", "フィクション");
        MusicTrack track10 = new MusicTrack("2NE1", "Happy");
        MusicTrack track11 = new MusicTrack("THE ORAL CIGARETTES", "狂乱 Hey Kids!!");

        // Adding five MusicTracks to favorite's list //
        favoriteList.add(track2);
        favoriteList.add(track3);
        favoriteList.add(track6);
        favoriteList.add(track8);
        favoriteList.add(track9);
        
        // Adding six MusicTracks to friend's list //
        friendsList.add(track1);
        friendsList.add(track4);
        friendsList.add(track5);
        friendsList.add(track7);
        friendsList.add(track10);
        friendsList.add(track11);

        // Removing the second track from friend's list //
        friendsList.remove(1);

        // Adding both favorite and friend's list to party list //
        partyList.addAll(favoriteList);
        partyList.addAll(friendsList);

        // Generating a random track order for the party list //
        Random randomNum = new Random();
        for (MusicTrack oneTrack : partyList) {
            oneTrack.setTrackOrder(randomNum.nextInt(100) + 1);
            // oneTrack.setSortOrder(MusicTrack.SortOrder.TRACK_ORDER);
        }
        
        // Sorting the party list by track order //
        Collections.sort(partyList);

        // Writing the party list out to a file //
        try {
            File trackFile = new File("PlayList.txt");
            PrintStream trackFileOut = new PrintStream(trackFile);

            trackFileOut.println("--------------");
            trackFileOut.println("Party Playlist");
            trackFileOut.println("--------------");
            for (int listIndex = 0; listIndex < partyList.size(); listIndex++) {
                partyList.get(listIndex).setTrackOrder(listIndex + 1);
                trackFileOut.println(partyList.get(listIndex));
            }
            
            trackFileOut.close();
            System.out.println("See the file PlayList.txt for results.");
        } catch (Exception e) {
            System.out.println("The file could not be created.");
        }
    }
}
