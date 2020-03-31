package com.dpridoy.mvvmrecyclerviewapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dpridoy.mvvmrecyclerviewapp.model.User;
import com.dpridoy.mvvmrecyclerviewapp.model.UserRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<List<User>> getAllData(){
        return userRepository.getUserData();
    }
}
