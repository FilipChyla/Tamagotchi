package com.tamagotchi;

public interface AnimalProvider {
    AnimalDto getAnimal();

    class AnimalDto{
        String name;
        String type;
        public AnimalDto(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }
}
