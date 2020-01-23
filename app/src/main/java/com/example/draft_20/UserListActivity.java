package com.example.draft_20;

import androidx.fragment.app.Fragment;

public class UserListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new UserListFragment();
    }
}
