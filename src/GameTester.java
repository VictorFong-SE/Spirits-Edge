//Victor Fong vfong3
//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Code for CS342 Homework
//Professor Bell
//Class : GameTester
//This is the class that runs the program

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;



public class GameTester {

    public static void main(String[] args) throws FileNotFoundException
    {

        //GAME INSTANTIATION AND PLAY METHOD
        System.out.println("Tim Czepizak: tczepi2\n" +
                           "Martin Bragiel mbragi2\n" +
                           "Victor Fong: vfong3\n" +
                           "\n\n\n" +
                           "Welcome to the Spirit's Edge Dungeon Crawling Game!\n" +
                           "At any time feel free to use quit or exit to fully leave the game, or a valid direction " +
                           "to traverse the various rooms.\n" +
                           "The Valid directions are any of the 8 cardinal directions, or up(U) and down(D)\n\n");

        // Check if app is run with an argument for file
        String  gamePath;
        File    gameFile;
        Scanner keyboard = new Scanner(System.in);

        int numCharacters = 1;
        if (args.length >= 1)
        {
            gamePath = args[0];
            gameFile = new File(gamePath);

            //if (args.length == 2)
            //{
            //add characters from input
            //numCharacters = Integer.parseInt(args[1]);
            //}
        } else
        {
            System.out.println("Please enter the name of the gameMap you would Like to play!");
            gamePath = keyboard.nextLine();
            gameFile = new File(gamePath);

            while (!gameFile.exists())
            {
                System.err.println("Game name invalid. Try again!");
                gamePath = keyboard.nextLine();
                gameFile = new File(gamePath);
            }
        }
        Scanner gameScanner = null;

        try
        {
            gameScanner = new Scanner(gameFile);
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + gamePath);
            System.exit(-1);
        }

        //Create game
        Game game = new Game(gameScanner);

        gameScanner.close();

        //Start the game
        System.out.println("~~~Enjoy your quest!~~~\n");
        game.play();
    }
}
