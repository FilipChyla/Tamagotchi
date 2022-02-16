package com.tamagotchi;

import com.tamagotchi.animals.AnimalType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleBasedAnimalProvider implements AnimalProvider{
    private final Scanner userInput = new Scanner(System.in);

    private static List<AnimalType> SUPPORTED_TYPES = List.of(AnimalType.values());

    @Override
    public AnimalDto getAnimal() {
        String animalClass;
        String animalName;

        System.out.println("Hi! What is your animal name?: ");
        animalName = userInput.nextLine();

        System.out.println("What animal would you like to adopt?");
        do {
            System.out.println(Arrays.toString(AnimalType.values()));
            animalClass = getAnimalClass().orElseGet(() -> {
                System.err.println("Wrong animal, choose again");
                return null;
            });
        } while (animalClass == null);

        return new AnimalDto(animalName, animalClass);
    }

    private Optional<String> getAnimalClass() {
        String animalClass = userInput.nextLine();
        String toLowerCase = animalClass.toLowerCase();
        boolean typeIsSupported = SUPPORTED_TYPES.stream().anyMatch(supportedType -> supportedType.name().toLowerCase().equals(toLowerCase));
        if (typeIsSupported) {
            return Optional.of(toLowerCase);
        }
        return Optional.empty();
    }
}
