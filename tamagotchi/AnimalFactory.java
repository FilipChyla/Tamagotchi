package com.tamagotchi;


import com.tamagotchi.animals.Animal;
import com.tamagotchi.animals.Cat;
import com.tamagotchi.animals.Dog;
import com.tamagotchi.animals.Fox;

import java.util.Locale;

public class AnimalFactory {
    public Animal createAnimal(AnimalProvider.AnimalDto animalDto) {
        switch (animalDto.type.toLowerCase(Locale.ROOT)) {
            case "cat" -> {
                return new Cat(animalDto.name);
            }
            case "dog" -> {
                return new Dog(animalDto.name);
            }
            case "fox" -> {
                return new Fox(animalDto.name);
            }
            default -> {
                throw new RuntimeException("Unsupported animal kind: " + animalDto.type);
            }
        }
    }
}
