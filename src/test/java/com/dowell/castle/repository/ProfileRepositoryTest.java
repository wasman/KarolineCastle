package com.dowell.castle.repository;

import com.dowell.castle.ActionCell;
import com.dowell.castle.Position;
import com.dowell.castle.UserProfile;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import org.junit.Test;

public class ProfileRepositoryTest {

    @Test
    public void testSaveUserProfile() throws Exception {
        // initialize variable inputs
        ActionCell cell = new ActionCell.Builder()
                .build();
//        ActionCell[][] map = new ActionCell[10][10];
//        map[3][6] = cell;
        Position position = new Position(3,4);
        WordMap map = new WordMapImpl.Builder()
                .addCell(position, cell)
                .build();
        UserProfile inputValue = new UserProfile.Builder()
                .build();

        // initialize mocks

        // initialize class to test
        ProfileRepository testClass = new ProfileRepositoryImpl();

        // invoke method on class to test
        testClass.save(inputValue);

        // assert return value

        // verify mock expectations
    }


}
