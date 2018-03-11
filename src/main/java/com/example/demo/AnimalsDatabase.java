package com.example.demo;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class AnimalsDatabase {

    HashMap<Integer, Animal> animalHashMap;

    public AnimalsDatabase() throws IOException {

        FileReader fr = new FileReader("src/main/resources/animals.csv");
        BufferedReader bfr = new BufferedReader(fr);

        animalHashMap = new HashMap<>();

        String line = null;
        int keyMap = 0;

        while ((line = bfr.readLine()) != null) {
            String[] temp = line.split(";");
            animalHashMap.put(keyMap, new Animal(temp[0],temp[1], temp[2]));
            keyMap++;
        }
    }

    public HashMap<Integer, Animal> getAnimalHashMap() {
        return animalHashMap;
    }

    public void addAnimalToDB(Animal animal) throws IOException {

        int newKey = animalHashMap.size();
        animalHashMap.put(newKey, animal);
        saveFile();

    }

    public void saveFile() throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/animals.csv", false);
        BufferedWriter bfw = new BufferedWriter(fw);

        for (int i = 0; i < animalHashMap.size(); i++) {
            String newAnimal = animalHashMap.get(i).getName() + ";" +
                    animalHashMap.get(i).getCategory() + ";" +
                    animalHashMap.get(i).getPicture();
            bfw.write(newAnimal);
            bfw.newLine();
        }
        bfw.close();
    }

}
