package com.example.codeclan.demo.components;


import com.example.codeclan.demo.models.File;
import com.example.codeclan.demo.models.Folder;
import com.example.codeclan.demo.models.User;
import com.example.codeclan.demo.repositories.FileRepository;
import com.example.codeclan.demo.repositories.FolderRepository;
import com.example.codeclan.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User bekah = new User("Bekah");
        userRepository.save(bekah);

        User adam = new User("Adam");
        userRepository.save(adam);

        Folder money = new Folder("Money", adam);
        folderRepository.save(money);

        Folder house = new Folder("House Stuff", bekah);

        File spending = new File("Spending Tracker", "xlsx", "354Kb", money);
        fileRepository.save(spending);

        File budget = new File("March Budget", "xlsx", "2Mb", money);
        fileRepository.save(budget);

        File decorations = new File("Decorating Ideas", "pages", "5Gb", house);
        fileRepository.save(decorations);

        File moodBoard = new File("Bedroom Paint Colours", "jpeg", "67Mb", house);
        fileRepository.save(moodBoard);
    }
}
