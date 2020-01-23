package com.example.draft_20;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

// This is the fragment for the userentity class.

public class UserFragment extends Fragment {
    public static final String EXTRA_USER_ID = "com.example.draft_20.userentity_id";

    private UserEntity mUser;
    private EditText mNameField;
    private Button mButton;
    private CheckBox mCheckBox;

    public static UserFragment newInstance(UUID userId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_USER_ID, userId);
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mUser = new UserEntity(UUID.randomUUID(), "USER_1");

        UUID userId = (UUID)getArguments().getSerializable(EXTRA_USER_ID);
        mUser = UserList.get(getActivity()).getUser(userId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, parent, false);

        mNameField = view.findViewById(R.id.user_name);
        mNameField.setText(mUser.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mButton = view.findViewById(R.id.user_add);

        mCheckBox = view.findViewById(R.id.user_check);
        mCheckBox.setChecked(mUser.getChecked());
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mUser.setChecked(isChecked);
            }
        });

        return view;
    }
}
