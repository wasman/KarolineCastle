package com.dowell.castle.repository;

import com.dowell.castle.UserProfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProfileRepositoryImpl implements ProfileRepository {

    @Override
    public void save(UserProfile profile) {
        try {
            Path filePath = Paths.get("./data/" + profile.getUserName() + ".ser");
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            FileOutputStream fileOut = new FileOutputStream(filePath.toString());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(profile);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserProfile get(String userName, String securePassword) {
        Path filePath = Paths.get("./data/" + userName + ".ser");
        try {
            FileInputStream fileIn = new FileInputStream(filePath.toString());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            UserProfile profile = (UserProfile) in.readObject();
            return profile;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(UserProfile newUserProfile) {
        System.out.println("User profile is create (suppose) + " + newUserProfile);
        try {
            Path filePath = Paths.get("./data/" + newUserProfile.getUserName() + ".ser");
            FileOutputStream fileOut = new FileOutputStream(filePath.toString());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(newUserProfile);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
