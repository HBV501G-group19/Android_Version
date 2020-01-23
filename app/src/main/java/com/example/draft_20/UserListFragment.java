package com.example.draft_20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class UserListFragment extends ListFragment {
    private ArrayList<UserEntity> mUsers;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        getActivity().setTitle(R.string.user_list_title);
        mUsers = UserList.get(getActivity()).getUsers();

        UserAdapter adapter = new UserAdapter(mUsers);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((UserAdapter)getListAdapter()).notifyDataSetChanged();
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        UserEntity user = ((UserAdapter)getListAdapter()).getItem(position);

        // Start an activity
        Intent intent = new Intent(getActivity(), UserPagerActivity.class);
        intent.putExtra(UserFragment.EXTRA_USER_ID, user.getId());
        startActivity(intent);
    }

    private class UserAdapter extends ArrayAdapter<UserEntity>{

        public UserAdapter(ArrayList<UserEntity> users){
            super(getActivity(), 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // Inflating the default view.
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_user, null);
            }

            // Configure the view for this User.
            UserEntity u = getItem(position);

            TextView titleTextView = convertView.findViewById(R.id.user_list_item_title);
            titleTextView.setText(u.getName());
            TextView dateTextView = convertView.findViewById(R.id.user_list_item_someText);
            dateTextView.setText(u.getName());
            CheckBox solvedCheckBox = convertView.findViewById(R.id.user_list_item_checked);
            solvedCheckBox.setChecked(u.getChecked());

            return convertView;
        }
    }
}
