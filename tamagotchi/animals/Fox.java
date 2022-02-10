package com.tamagotchi.animals;

public class Fox extends Animal{
    public Fox(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("What does the fox say?");
    }
}
