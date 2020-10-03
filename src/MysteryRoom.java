//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Martin Bragiel mbragi2
//Professor Bell
//Class : Mystery Room
//This creates a Place that deletes your inventory :(

public class MysteryRoom extends Place {



    public MysteryRoom(Place p){

    }
    public MysteryRoom(int ID, String placeName, String placeDescription, int darkness) {
        super(ID, placeName, placeDescription, darkness);
    }

    public void deleteInv(Character c) {   c.artifacts.clear();
    }
}
