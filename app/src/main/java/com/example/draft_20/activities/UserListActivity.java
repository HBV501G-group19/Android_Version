package com.example.draft_20.activities;

import androidx.fragment.app.Fragment;

import com.example.draft_20.fragments.UserListFragment;

public class UserListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }
}
