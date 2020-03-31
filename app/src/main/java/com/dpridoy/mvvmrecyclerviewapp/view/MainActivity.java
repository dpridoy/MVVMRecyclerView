package com.dpridoy.mvvmrecyclerviewapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dpridoy.mvvmrecyclerviewapp.R;
import com.dpridoy.mvvmrecyclerviewapp.adapter.UserAdapter;
import com.dpridoy.mvvmrecyclerviewapp.model.User;
import com.dpridoy.mvvmrecyclerviewapp.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getAllData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                recyclerView.setAdapter(new UserAdapter(users));
            }
        });
    }
}
