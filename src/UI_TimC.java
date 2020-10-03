//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3

//Code for CS342 Homework
//Professor Bell
//Class : UI_TimC
//This Class implements the User Interface of the program for each player. Created by Tim

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.util.Scanner;

public class UI_TimC extends UI implements ActionListener {
    JPanel p = new JPanel();
    JButton nButton = new JButton("N"); //1
    JButton sButton = new JButton("S"); //2
    JButton eButton = new JButton("E"); //3
    JButton wButton = new JButton("W"); //4
    JButton nEButton = new JButton("NE");
    JButton sEButton = new JButton("SE");
    JButton eSEButton = new JButton("ESE");
    JButton wSWButton = new JButton("WSW");
    JButton nWButton = new JButton("NW");
    JButton sWButton = new JButton("SW");
    JButton nNEButton = new JButton("NNE");
    JButton nNWButton = new JButton("NNW");
    JButton sSEButton = new JButton("SSE");
    JButton sSWButton = new JButton("SSW");
    JButton wNWButton = new JButton("WNW");
    JButton eNEButton = new JButton("ENE");
    JButton quitButton = new JButton("QUIT");
    JButton invButton = new JButton("INV");
    JButton lookButton = new JButton("LOOK");
    JButton getButton = new JButton("GET"); // 20
    JButton useButton = new JButton("USE");
    JButton dropButton = new JButton("DROP");//22
    JTextArea textArea = new JTextArea(5,20);
    JTextField getTextField = new JTextField();
    JTextField dropTextField = new JTextField();
    JTextField useTextField = new JTextField();
    JButton quitGame = new JButton("QUIT GAME");

    private boolean boolMove = false;
    private Move move = new Move(null, null);
    private int first = 0;

