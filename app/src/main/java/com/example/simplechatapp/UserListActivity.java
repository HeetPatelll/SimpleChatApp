package com.example.simplechatapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserListActivity extends AppCompatActivity {

    Button user1, user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);

        user1.setOnClickListener(v -> openChat("User 1"));
        user2.setOnClickListener(v -> openChat("User 2"));
    }

    private void openChat(String name){
        Intent i = new Intent(this, ChatActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }
}
