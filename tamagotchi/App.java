package com.tamagotchi;

public class App {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();

        tamagotchi.newGame();
        while(true){
            tamagotchi.userAction();
        }
    }
}
