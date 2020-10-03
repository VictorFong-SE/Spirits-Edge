//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : MoveType(Enum)
//Enum for all available moves
public enum MoveType {

    //These are the move available currently
    LOOK("look", null),
    EXIT("exit", null),
    QUIT("quit", null),
    INVENTORY("inventory", "inve"),
    GO("go", null),
    USE("use",null),
    DROP("drop",null),
    GET("get",null),
    NO("No", "no");

    private String text;
    private String abbreviation;

    MoveType(String t, String s) {
        this.text = t;
        this.abbreviation = s;
    }
        public String toStrings(){
            return this.text;
        }
        //matches enum with string
        public boolean match(String s){
            if(s.equalsIgnoreCase(text) || s.equalsIgnoreCase(abbreviation))
                return true;
            else
                return false;
        }
}
