package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RequestMapping
@Controller
public class AnimalController {

   AnimalsDatabase animalsDatabase;

   public AnimalController(AnimalsDatabase animalsDatabase){
       this.animalsDatabase = animalsDatabase;
   }

        @RequestMapping("/new")
        public String showAnimals(Model model, @RequestParam(required = false, defaultValue = "") String searchCategory){

            Set<Map.Entry<Integer,Animal>> entries = animalsDatabase.animalHashMap.entrySet();

            Set<Map.Entry<Integer,Animal>> filtr = new HashSet<>();
            for (Map.Entry<Integer, Animal> entry : entries) {
                if (searchCategory.equals("")){
                    filtr.add(entry);
                } else if (searchCategory.equals(entry.getValue().getCategory())){
                    filtr.add(entry);
                }
            }

            model.addAttribute("allAnimals" , filtr);

            return "animals";
        }

    @RequestMapping("/animal")
    public String showAnimal(@RequestParam Integer id, Model model){

       model.addAttribute("animalOne" ,animalsDatabase.animalHashMap.get(id));
       model.addAttribute("animalID",id);
       return "animala";
    }


    @RequestMapping("/addAnimalForm")
    public String addAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "addAnimalForm";
    }

    @PostMapping("/add")
    public String add(Animal animal) throws IOException {
       animalsDatabase.addAnimalToDB(animal);
       return "redirect:/new";
    }



}
