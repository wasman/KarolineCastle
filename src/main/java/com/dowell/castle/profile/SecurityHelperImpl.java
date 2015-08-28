package com.dowell.castle.profile;

public class SecurityHelperImpl implements SecurityHelper {

    @Override
    //local code review (vtegza): should return hash for the password @ 28.08.15
    public String getSecurePassword(String password) {
        return password;
    }
}
