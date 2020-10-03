//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : NPC
//THIS CLASS WAS NOT AT ALL USED BUT PROBABLY WILL HAVE TO BE IN THE FUTURE;
public class NPC extends Character{

    public NPC(){}

    public NPC(int id, String nam, String desc){
        ID = id;
        name = nam;
        description = desc;
    }

    @Override
    public void makeMove(Move move) {
        switch (move.getMoveType()) {
            case GO: {
                currentPlace = this.currentPlace.followDirection(move.getString(), this);
                return;
            }
            case DROP: {
                for (int k = 0; k < artifacts.size(); k++) {                        //keyword drop
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString()))
                        artifacts.remove(k);
                }
                return;
            }
            case USE: {
                for (int k = 0; k < artifacts.size(); k++) {                        //keyword Use
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString())) {
                        artifacts.get(k).use(this, currentPlace);
                    }
                }
                return;
            }
            case GET: {
                for (int k = 0; k < this.currentPlace.artifacts.size(); k++) {
                    if (this.currentPlace.artifacts.get(k).getName().equalsIgnoreCase(move.getString())) {
                        this.artifacts.add(this.currentPlace.artifacts.get(k));
                        currentPlace.artifacts.remove(k);
                    }
                }
                return;
            }
        }
    }

}
