package com.tamagotchi;

public interface Menu {
    void save();
    void load();
    void newGame();
    boolean animalCreation(String animalClass,String animalName);
    void exit();
    void userAction();
    void options();
}
