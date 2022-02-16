package com.tamagotchi;

public class App {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi(new ConsoleBasedAnimalProvider(), new AnimalFactory());
        tamagotchi.newGame();
        while(true){
            tamagotchi.userAction();
        }
    }
}
