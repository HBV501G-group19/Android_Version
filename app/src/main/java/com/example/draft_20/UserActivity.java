package com.example.draft_20;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class  UserActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID userId = (UUID) getIntent().getSerializableExtra(UserFragment.EXTRA_USER_ID);
        return UserFragment.newInstance(userId);
    }
}

