//Tim Czepizak tczepi2
//Code for CS342 Homework
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Professor Bell
//Class : Animal
//This creates an Animal Character

public class Animal extends NPC {
    private static int fecalAmount;
    private Place currentPlaceAnimal;
    private int IDAnimal;
    private String nameAnimal;
    private String descriptionAnimal;

    public Animal(Character character) {

        currentPlaceAnimal = character.currentPlace;
        IDAnimal = character.ID;
        nameAnimal = character.name;
        descriptionAnimal = character.description;

    }

    @Override
    public void makeMove(Move move) {
        switch (move.getMoveType()) {
            case GO: {
              //  System.out.println("Im Poooooooping");
                currentPlaceAnimal = this.currentPlaceAnimal.followDirection(move.getString(), this);
                return;
            }
            case DROP: {
                if (fecalAmount > 2) {
                    System.out.println("the" + this.nameAnimal + " is poooooooping");
                    fecalAmount = 0;
                    currentPlaceAnimal.artifacts.add(new Feces("wet poop", "Large pile of wet poop", 12, 1, 0, 303));
                } else {
                    System.out.println("the" + this.nameAnimal + " is preparing");
                    fecalAmount++;
                    return;
                }
            }
        }
    }
}
