package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void onGoBackClicked(View view){

        finish();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        EditText nameText = findViewById(R.id.name_textview);
        EditText statusText = findViewById(R.id.status_textview);





        nameText.setText(preferences.getString("name", ""));
        statusText.setText(preferences.getString("status", ""));

    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        EditText nameText = findViewById(R.id.name_textview);
        EditText statusText = findViewById(R.id.status_textview);
        editor.putString("name", nameText.getText().toString());
        editor.putString("status", statusText.getText().toString());




        editor.apply();

    }




}