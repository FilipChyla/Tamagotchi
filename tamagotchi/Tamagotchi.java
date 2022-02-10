package com.tamagotchi;

import com.tamagotchi.animals.*;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Tamagotchi implements Menu {
    private final String FILE_NAME = "src/com/tamagotchi/saveFile.txt";
    private Animal animal;
    private final Scanner userInput = new Scanner(System.in);

    @Override
    public void newGame() {

        String animalClass, animalName;

        System.out.println("Hi! What is your animal name?: ");
        animalName = userInput.nextLine();

        System.out.println("What animal would you like to adopt?");
        do {
            System.out.println(Arrays.toString(AnimalList.values()));
            animalClass = userInput.nextLine();
        } while (animalCreation(animalClass, animalName));

    }

    @Override
    public boolean animalCreation(String animalClass, String animalName) {
        switch (animalClass.toLowerCase(Locale.ROOT)) {
            case "cat" -> {
                animal = new Cat(animalName);
                return false;
            }
            case "dog" -> {
                animal = new Dog(animalName);
                return false;
            }
            case "fox" -> {
                animal = new Fox(animalName);
                return false;
            }
            default -> {
                System.err.println("Wrong animal, choose again");
                return true;
            }
        }
    }

    @Override
    public void userAction() {
        int userChoice = 0;
        boolean isCorrect = false;

        System.out.println();
        animal.getInfo();
        System.out.println("Which action would you like to perform: ");
        System.out.println("""
                1. Eat
                2. Sleep
                3. Play
                4. Speak
                5. Open options""");
        while (!isCorrect) {
            try {
                userChoice = Integer.parseInt(userInput.nextLine());

            } catch (Exception ignored) {
            } finally {
                if (userChoice > 0 && userChoice < 6) {
                    isCorrect = true;
                } else {
                    System.err.println("Wrong input!");
                }
            }
        }
        switch (userChoice) {
            case 1 -> animal.eat();
            case 2 -> animal.sleep();
            case 3 -> animal.play();
            case 4 -> animal.speak();
            case 5 -> this.options();
            default -> {
            }
        }

    }

    @Override
    public void options() {
        int userChoice = 0;
        boolean isCorrect = false;

        System.out.println("""
                1. Save
                2. Load
                3. New game
                4. Exit
                5. Go back""");

        while (!isCorrect) {
            try {
                userChoice = Integer.parseInt(userInput.nextLine());
            } catch (Exception ignored) {
            } finally {
                if (userChoice > 0 && userChoice < 6) {
                    isCorrect = true;
                } else {
                    System.err.println("Wrong input!");
                }
            }
        }
        switch (userChoice) {
            case 1 -> this.save();
            case 2 -> this.load();
            case 3 -> this.newGame();
            case 4 -> this.exit();
            case 5 -> this.userAction();
            default -> {
            }
        }
    }

    @Override
    public void save() {
        String className = animal.getClass().getSimpleName();
        String saveString = className + "\n" +
                animal.getName() + "\n" +
                animal.getHunger() + "\n" +
                animal.getHappiness() + "\n" +
                animal.getEnergy();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(saveString);
            writer.close();
        } catch (Exception e) {
            System.err.println("Something went wrong");
        }
    }

    @Override
    public void load() {
        String animalClass, animalName;
        int hunger, happiness, energy;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            animalClass = reader.readLine();
            animalName = reader.readLine();
            hunger = Integer.parseInt(reader.readLine());
            happiness = Integer.parseInt(reader.readLine());
            energy = Integer.parseInt(reader.readLine());

            animalCreation(animalClass, animalName);
            animal.setHunger(hunger);
            animal.setHappiness(happiness);
            animal.setEnergy(energy);

        } catch (IOException e) {
            System.err.println("There is no save file");
        }
        catch (NumberFormatException e){
            System.err.println("Save file doesn't have enough information");
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
