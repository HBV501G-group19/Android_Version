package com.example.draft_20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

public class UserPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ArrayList<UserEntity> mUsers;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mUsers = UserList.get(this).getUsers();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm){

            @Override
            public int getCount() {
                return mUsers.size();
            }

            @Override
            public Fragment getItem(int position) {
                UserEntity user = mUsers.get(position);
                return UserFragment.newInstance(user.getId());
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                UserEntity user = mUsers.get(position);
                if(user.getName() != null){
                    setTitle(user.getName());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        UUID userId = (UUID)getIntent().getSerializableExtra(UserFragment.EXTRA_USER_ID);

        for(int i = 0; i < mUsers.size(); i++){
            if(mUsers.get(i).getId().equals(userId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
