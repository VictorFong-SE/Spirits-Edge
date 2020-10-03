//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Code for CS342 Homework
//Martin Bragiel mbragi2
//Professor Bell
//Class : DarkRoom
//This creates a dark room that teleports people
import java.util.*;

//This is a dark room... you cannot see anything when you walk in. You don't know where the exits are or if there is an artifact

public class DarkRoom extends Place {
    private Place p;
    private Random rand;

    public DarkRoom(Place p){

    }

    public DarkRoom(int ID, String placeName, String placeDescription, int darkness) {
        super(ID, placeName, placeDescription, darkness);
    }

    public Place Teleport() {
        return p.randomPlace();
    }
}
