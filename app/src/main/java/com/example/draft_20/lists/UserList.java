package com.example.draft_20.lists;

/*
    A singleton class which creates a list of users.
 */

import android.content.Context;

import com.example.draft_20.entities.UserEntity;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList sUserLab;
    private Context mAppContext;
    private ArrayList<UserEntity> mUsers;

    private UserList(Context appContext){
        mAppContext = appContext;
        mUsers = new ArrayList<>();

        generateFakeUsers();
    }

    private void generateFakeUsers(){
        for(int i = 0; i < 10; i++){
            UserEntity user = new UserEntity();
            user.setName("Name: " + i);
            user.setChecked(i % 2 == 0);
            mUsers.add(user);
        }
    }

    // Returns the instance.
    public static UserList get(Context context){
        if(sUserLab == null){
            sUserLab = new UserList(context.getApplicationContext());
        }

        return sUserLab;
    }

    public ArrayList<UserEntity> getUsers(){
        return mUsers;
    }

    public UserEntity getUser(UUID id){
        for(UserEntity user : mUsers){
            if(user.getId().equals(id)){
                return user;
            }
        }

        return null;
    }

}
