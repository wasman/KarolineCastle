package com.dowell.castle.registration;

import com.dowell.castle.CharacterType;
import com.dowell.castle.ConsoleUtil;

public class RegistrationViewImpl implements RegistrationView {


    @Override
    public CharacterType getCharacterType() {
        String type = ConsoleUtil.promptUserInput("Please select character type: 1:" + CharacterType.ELF + " or 2:" + CharacterType.DORF);
        switch (type){
            case "1":
                return CharacterType.ELF;
            default:
            case "2":
                return CharacterType.DORF;
        }
    }

    @Override
    public String getCharacterName() {
        return ConsoleUtil.promptUserInput("Character Name: ");
    }

    @Override
    public String getPassword() {
        return ConsoleUtil.promptSecureUserInput("Please enter you password");
    }

    @Override
    public String getUserName() {
        return ConsoleUtil.promptUserInput("User Name: ");
    }
}
