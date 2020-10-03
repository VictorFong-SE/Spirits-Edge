//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : Move
//Very simple move object that makes it easier to make moves
public class Move {



    private MoveType type;
    private String argument;
    public Move(MoveType mt,String s){
        type = mt;
        argument = s;
    }


    public String getString(){return argument;}
    public MoveType getMoveType(){return type;}

}
