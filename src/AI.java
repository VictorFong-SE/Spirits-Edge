//Tim Czepizak tczepi2
//Code for CS342 Homework
//Victor Fong vfong3
//Martin Bragiel mbragi2
//Professor Bell
//Class : AI
//This AI is very simple and just does a random move
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class AI implements DecisionMaker {
    private Random rand = new Random();
    private static List<DirType>  VALUES = Collections.unmodifiableList(Arrays.asList(DirType.values()));
    private static int size = VALUES.size();

    public Move getMove(Animal animal, Place place){return null;};
    @Override
    public Move getMove(Character c, Place p) {
        int randNum = rand.nextInt(1) + 1;
        switch(randNum){
            case 1: {      //Go
                //System.out.println(VALUES.get(rand.nextInt(getMobility)).toString());
                return new Move(MoveType.GO, VALUES.get(rand.nextInt(size)).toString());
            }
            case 2: {  //Use
                int r = rand.nextInt(c.artifacts.size()) + 1;
                return new Move(MoveType.USE, c.artifacts.get(r).toString());
            }
            case 3: { //drop
                int r = rand.nextInt(c.artifacts.size()) + 1;
                return new Move(MoveType.DROP, c.artifacts.get(r).toString());
            }
            case 4 :{ //get
                int r = rand.nextInt(p.artifacts.size()) + 1;
                return new Move(MoveType.GET, p.artifacts.get(r).toString());
            }
        }
        return null;
    }
    //public Move getMove(Character c, Place panel){return null;}
}