    @Override
    public Move getMove(Character c, Place p){
        Place currentPlace = p;
        if (currentPlace.isExit())
            System.exit(1);




        currentPlace.display();
        if(first == 0) {
            textArea.append(p.getPlaceName()+ "\n");
            textArea.append(p.getPlaceDescription());
            first = 1;

            if(p.artifactCounter >= 1){
                textArea.append("\nFurthermore, you see the following items within the room:");
                for (Artifact artifact : p.artifacts){
                    textArea.append(artifact.getName() + ": " + artifact.getDescription());
                }
            }
        }

        while(boolMove == false){
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
        textArea.setText("");
        if(move.getMoveType() != null) {



            if (move.getMoveType().toStrings() == "inventory") {
                for (int i = 0; i < c.artifacts.size(); i++) {
                    textArea.append("\nName" + c.artifacts.get(i).getName());
                    textArea.append("\nDescription" + c.artifacts.get(i).getDescription());
                    textArea.append("\nValue" + c.artifacts.get(i).getValue());
                    textArea.append("\nMobility" + c.artifacts.get(i).getMobility());
                    textArea.append("\nKeypattern" + c.artifacts.get(i).getKeyPattern() + "\n");
                }
            }
            else if (move.getMoveType().toStrings() == "get") {
                if(p.artifacts.contains(move.getString())) {


                    textArea.append("===========================================" +
                            "You got the " + move.getString() + "!" +
                            "===========================================");

                }
            }
            else if(move.getMoveType().toStrings() == "quit"){
                textArea.append("Thanks For Playing");
               c.active = 2;
            }
            else {
                textArea.append(p.getPlaceName()+ "\n");
                textArea.append(p.getPlaceDescription());
                if(p.artifactCounter >= 1){
                    textArea.append("\nFurthermore, you see the following items within the room:");
                    for (Artifact artifact : p.artifacts){
                        textArea.append(artifact.getName() + ": " + artifact.getDescription());
                    }
                }
            }
        }

        boolMove = false;

        Move nextMove = move;
        move = new Move(null,null);
        return nextMove;

    }
    /*
        public Move isAction(String string){
            if("N".equals(string)){

            }
            else if("S".equals(string)){

            }
            else if("E".equals(string)){

            }
            else if("W".equals(string)){

            }
            else if("NE".equals(string)){

            }
            else if("SE".equals(string)){

            }
            else if("ESE".equals(string)){

            }
            else if("WSW".equals(string)){

            }
            else if("NW".equals(string)){

            }
            else if("SW".equals(string)){

            }
            else if("NNE".equals(string)){

            }
            else if("NNW".equals(string)){

            }
            else if("SSE".equals(string)){

            }
            else if("SSW".equals(string)){

            }
            else if("WNW".equals(string)){

            }
            else if("ENE".equals(string)){

            }
            else if("quit".equals(string)){

            }
            else if("inv".equals(string)){

            }
            else if("look".equals(string)){

            }
            else if("get".equals(string)){

            }
            else if("use".equals(string)){

            }
            else if("drop".equals(string)){

            }
        }
    */
    public void actionPerformed(ActionEvent e){
        if("N".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "N");
        }
        else if("S".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "S");
        }
        else if("E".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "E");
        }
        else if("W".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "W");
        }
        else if("NE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "NE");
        }
        else if("SE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "SE");
        }
        else if("ESE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "ESE");
        }
        else if("WSW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "WSW");
        }
        else if("NW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "NW");
        }
        else if("SW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "SW");
        }
        else if("NNE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "NNE");
        }
        else if("NNW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "NNW");
        }
        else if("SSE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "SSE");
        }
        else if("SSW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "SSW");
        }
        else if("WNW".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "WNW");
        }
        else if("ENE".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GO, "ENE");
        }
        else if("quit".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.QUIT, "quit");
        }
        else if("inv".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.INVENTORY, "inv");
        }
        else if("look".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.LOOK, "look");
        }
        else if("get".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.GET, getTextField.getText());
        }
        else if("use".equals(e.getActionCommand())){
            boolMove = true;

            move = new Move(MoveType.USE, useTextField.getText());
        }
        else if("drop".equals(e.getActionCommand())){
            boolMove = true;
            move = new Move(MoveType.DROP, dropTextField.getText());
        }
        else if("quitgame".equals((e.getActionCommand()))){
            System.exit(1);
        }
    }


    public UI_TimC (){
        super();
        textArea.setBounds(0,0,480,200);
        textArea.setLineWrap(true);

        getTextField.setBounds(590,220,180,25);
        dropTextField.setBounds(590,270,180,25);
        useTextField.setBounds(590,245,180,25);



        quitGame.setBounds(580,25,150,25);
        nButton.setBounds(0,220,75,25);
        sButton.setBounds(75,220,75,25);
        eButton.setBounds(150,220,75,25);
        wButton.setBounds(225,220,75,25);
        nEButton.setBounds(0,245,75,25);
        sEButton.setBounds(75,245,75,25);
        eSEButton.setBounds(150,270,75,25);
        wSWButton.setBounds(225,270,75,25);
        nWButton.setBounds(0,270,75,25);
        sWButton.setBounds(75  ,270,75,25);
        nNEButton.setBounds(0,295,75,25);
        nNWButton.setBounds(0,320,75,25);
        sSEButton.setBounds(75,320,75,25);
        sSWButton.setBounds(75,295,75,25);
        wNWButton.setBounds(225,245,75,25);
        eNEButton.setBounds(150,245,75,25);
        quitButton.setBounds(550,50,300,60);
        invButton.setBounds(300,220,75,25);
        lookButton.setBounds(300,245,75,25);
        getButton.setBounds(480,220,100,25);
        useButton.setBounds(480,245,100 ,25);
        dropButton.setBounds(480,270,100,25);

/*
        buttonNorth
        buttonSouth
        buttonEast
        buttonWest
        buttonNorthEast
        buttonSouthEast
        buttonEastSouthEast
        buttonWestSouthWest
        buttonNorthWest
        buttonSouthWest
        buttonNorthNorthEast
        buttonNorthNorthWest
        buttonSouthSouthEast
        buttonSouthSouthWest
        buttonWestNorthWest
        buttonEastNorthEast
        buttonQuit
        buttonInventory
        buttonLook
        buttonGet
        buttonUse
        buttonDrop

        */
        quitGame.setActionCommand("quitgame");
        nButton.setActionCommand("N");
        sButton.setActionCommand("S");
        eButton.setActionCommand("E");
        wButton.setActionCommand("W");
        nEButton.setActionCommand("NE");
        sEButton.setActionCommand("SE");
        eSEButton.setActionCommand("ESE");
        wSWButton.setActionCommand("WSW");
        nWButton.setActionCommand("NW");
        sWButton.setActionCommand("SW");
        nNEButton.setActionCommand("NNE");
        nNWButton.setActionCommand("NNW");
        sSEButton.setActionCommand("SSE");
        sSWButton.setActionCommand("SSW");
        wNWButton.setActionCommand("WNW");
        eNEButton.setActionCommand("ENE");
        quitButton.setActionCommand("quit");
        invButton.setActionCommand("inv");
        lookButton.setActionCommand("look");
        getButton.setActionCommand("get");
        useButton.setActionCommand("use");
        dropButton.setActionCommand("drop");


        quitGame.addActionListener(this);
        nButton.addActionListener(this);
        sButton.addActionListener(this);
        eButton.addActionListener(this);
        wButton.addActionListener(this);
        nEButton.addActionListener(this);
        sEButton.addActionListener(this);
        eSEButton.addActionListener(this);
        wSWButton.addActionListener(this);
        nWButton.addActionListener(this);
        sWButton.addActionListener(this);
        nNEButton.addActionListener(this);
        nNWButton.addActionListener(this);
        sSEButton.addActionListener(this);
        sSWButton.addActionListener(this);
        wNWButton.addActionListener(this);
        eNEButton.addActionListener(this);
        quitButton.addActionListener(this);
        invButton.addActionListener(this);
        lookButton.addActionListener(this);
        getButton.addActionListener(this);
        useButton.addActionListener(this);
        dropButton.addActionListener(this);



        p.setLayout(null);

        p.add(quitGame);
        p.add(nButton);
        p.add(sButton);
        p.add(eButton);
        p.add(wButton);
        p.add(nEButton);
        p.add(sEButton);
        p.add(eSEButton);
        p.add(wSWButton);
        p.add(nWButton);
        p.add(sWButton);
        p.add(nNEButton);
        p.add(nNWButton);
        p.add(sSEButton);
        p.add(sSWButton);
        p.add(wNWButton);
        p.add(eNEButton);
        p.add(quitButton);
        p.add(invButton);
        p.add(lookButton);
        p.add(getButton);
        p.add(useButton);
        p.add(dropButton);
        p.add(textArea);
        p.add(getTextField);
        p.add(dropTextField);
        p.add(useTextField);

        add(p);


        setSize(900,400);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // panel.setLayout(new GridLayout(9,8));
       /* buttonNorth.setLocation(100,1);
        buttonSouth.setLocation(2,2);
        buttonEast.setLocation(3,3);
        buttonWest.setLocation(4,4);
        */

        setVisible(true);



    }





}