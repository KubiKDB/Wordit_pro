package com.daniel.wordit_pro;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartRules extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_start);
        Button wordit = findViewById(R.id.button_wordit);
        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);
        textView1.setText("You get a pair of words. In order to win, you have to transform the former word into the latter one in the least number of steps possible. A lower average of steps means more efficient solving.");
        textView2.setText("On each step you have to transform the previous word by one of the following:\n" +
                "1. Changing the letters\' position.\n" +
                "For instance, the word \"team\" can be transformed to \"meat\", \"tame\" or \"mate\".\n" +
                "2. Adding/deleting one of the letters.\n" +
                "For instance, the word \"mate\" can be changed to \"mates\" or \"mat\". Thus, \"meat\" -> \"mates\".\n" +
                "3. Changing one of the letters: \"team\" -> \"teem\"\n" +
                "Also, you can do all the three actions simultaneously: \"team\" -> \"meets\"");
        textView3.setText("     Word    Day      Boy\n" +
                "     Row     Way      Bay\n" +
                "     Bow     Weak    May\n" +
                "     Book    Week    Man\n" +
                "\n" +
                "Those are relatively simple transformations. The difficulty rises gradually, you will need to be inventive and patient. Are you ready to get in?");

        wordit.setOnClickListener(view -> {
            SharedPreferences.Editor sharedPreferencesEditor =
                    PreferenceManager.getDefaultSharedPreferences(this).edit();
            sharedPreferencesEditor.putBoolean(
                    "IS_SHOWN", true);
            sharedPreferencesEditor.apply();
            finish();
        });
    }

    @Override
    public void onBackPressed() {

    }
}
