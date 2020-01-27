package com.example.draft_20.entities;

import java.util.UUID;

public class UserEntity {
    private UUID mId;
    private String mName;
    private boolean isChecked;

    public UserEntity(){
        mId = UUID.randomUUID();
    }

    public UserEntity(UUID id, String name){
        mId = id;
        mName = name;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setChecked(boolean check){
        isChecked = check;
    }

    public boolean getChecked(){
        return isChecked;
    }

    @Override
    public String toString(){
        return mName;
    }
}
