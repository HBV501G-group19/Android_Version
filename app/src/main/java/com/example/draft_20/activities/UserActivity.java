package com.example.draft_20.activities;

import androidx.fragment.app.Fragment;

import com.example.draft_20.fragments.UserFragment;

import java.util.UUID;

public class  UserActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID userId = (UUID) getIntent().getSerializableExtra(UserFragment.EXTRA_USER_ID);
        return UserFragment.newInstance(userId);
    }
}

