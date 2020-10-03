//Tim Czepizak tczepi2
//Code for CS342 Homework
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Professor Bell
//Class : AiAnimal
//This AI is very simple and just does a random move and daily activity

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AiAnimal extends AI {

    private Random rand = new Random();
    private static List<DirType> VALUES = Collections.unmodifiableList(Arrays.asList(DirType.values()));
    private static int size = VALUES.size();




    @Override
    public Move getMove(Animal animal, Place place){
        int randNum = rand.nextInt(2) + 1;
        switch(randNum){
            case 1: {      //Go*/
                //System.out.println(VALUES.get(rand.nextInt(getMobility)).toString());
                 //return new Move(MoveType.GO, "North");
                 return new Move(MoveType.GO, VALUES.get(rand.nextInt(size)).toString());
            }
            case 2: { //drop
                return new Move(MoveType.DROP, null);
            }
        }
        return null;
    }
}
