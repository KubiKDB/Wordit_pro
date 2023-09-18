package com.daniel.wordit_pro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RulesActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);
        Button wordit = findViewById(R.id.button_wordit);
        ImageButton share = findViewById(R.id.share_button);
        ImageButton review = findViewById(R.id.review_button);
        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);
        TextView textView4 = findViewById(R.id.text4);
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
                "     Book    Week    Man");
        textView4.setText("In Star mode you can choose a pair of words by yourself. Type first word followed by Enter, then second one and Enter. To play press 'START'\n\n"
                + "If you really like this game, please:");

        share.setOnClickListener(view -> {
            //TODO link
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body = "https://play.google.com/store/apps/details?id=com.daniel.wordit_pro";
            myIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(myIntent, "Wordit! Pro"));
        });

        review.setOnClickListener(view -> {
            //TODO link
            String str = "https://play.google.com/store/apps/details?id=com.daniel.wordit_pro";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(str));
            startActivity(i);
        });

        wordit.setOnClickListener(view -> {
            finish();
        });
    }
}
