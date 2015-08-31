package com.dowell.castle.game;

import com.dowell.castle.UserProfile;

public class GameViewImpl implements GameView {

    @Override
    public void startGame(UserProfile updatedUserProfile) {
        System.out.println("Paling as : " + updatedUserProfile.getCharacters().get(0));


    }
}
