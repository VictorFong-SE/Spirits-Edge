//Tim Czepizak tczepi2
//Victor Fong vfong3

//Code for CS342 Homework
//Martin Bragiel mbragi2
//Professor Bell
//Class : Feces
//This creates an important task unless your backed up
public class Feces extends Artifact {
    private int ID;
    private String name;
    private String description;
    private int value;
    private int mobility;
    private int keyPattern;

    public Feces(String n, String d, int v, int m, int k, int i){
        name = n;
        description = d;
        value = v;
        mobility = m;
        keyPattern = k;
        ID = i;
    }
}
