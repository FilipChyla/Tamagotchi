package com.tamagotchi.animals;

public abstract class Animal{

    final String name;
    private int hunger = 50;
    private int energy = 50;
    private int happiness = 50;

    public Animal(String name) {
        this.name = name;
    }

     public abstract void speak();

    public void eat() {
        if (hunger > 80) {
            hunger = 100;
        } else {
            hunger += 20;
        }
        energy -= 10;
        happiness -= 10;
    }

    public void sleep() {
        if (energy > 80) {
            energy = 100;
        } else {
            energy += 20;
        }
        hunger -= 10;
        happiness -= 10;
    }

    public void play() {
        if (happiness > 80) {
            happiness = 100;
        } else {
            happiness += 20;
        }
        energy -= 10;
        hunger -= 10;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name +
                ", Hunger: " + hunger + "/100" +
                ", Energy: " + energy + "/100" +
                ", Happiness: " + happiness + "/100";
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHappiness() {
        return happiness;
    }

    public void getInfo(){
        System.out.println(this);
    }
}
