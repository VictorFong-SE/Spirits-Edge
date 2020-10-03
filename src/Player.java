//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : Player
//THIS CLASS WAS NOT AT ALL USED BUT PROBABLY WILL HAVE TO BE IN THE FUTURE;
public class Player extends Character{


    public Player(Character c){

    }

    private void inventory(){
        //System.out.println("inventory");
        for(int i = 0; i < artifacts.size(); i++){
            artifacts.get(i).print();
        }
    }
    @Override
    public void makeMove(Move move ){
/*
        switch(move.getMoveType()){
            case GO:{
                this.currentPlace.followDirection(move.getString());
                return;
            }
            case EXIT: {
                System.exit(1);
            }
            case QUIT: {
                System.exit(1);
            }
            case INVENTORY:{
                this.inventory();
                return;
            }
            case LOOK:{
                this.currentPlace.printArt(currentPlace);
                return;
            }
            case DROP:{
                for (int k = 0; k < artifacts.getMobility(); k++) {                        //keyword drop
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString()))
                         artifacts.remove(k);
                }
                return;
            }
            case USE:{
                for (int k = 0; k < artifacts.getMobility(); k++) {                        //keyword Use
                    if (artifacts.get(k).getName().equalsIgnoreCase(move.getString())){

                    }
                }
                return;
            }
            case GET:{
                for (int k = 0; k < this.currentPlace.artifactsPlace.getMobility(); k++){
                    if(this.currentPlace.artifactsPlace.get(k).getName().equalsIgnoreCase(move.getString())){
                        artifacts.add(this.currentPlace.artifactsPlace.get(k));
                    }
                }
                return;
            }
        }
*/
    }

}

