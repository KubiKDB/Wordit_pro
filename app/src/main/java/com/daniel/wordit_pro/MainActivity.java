package com.daniel.wordit_pro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daniel.wordit_pro.database.StatDatabase;
import com.daniel.wordit_pro.entities.Statistics;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    boolean isCustom = false;
    int customWordRow = 0;

    Button button;
    Button rules;
    Button stats_button;
    ImageView switcher;

    ConstraintLayout stat_layout;
    TextView games_played;
    TextView games_won;
    TextView success_rate;
    TextView stats_times1;
    TextView stats_times2;
    TextView stats_times3;
    TextView stats_times4;
    TextView stats_times5;
    TextView stats_times6;
    TextView stats_times7;

    TextView stats_percents1;
    TextView stats_percents2;
    TextView stats_percents3;
    TextView stats_percents4;
    TextView stats_percents5;
    TextView stats_percents6;
    TextView stats_percents7;

    ImageView star_1;
    ImageView star_2;
    ImageView star_3;
    ImageView star_4;
    ImageView star_5;

    TextView avg_count;

    boolean isEnded = true;

    TextView[][] tvs = new TextView[7][7];
    TextView[] start_word = new TextView[7];
    TextView[] end_word = new TextView[7];
    ImageButton[] imageButtons = new ImageButton[7];
    String[] our_vocabs;
    int current_row = 0;

    Statistics stats;

    Chronometer timer;

    ConstraintLayout keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sharedPreferences.getBoolean("IS_SHOWN", false)) {
            startActivity(new Intent(this, SplashActivity.class));
        }

        button = findViewById(R.id.button);
        rules = findViewById(R.id.rules);
        switcher = findViewById(R.id.switcher);
        timer = findViewById(R.id.timer);

        keyboard = findViewById(R.id.keyboard);

//        EditText test_et = findViewById(R.id.test_et);
//        String[] arr8000 = new String[8000];
//        for (int i = 0; i < arr8000.length; i++) {
//            String result = "";
//            String[] rand_words = new String[7];
//            Random r = new Random();
//            int three = EnglishVoc.three_vocab.length;
//            int four = EnglishVoc.four_vocab.length;
//            int five = EnglishVoc.five_vocab.length;
//            int sixp1 = EnglishVoc.six_vocab_p1.length;
//            int sixp2 = EnglishVoc.six_vocab_p2.length;
//            rand_words[0] = EnglishVoc.four_vocab[r.nextInt(four)];
//            rand_words[1] = EnglishVoc.five_vocab[r.nextInt(five)];
//            rand_words[2] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//            rand_words[3] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//            rand_words[4] = EnglishVoc.seven_vocab_p1[r.nextInt(EnglishVoc.seven_vocab_p1.length)];
//            rand_words[5] = EnglishVoc.seven_vocab_p2[r.nextInt(EnglishVoc.seven_vocab_p2.length)];
//            rand_words[6] = EnglishVoc.seven_vocab_p3[r.nextInt(EnglishVoc.seven_vocab_p3.length)];
//
//            while (rand_words[2].substring(rand_words[2].length() - 3).contains("ing")) {
//                rand_words[2] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//            }
//            while (rand_words[3].substring(rand_words[3].length() - 3).contains("ing")) {
//                rand_words[3] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//            }
//            while (rand_words[4].substring(rand_words[4].length() - 3).contains("ing")) {
//                rand_words[4] = EnglishVoc.seven_vocab_p1[r.nextInt(EnglishVoc.seven_vocab_p1.length)];
//            }
//            while (rand_words[5].substring(rand_words[5].length() - 3).contains("ing")) {
//                rand_words[5] = EnglishVoc.seven_vocab_p2[r.nextInt(EnglishVoc.seven_vocab_p2.length)];
//            }
//            while (rand_words[6].substring(rand_words[6].length() - 3).contains("ing")) {
//                rand_words[6] = EnglishVoc.seven_vocab_p3[r.nextInt(EnglishVoc.seven_vocab_p3.length)];
//            }
//
//            char[] chars = rand_words[r.nextInt(rand_words.length)].toCharArray();
//
//            for (int j = 0; j < chars.length; j++) {
//                result = result + chars[j];
//            }
//            result = result + " ";
//
//            String[] rand_words1 = new String[4];
//            rand_words1[0] = EnglishVoc.four_vocab[r.nextInt(four)];
//            rand_words1[1] = EnglishVoc.five_vocab[r.nextInt(five)];
//            rand_words1[2] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//            rand_words1[3] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
////            while (rand_words1[2].substring(rand_words1[2].length() - 3).contains("ing")) {
////                rand_words1[2] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
////            }
////            while (rand_words1[3].substring(rand_words1[3].length() - 3).contains("ing")) {
////                rand_words1[3] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
////            }
//
//            char[] endChars = rand_words1[r.nextInt(rand_words1.length)].toCharArray();
//            for (char endChar : endChars) {
//                result = result + endChar;
//            }
//            arr8000[i] = result;
//        }
//

        stats_button = findViewById(R.id.statistics);
        stat_layout = findViewById(R.id.stats);

        games_played = findViewById(R.id.stats_num1);
        games_won = findViewById(R.id.stats_num2);
        success_rate = findViewById(R.id.stats_num3);

        stats_times1 = findViewById(R.id.stats_times_1);
        stats_times2 = findViewById(R.id.stats_times_2);
        stats_times3 = findViewById(R.id.stats_times_3);
        stats_times4 = findViewById(R.id.stats_times_4);
        stats_times5 = findViewById(R.id.stats_times_5);
        stats_times6 = findViewById(R.id.stats_times_6);
        stats_times7 = findViewById(R.id.stats_times_7);

        stats_percents1 = findViewById(R.id.stats_percents_1);
        stats_percents2 = findViewById(R.id.stats_percents_2);
        stats_percents3 = findViewById(R.id.stats_percents_3);
        stats_percents4 = findViewById(R.id.stats_percents_4);
        stats_percents5 = findViewById(R.id.stats_percents_5);
        stats_percents6 = findViewById(R.id.stats_percents_6);
        stats_percents7 = findViewById(R.id.stats_percents_7);

        star_1 = findViewById(R.id.star_1);
        star_2 = findViewById(R.id.star_2);
        star_3 = findViewById(R.id.star_3);
        star_4 = findViewById(R.id.star_4);
        star_5 = findViewById(R.id.star_5);

        avg_count = findViewById(R.id.avg_count);

        our_vocabs = EnglishVoc.our_vocab;

//        for (int i = 0; i < EnglishVoc.our_vocab_p1.length; i++) {
//            our_vocabs[i] = EnglishVoc.our_vocab_p1[i] + " " + EnglishVoc.our_vocab_p2[i];
//        }
//        Arrays.sort(our_vocabs, Comparator.comparingInt(String::length));

        @SuppressLint("StaticFieldLeak")
        class GetTask extends AsyncTask<Void, Void, List<Statistics>> {
            @Override
            protected List<Statistics> doInBackground(Void... voids) {
                return StatDatabase.getDatabase(getApplicationContext()).statDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Statistics> stats_arr) {
                super.onPostExecute(stats_arr);
                if (!stats_arr.isEmpty()) {
                    stats = stats_arr.get(0);
                    stats.setIs_new(false);
                } else {
                    stats = new Statistics();
                    stats.setIs_new(true);
                }
            }
        }

        new GetTask().execute();

//        for (int i = 0; i < our_vocabs.length; i++) {
//            test_et.setText(test_et.getText() + "\n" + our_vocabs[i]);
//        }
//        for (int i = 0; i < our_vocabs.length; i++) {
//            Log.e(i + "", our_vocabs[i]);
//        }

//        for (int i = 0; i < EnglishVoc.our_vocab_p1.length; i++) {
//            Log.e("p1 " + i,EnglishVoc.our_vocab_p1[i].toLowerCase(Locale.ROOT));
//        }
//        for (int i = 0; i < EnglishVoc.our_vocab_p2.length; i++) {
//            Log.e("p2 " + i,EnglishVoc.our_vocab_p2[i].toLowerCase(Locale.ROOT));
//        }

//        for (int i = 0; i < EnglishVoc.five_vocab.length; i++) {
//            if (EnglishVoc.five_vocab[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.five_vocab[i]);
//            }
//        }
//        for (int i = 0; i < EnglishVoc.six_vocab_p1.length; i++) {
//            if (EnglishVoc.six_vocab_p1[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.six_vocab_p1[i]);
//            }
//        }
//        for (int i = 0; i < EnglishVoc.six_vocab_p2.length; i++) {
//            if (EnglishVoc.six_vocab_p2[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.six_vocab_p2[i]);
//            }
//        }
//        for (int i = 0; i < EnglishVoc.seven_vocab_p1.length; i++) {
//            if (EnglishVoc.seven_vocab_p1[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.seven_vocab_p1[i]);
//            }
//        }
//        for (int i = 0; i < EnglishVoc.seven_vocab_p2.length; i++) {
//            if (EnglishVoc.seven_vocab_p2[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.seven_vocab_p2[i]);
//            }
//        }
//        for (int i = 0; i < EnglishVoc.seven_vocab_p3.length; i++) {
//            if (EnglishVoc.seven_vocab_p3[i].contains("'")){
//                Log.e("remove: ", EnglishVoc.seven_vocab_p3[i]);
//            }
//        }
        tvs[0][0] = findViewById(R.id.gl_1);
        tvs[0][1] = findViewById(R.id.gl_2);
        tvs[0][2] = findViewById(R.id.gl_3);
        tvs[0][3] = findViewById(R.id.gl_4);
        tvs[0][4] = findViewById(R.id.gl_5);
        tvs[0][5] = findViewById(R.id.gl_6);
        tvs[0][6] = findViewById(R.id.gl_7);
        imageButtons[0] = findViewById(R.id.gb_1);

        tvs[1][0] = findViewById(R.id.gl_8);
        tvs[1][1] = findViewById(R.id.gl_9);
        tvs[1][2] = findViewById(R.id.gl_10);
        tvs[1][3] = findViewById(R.id.gl_11);
        tvs[1][4] = findViewById(R.id.gl_12);
        tvs[1][5] = findViewById(R.id.gl_13);
        tvs[1][6] = findViewById(R.id.gl_14);
        imageButtons[1] = findViewById(R.id.gb_2);

        tvs[2][0] = findViewById(R.id.gl_15);
        tvs[2][1] = findViewById(R.id.gl_16);
        tvs[2][2] = findViewById(R.id.gl_17);
        tvs[2][3] = findViewById(R.id.gl_18);
        tvs[2][4] = findViewById(R.id.gl_19);
        tvs[2][5] = findViewById(R.id.gl_20);
        tvs[2][6] = findViewById(R.id.gl_21);
        imageButtons[2] = findViewById(R.id.gb_3);

        tvs[3][0] = findViewById(R.id.gl_22);
        tvs[3][1] = findViewById(R.id.gl_23);
        tvs[3][2] = findViewById(R.id.gl_24);
        tvs[3][3] = findViewById(R.id.gl_25);
        tvs[3][4] = findViewById(R.id.gl_26);
        tvs[3][5] = findViewById(R.id.gl_27);
        tvs[3][6] = findViewById(R.id.gl_28);
        imageButtons[3] = findViewById(R.id.gb_4);

        tvs[4][0] = findViewById(R.id.gl_29);
        tvs[4][1] = findViewById(R.id.gl_30);
        tvs[4][2] = findViewById(R.id.gl_31);
        tvs[4][3] = findViewById(R.id.gl_32);
        tvs[4][4] = findViewById(R.id.gl_33);
        tvs[4][5] = findViewById(R.id.gl_34);
        tvs[4][6] = findViewById(R.id.gl_35);
        imageButtons[4] = findViewById(R.id.gb_5);

        tvs[5][0] = findViewById(R.id.gl_36);
        tvs[5][1] = findViewById(R.id.gl_37);
        tvs[5][2] = findViewById(R.id.gl_38);
        tvs[5][3] = findViewById(R.id.gl_39);
        tvs[5][4] = findViewById(R.id.gl_40);
        tvs[5][5] = findViewById(R.id.gl_41);
        tvs[5][6] = findViewById(R.id.gl_42);
        imageButtons[5] = findViewById(R.id.gb_6);

        tvs[6][0] = findViewById(R.id.gl_43);
        tvs[6][1] = findViewById(R.id.gl_44);
        tvs[6][2] = findViewById(R.id.gl_45);
        tvs[6][3] = findViewById(R.id.gl_46);
        tvs[6][4] = findViewById(R.id.gl_47);
        tvs[6][5] = findViewById(R.id.gl_48);
        tvs[6][6] = findViewById(R.id.gl_49);
        imageButtons[6] = findViewById(R.id.gb_7);


        start_word[0] = findViewById(R.id.let_1);
        start_word[1] = findViewById(R.id.let_2);
        start_word[2] = findViewById(R.id.let_3);
        start_word[3] = findViewById(R.id.let_4);
        start_word[4] = findViewById(R.id.let_5);
        start_word[5] = findViewById(R.id.let_6);
        start_word[6] = findViewById(R.id.let_7);

        end_word[0] = findViewById(R.id.let_8);
        end_word[1] = findViewById(R.id.let_9);
        end_word[2] = findViewById(R.id.let_10);
        end_word[3] = findViewById(R.id.let_11);
        end_word[4] = findViewById(R.id.let_12);
        end_word[5] = findViewById(R.id.let_13);
        end_word[6] = findViewById(R.id.let_14);

        disableButtons();

        timer.setOnClickListener(view -> {
            if (isEnded) {
                startCustomGame();
            } else {
                LayoutInflater factory = LayoutInflater.from(this);
                final View nextDialogView = factory.inflate(R.layout.dialog, null);
                nextDialogView.setMinimumHeight(200);
                final AlertDialog nextDialog = new AlertDialog.Builder(this).create();
                nextDialog.setView(nextDialogView);
                nextDialogView.findViewById(R.id.yes).setOnClickListener(v -> {
                    customWordRow = 0;
                    isEnded = true;
                    startCustomGame();
                    nextDialog.dismiss();
                });
                nextDialogView.findViewById(R.id.no).setOnClickListener(v -> nextDialog.dismiss());
                nextDialog.show();
            }

        });

        button.setOnClickListener(view -> {
            if (isCustom) {
                if (customWordRow == 0) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Type first word, press Enter", 2000);
                    snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                    snackbar.setAnchorView(R.id.keyboard);
                    TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                    snackView.setTextSize(20);
                    snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    snackbar.show();
                }
                startCustomGame();
                return;
            }

            if (isEnded) {
                startGame();
            } else {
                LayoutInflater factory = LayoutInflater.from(this);
                final View nextDialogView = factory.inflate(R.layout.dialog, null);
                nextDialogView.setMinimumHeight(200);
                final AlertDialog nextDialog = new AlertDialog.Builder(this).create();
                nextDialog.setView(nextDialogView);
                nextDialogView.findViewById(R.id.yes).setOnClickListener(v -> {
                    stats.setGames_played(stats.getGames_played() + 1);

                    @SuppressLint("StaticFieldLeak")
                    class SurrTask extends AsyncTask<Void, Void, Void> {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            if (stats.isIs_new()) {
                                StatDatabase.getDatabase(getApplicationContext()).statDao().insertStat(stats);
                            } else {
                                StatDatabase.getDatabase(getApplicationContext()).statDao().changeStat(stats);
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void unused) {
                            super.onPostExecute(unused);
                            startGame();
                        }
                    }
                    new SurrTask().execute();
                    nextDialog.dismiss();
                });
                nextDialogView.findViewById(R.id.no).setOnClickListener(v -> nextDialog.dismiss());

                nextDialog.show();
            }
        });
        rules.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), RulesActivity.class));
        });
        stats_button.setOnClickListener(view -> {
            games_played.setText(stats.getGames_played() + "");
            games_won.setText(stats.getGames_won() + "");
            double s_rate =
                    Double.parseDouble(String.valueOf(stats.getGames_won()))
                            /
                            Double.parseDouble(String.valueOf(stats.getGames_played())) * 100;
            if (stats.getGames_played() != 0) {
                success_rate.setText(Math.round(s_rate) + "%");
            }

            double sum =
                    stats.getRow_num1() +
                            2 * stats.getRow_num2() +
                            3 * stats.getRow_num3() +
                            4 * stats.getRow_num4() +
                            5 * stats.getRow_num5() +
                            6 * stats.getRow_num6() +
                            7 * stats.getRow_num7();

            double average = sum / stats.getGames_won();

            if (stats.getGames_won() != 0) {
                avg_count.setText(average + "");
            }

            if (s_rate <= 10) {
                //0
                star_1.setImageResource(R.drawable.star_blank);
                star_2.setImageResource(R.drawable.star_blank);
                star_3.setImageResource(R.drawable.star_blank);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 10 && s_rate <= 19) {
                //0.5
                star_1.setImageResource(R.drawable.half_star);
                star_2.setImageResource(R.drawable.star_blank);
                star_3.setImageResource(R.drawable.star_blank);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 19 && s_rate <= 30) {
                //1
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_blank);
                star_3.setImageResource(R.drawable.star_blank);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 30 && s_rate <= 39) {
                //1.5
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.half_star);
                star_3.setImageResource(R.drawable.star_blank);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 39 && s_rate <= 50) {
                //2
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_blank);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 50 && s_rate <= 59) {
                //2.5
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.half_star);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 59 && s_rate <= 60) {
                //3
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_full);
                star_4.setImageResource(R.drawable.star_blank);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 60 && s_rate <= 69) {
                //3.5
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_full);
                star_4.setImageResource(R.drawable.half_star);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 69 && s_rate <= 80) {
                //4
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_full);
                star_4.setImageResource(R.drawable.star_full);
                star_5.setImageResource(R.drawable.star_blank);
            } else if (s_rate > 80 && s_rate <= 89) {
                //4.5
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_full);
                star_4.setImageResource(R.drawable.star_full);
                star_5.setImageResource(R.drawable.half_star);
            } else if (s_rate > 89) {
                //5
                star_1.setImageResource(R.drawable.star_full);
                star_2.setImageResource(R.drawable.star_full);
                star_3.setImageResource(R.drawable.star_full);
                star_4.setImageResource(R.drawable.star_full);
                star_5.setImageResource(R.drawable.star_full);
            }

            stats_times1.setText(stats.getRow_num1() + "");
            stats_times2.setText(stats.getRow_num2() + "");
            stats_times3.setText(stats.getRow_num3() + "");
            stats_times4.setText(stats.getRow_num4() + "");
            stats_times5.setText(stats.getRow_num5() + "");
            stats_times6.setText(stats.getRow_num6() + "");
            stats_times7.setText(stats.getRow_num7() + "");

            if (stats.getGames_won() != 0) {
                double i1 = Double.parseDouble(stats_times1.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i2 = Double.parseDouble(stats_times2.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i3 = Double.parseDouble(stats_times3.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i4 = Double.parseDouble(stats_times4.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i5 = Double.parseDouble(stats_times5.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i6 = Double.parseDouble(stats_times6.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                double i7 = Double.parseDouble(stats_times7.getText().toString()) / Double.parseDouble(games_won.getText().toString()) * 100;
                stats_percents1.setText(Math.round(i1) + "");
                stats_percents2.setText(Math.round(i2) + "");
                stats_percents3.setText(Math.round(i3) + "");
                stats_percents4.setText(Math.round(i4) + "");
                stats_percents5.setText(Math.round(i5) + "");
                stats_percents6.setText(Math.round(i6) + "");
                stats_percents7.setText(Math.round(i7) + "");
            }

            ConstraintLayout blur = findViewById(R.id.blur);
            blur.setOnClickListener(v -> {
                stat_layout.setVisibility(View.GONE);
                rules.setEnabled(true);
                blur.setVisibility(View.GONE);
            });

            if (stat_layout.getVisibility() == View.GONE) {
                stat_layout.setVisibility(View.VISIBLE);
                rules.setEnabled(false);
                blur.setVisibility(View.VISIBLE);
            } else if (stat_layout.getVisibility() == View.VISIBLE) {
                stat_layout.setVisibility(View.GONE);
                rules.setEnabled(true);
                blur.setVisibility(View.GONE);
            }
        });

        switcher.setOnClickListener(view -> {
            if (isCustom) {
                switcher.setImageDrawable(getDrawable(R.drawable.star_pro));
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Original mode", 2000);
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.setAnchorView(R.id.keyboard);
                TextView snackView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView.setTextSize(24);
                snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
                button.setText("PLAY");
                stats_button.setEnabled(true);
                disableButtons();
                isCustom = !isCustom;
                timer.setVisibility(View.GONE);
                for (int i = 0; i < tvs.length; i++) {
                    imageButtons[i].setImageResource(0);
                    imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
                    for (int j = 0; j < tvs[i].length; j++) {
                        tvs[i][j].setText("");
                    }
                }
                current_row = 0;
                for (int i = 0; i < start_word.length; i++) {
                    start_word[i].setText("");
                }
                for (int i = 0; i < end_word.length; i++) {
                    end_word[i].setText("");
                }
                isEnded = true;
            } else {
                switcher.setImageDrawable(getDrawable(R.drawable.star_blue_pro));
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Star mode", 2000);
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.setAnchorView(R.id.keyboard);
                TextView snackView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView.setTextSize(24);
                snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
                stats_button.setEnabled(false);
                enableButtons();
                isCustom = !isCustom;
                for (int i = 0; i < tvs.length; i++) {
                    imageButtons[i].setImageResource(0);
                    imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
                    for (int j = 0; j < tvs[i].length; j++) {
                        tvs[i][j].setText("");
                    }
                }
                current_row = 0;
                for (int i = 0; i < start_word.length; i++) {
                    start_word[i].setText("");
                }
                for (int i = 0; i < end_word.length; i++) {
                    end_word[i].setText("");
                }
                isEnded = true;
                button.setText("PLAY");
            }
        });
    }

    private void startGame() {
        @SuppressLint("StaticFieldLeak")
        class GetTask extends AsyncTask<Void, Void, List<Statistics>> {
            @Override
            protected List<Statistics> doInBackground(Void... voids) {
                return StatDatabase.getDatabase(getApplicationContext()).statDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Statistics> stats_arr) {
                super.onPostExecute(stats_arr);
                if (!stats_arr.isEmpty()) {
                    stats = stats_arr.get(0);
                    stats.setIs_new(false);
                } else {
                    stats = new Statistics();
                    stats.setIs_new(true);
                }
                isEnded = false;
                enableButtons();

                if (stats.getGames_played() == our_vocabs.length) {
                    LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                    final View alertDialogView = factory.inflate(R.layout.dialog_alert, null);
                    alertDialogView.setMinimumHeight(200);
                    final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setView(alertDialogView);
                    alertDialogView.findViewById(R.id.wordit).setOnClickListener(v -> {
                        alertDialog.dismiss();
                    });
                    alertDialog.show();
                }

                if (stats.getGames_played() >= our_vocabs.length && stats.getGames_played() <= EnglishVoc.random_vocab_1.length) {
//                    String[] rand_words = new String[5];
//                    Random r = new Random();
//                    int three = EnglishVoc.three_vocab.length;
//                    int four = EnglishVoc.four_vocab.length;
//                    int five = EnglishVoc.five_vocab.length;
//                    int sixp1 = EnglishVoc.six_vocab_p1.length;
//                    int sixp2 = EnglishVoc.six_vocab_p2.length;
//                    rand_words[0] = EnglishVoc.three_vocab[r.nextInt(three)];
//                    rand_words[1] = EnglishVoc.four_vocab[r.nextInt(four)];
//                    rand_words[2] = EnglishVoc.five_vocab[r.nextInt(five)];
//                    rand_words[3] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//                    rand_words[4] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//                    while (rand_words[3].substring(rand_words[3].length() - 3).contains("ing")) {
//                        rand_words[3] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//                    }
//                    while (rand_words[4].substring(rand_words[4].length() - 3).contains("ing")) {
//                        rand_words[4] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//                    }
//
//                    char[] chars = rand_words[r.nextInt(rand_words.length)].toCharArray();
//                    for (int i = 0; i < start_word.length; i++) {
//                        start_word[i].setText("");
//                    }
//                    for (int i = 0; i < chars.length; i++) {
//                        start_word[i].setText(chars[i] + "");
//                    }
//                    rand_words[0] = EnglishVoc.three_vocab[r.nextInt(three)];
//                    rand_words[1] = EnglishVoc.four_vocab[r.nextInt(four)];
//                    rand_words[2] = EnglishVoc.five_vocab[r.nextInt(five)];
//                    rand_words[3] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//                    rand_words[4] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//                    while (rand_words[3].substring(rand_words[3].length() - 3).contains("ing")) {
//                        rand_words[3] = EnglishVoc.six_vocab_p1[r.nextInt(sixp1)];
//                    }
//                    while (rand_words[4].substring(rand_words[4].length() - 3).contains("ing")) {
//                        rand_words[4] = EnglishVoc.six_vocab_p2[r.nextInt(sixp2)];
//                    }
//
//                    char[] endChars = rand_words[r.nextInt(rand_words.length)].toCharArray();
//                    for (int i = 0; i < end_word.length; i++) {
//                        end_word[i].setText("");
//                    }
//                    for (int i = 0; i < endChars.length; i++) {
//                        end_word[i].setText(endChars[i] + "");
//                    }
//
//                    for (int i = 0; i < tvs.length; i++) {
//                        imageButtons[i].setImageResource(0);
//                        imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
//                        for (int j = 0; j < tvs[i].length; j++) {
//                            tvs[i][j].setText("");
//                        }
//
                    String[] words = EnglishVoc.random_vocab_1[stats.getGames_played() - our_vocabs.length].split(" ");
                    String start = words[0];
                    char[] chars = start.toCharArray();
                    for (int i = 0; i < start_word.length; i++) {
                        start_word[i].setText("");
                    }
                    for (int i = 0; i < chars.length; i++) {
                        start_word[i].setText(chars[i] + "");
                    }
                    String end = words[1];
                    char[] endChars = end.toCharArray();
                    for (int i = 0; i < end_word.length; i++) {
                        end_word[i].setText("");
                    }
                    for (int i = 0; i < endChars.length; i++) {
                        end_word[i].setText(endChars[i] + "");
                    }

                    for (int i = 0; i < tvs.length; i++) {
                        imageButtons[i].setImageResource(0);
                        imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
                        for (int j = 0; j < tvs[i].length; j++) {
                            tvs[i][j].setText("");
                        }
                    }
                    current_row = 0;
                } else if (stats.getGames_played() >= EnglishVoc.random_vocab_1.length) {
                    String[] words = EnglishVoc.random_vocab_2[stats.getGames_played() - (EnglishVoc.random_vocab_1.length + our_vocabs.length)].split(" ");
                    String start = words[0];
                    char[] chars = start.toCharArray();
                    for (int i = 0; i < start_word.length; i++) {
                        start_word[i].setText("");
                    }
                    for (int i = 0; i < chars.length; i++) {
                        start_word[i].setText(chars[i] + "");
                    }
                    String end = words[1];
                    char[] endChars = end.toCharArray();
                    for (int i = 0; i < end_word.length; i++) {
                        end_word[i].setText("");
                    }
                    for (int i = 0; i < endChars.length; i++) {
                        end_word[i].setText(endChars[i] + "");
                    }

                    for (int i = 0; i < tvs.length; i++) {
                        imageButtons[i].setImageResource(0);
                        imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
                        for (int j = 0; j < tvs[i].length; j++) {
                            tvs[i][j].setText("");
                        }
                    }
                    current_row = 0;
                } else {
                    String[] words = our_vocabs[stats.getGames_played()].split(" ");
                    String start = words[0];
                    char[] chars = start.toCharArray();
                    for (int i = 0; i < start_word.length; i++) {
                        start_word[i].setText("");
                    }
                    for (int i = 0; i < chars.length; i++) {
                        start_word[i].setText(chars[i] + "");
                    }
                    String end = words[1];
                    char[] endChars = end.toCharArray();
                    for (int i = 0; i < end_word.length; i++) {
                        end_word[i].setText("");
                    }
                    for (int i = 0; i < endChars.length; i++) {
                        end_word[i].setText(endChars[i] + "");
                    }

                    for (int i = 0; i < tvs.length; i++) {
                        imageButtons[i].setImageResource(0);
                        imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
                        for (int j = 0; j < tvs[i].length; j++) {
                            tvs[i][j].setText("");
                        }
                    }
                    current_row = 0;
                }
            }
        }
        new GetTask().execute();
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        //TODO enter custom word
        if (isCustom) {
            imageButtons[current_row].setImageResource(0);
            if (customWordRow == 0) {
                for (int i = 0; i < start_word.length; i++) {
                    if (start_word[i].getText().length() == 0) {
                        start_word[i].append(btn.getText());
                        break;
                    }
                }
                return;
            } else if (customWordRow == 1) {
                for (int i = 0; i < 6; i++) {
                    if (end_word[i].getText().length() == 0) {
                        end_word[i].append(btn.getText());
                        break;
                    }
                }
                return;
            }
        }

        if (current_row < 7) {
            imageButtons[current_row].setImageResource(0);
            for (int i = 0; i < tvs[current_row].length; i++) {
                if (tvs[current_row][i].getText().length() == 0) {
                    tvs[current_row][i].append(btn.getText());
                    break;
                }
            }
        }
    }

    public void onErase(View view) {
        if (isCustom) {
            imageButtons[current_row].setImageResource(0);
            if (customWordRow == 0) {
                for (int i = start_word.length - 1; i >= 0; i--) {
                    if (start_word[i].getText().length() != 0) {
                        start_word[i].setText("");
                        break;
                    }
                }
                return;
            } else if (customWordRow == 1) {
                for (int i = 5; i >= 0; i--) {
                    if (end_word[i].getText().length() != 0) {
                        end_word[i].setText("");
                        break;
                    }
                }
                return;
            }
        }

        if (current_row < 7) {
            imageButtons[current_row].setImageResource(0);
            for (int i = tvs[current_row].length - 1; i >= 0; i--) {
                if (tvs[current_row][i].getText().length() != 0) {
                    tvs[current_row][i].setText("");
                    break;
                }
            }
        }
    }

    public void onEnter(View view) {
        if (isCustom) {
            if (customWordRow == 0) {
                String str = "";
                for (int i = 0; i < start_word.length; i++) {
                    str = str + start_word[i].getText();
                }
                checkCustomWord(str.toLowerCase(Locale.ROOT));
                return;
            } else if (customWordRow == 1) {
                String str = "";
                for (int i = 0; i < end_word.length; i++) {
                    str = str + end_word[i].getText();
                }
                checkCustomWord(str.toLowerCase(Locale.ROOT));
                return;
            }
        }

        if (current_row < 7) {
            String str = "";
            String str1 = "";
            String endWord = "";
            if (current_row == 0) {
                for (int i = 0; i < tvs[current_row].length; i++) {
                    str = str + tvs[current_row][i].getText();
                }
                for (int i = 0; i < start_word.length; i++) {
                    str1 = str1 + start_word[i].getText();
                }
                for (int i = 0; i < end_word.length; i++) {
                    endWord = endWord + end_word[i].getText();
                }
            } else {
                for (int i = 0; i < tvs[current_row].length; i++) {
                    str = str + tvs[current_row][i].getText();
                }
                for (int i = 0; i < tvs[current_row - 1].length; i++) {
                    str1 = str1 + tvs[current_row - 1][i].getText();
                }
                for (int i = 0; i < end_word.length; i++) {
                    endWord = endWord + end_word[i].getText();
                }
            }
            checkWord(
                    str.toLowerCase(Locale.ROOT),
                    str1.toLowerCase(Locale.ROOT),
                    endWord.toLowerCase(Locale.ROOT));
        }
    }

    private void checkWord(String currWord, String checkWord, String endWord) {
        boolean does_exist = false;
        switch (currWord.length()) {
            case 2:
                for (int i = 0; i < EnglishVoc.two_vocab.length; i++) {
                    if (EnglishVoc.two_vocab[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
            case 3:
                for (int i = 0; i < EnglishVoc.three_vocab.length; i++) {
                    if (EnglishVoc.three_vocab[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;

            case 4:
                for (int i = 0; i < EnglishVoc.four_vocab.length; i++) {
                    if (EnglishVoc.four_vocab[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;

            case 5:
                for (int i = 0; i < EnglishVoc.five_vocab.length; i++) {
                    if (EnglishVoc.five_vocab[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;
            case 6:
                if (currWord.charAt(0) > 'l') {
                    for (int i = 0; i < EnglishVoc.six_vocab_p2.length; i++) {
                        if (EnglishVoc.six_vocab_p2[i].equals(currWord)) {
                            does_exist = true;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < EnglishVoc.six_vocab_p1.length; i++) {
                        if (EnglishVoc.six_vocab_p1[i].equals(currWord)) {
                            does_exist = true;
                            break;
                        }
                    }
                }
                break;
            case 7:
                for (int i = 0; i < EnglishVoc.seven_vocab_p1.length; i++) {
                    if (EnglishVoc.seven_vocab_p1[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                for (int i = 0; i < EnglishVoc.seven_vocab_p2.length; i++) {
                    if (EnglishVoc.seven_vocab_p2[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                for (int i = 0; i < EnglishVoc.seven_vocab_p3.length; i++) {
                    if (EnglishVoc.seven_vocab_p3[i].equals(currWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;
        }
        if (!does_exist) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Not eligible word", 2000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(22);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            imageButtons[current_row].setImageResource(R.drawable.cross);
            return;
        }


        char[] checkChars = checkWord.toCharArray();
        char[] currChars = currWord.toCharArray();

        if (checkChars.length == currChars.length) {
            int f = 0;
            for (int i = 0; i < checkChars.length; i++) {
                for (int j = 0; j < currChars.length; j++) {
                    if (checkChars[i] == currChars[j]) {
                        f++;
                        checkChars[i] = 0;
                        currChars[j] = 0;
                        break;
                    }
                }
            }
            if (f < currChars.length - 1) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Follow the rules", 2000);
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.setAnchorView(R.id.keyboard);
                TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView.setTextSize(22);
                snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
                imageButtons[current_row].setImageResource(R.drawable.cross);
                return;
            }
        } else if (checkChars.length == currChars.length + 1) {
            int f = 0;
            for (int i = 0; i < checkChars.length; i++) {
                for (int j = 0; j < currChars.length; j++) {
                    if (checkChars[i] == currChars[j]) {
                        f++;
                        checkChars[i] = 0;
                        currChars[j] = 0;
                        break;
                    }
                }
            }
            if (f < currChars.length - 1) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Follow the rules", 2000);
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.setAnchorView(R.id.keyboard);
                TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView.setTextSize(22);
                snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
                imageButtons[current_row].setImageResource(R.drawable.cross);
                return;
            }
        } else if (checkChars.length == currChars.length - 1) {
            int f = 0;
            for (int i = 0; i < checkChars.length; i++) {
                for (int j = 0; j < currChars.length; j++) {
                    if (checkChars[i] == currChars[j]) {
                        f++;
                        checkChars[i] = 0;
                        currChars[j] = 0;
                        break;
                    }
                }
            }
            if (f < currChars.length - 2) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Follow the rules", 2000);
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.setAnchorView(R.id.keyboard);
                TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView.setTextSize(22);
                snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
                imageButtons[current_row].setImageResource(R.drawable.cross);
                return;
            }
        } else {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Follow the rules", 2000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(22);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            imageButtons[current_row].setImageResource(R.drawable.cross);
            return;
        }

//        if(checkWord.length() == currWord.length()){
//            int f = 0;
//            for (int i = 0; i < checkWord.length(); i++) {
//                for (int j = 0; j < currWord.length(); j++) {
//                    if (currWord.charAt(j) == checkWord.charAt(i)){
//                        f++;
//                        break;
//                    }
//                }
//            }
//            if (f < currWord.length() - 1){
//                Snackbar
//                        .make(findViewById(R.id.main), "Follow the rules", 3000)
//                        .setTextColor(Color.parseColor("#FFEA00"))
//                        .setAnchorView(R.id.keyboard)
//                        .show();
//                imageButtons[current_row].setImageResource(R.drawable.cross);
//                return;
//            }
//        }else if(checkWord.length() == currWord.length() + 1){
//            int f = 0;
//            for (int i = 0; i < currWord.length(); i++) {
//                for (int j = 0; j < checkWord.length(); j++) {
//                    if (currWord.charAt(i) == checkWord.charAt(j)){
//                        f++;
//                        break;
//                    }
//                }
//            }
//            if (f < currWord.length() - 1){
//                Snackbar
//                        .make(findViewById(R.id.main), "Follow the rules", 3000)
//                        .setTextColor(Color.parseColor("#FFEA00"))
//                        .setAnchorView(R.id.keyboard)
//                        .show();
//                imageButtons[current_row].setImageResource(R.drawable.cross);
//                return;
//            }
//        }else if (checkWord.length() == currWord.length() - 1){
//            int f = 0;
//            for (int i = 0; i < checkWord.length(); i++) {
//                for (int j = 0; j < currWord.length(); j++) {
//                    if (currWord.charAt(j) == checkWord.charAt(i)){
//                        f++;
//                        break;
//                    }
//                }
//            }
//            if (f < currWord.length() - 2){
//                Snackbar
//                        .make(findViewById(R.id.main), "Follow the rules", 3000)
//                        .setTextColor(Color.parseColor("#FFEA00"))
//                        .setAnchorView(R.id.keyboard)
//                        .show();
//                imageButtons[current_row].setImageResource(R.drawable.cross);
//                return;
//            }
//        }else{
//            Snackbar
//                    .make(findViewById(R.id.main), "Follow the rules", 3000)
//                    .setTextColor(Color.parseColor("#FFEA00"))
//                    .setAnchorView(R.id.keyboard)
//                    .show();
//            imageButtons[current_row].setImageResource(R.drawable.cross);
//            return;
//        }

        if (currWord.equals(endWord)) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "You won!", 2000);
            snackbar.setTextColor(Color.parseColor("#00FF00"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(24);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            imageButtons[current_row].setImageResource(R.drawable.ic_baseline_star_rate_24);
            imageButtons[current_row].setBackground(getDrawable(R.drawable.square_blue));
            isEnded = true;
            customWordRow = 0;
            if (!isCustom) {
                stats.setGames_played(stats.getGames_played() + 1);
                stats.setGames_won(stats.getGames_won() + 1);
                switch (current_row) {
                    case 0:
                        stats.setRow_num1(stats.getRow_num1() + 1);
                        break;
                    case 1:
                        stats.setRow_num2(stats.getRow_num2() + 1);
                        break;
                    case 2:
                        stats.setRow_num3(stats.getRow_num3() + 1);
                        break;
                    case 3:
                        stats.setRow_num4(stats.getRow_num4() + 1);
                        break;
                    case 4:
                        stats.setRow_num5(stats.getRow_num5() + 1);
                        break;
                    case 5:
                        stats.setRow_num6(stats.getRow_num6() + 1);
                        break;
                    case 6:
                        stats.setRow_num7(stats.getRow_num7() + 1);
                        break;
                }

                @SuppressLint("StaticFieldLeak")
                class WinTask extends AsyncTask<Void, Void, Void> {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        if (stats.isIs_new()) {
                            StatDatabase.getDatabase(getApplicationContext()).statDao().insertStat(stats);
                        } else {
                            StatDatabase.getDatabase(getApplicationContext()).statDao().changeStat(stats);
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                    }
                }
                new WinTask().execute();
            } else {
                Snackbar snackbar1 = Snackbar.make(findViewById(R.id.main), "You won! Press Timer", 2000);
                snackbar1.setTextColor(Color.parseColor("#00FF00"));
                snackbar1.setAnchorView(R.id.keyboard);
                TextView snackView1 = (TextView) snackbar1.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView1.setTextSize(20);
                snackView1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar1.show();
                timer.stop();
            }

            disableButtons();
            return;
        }
        if (current_row == 6) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "You lost!", 2000);
            snackbar.setTextColor(Color.parseColor("#FF0000"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(24);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            imageButtons[current_row].setImageResource(R.drawable.ic_baseline_circle_24);
            imageButtons[current_row].setBackground(getDrawable(R.drawable.square_blue));
            isEnded = true;
            customWordRow = 0;

            if (!isCustom) {
                stats.setGames_played(stats.getGames_played() + 1);

                @SuppressLint("StaticFieldLeak")
                class LoseTask extends AsyncTask<Void, Void, Void> {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        if (stats.isIs_new()) {
                            StatDatabase.getDatabase(getApplicationContext()).statDao().insertStat(stats);
                        } else {
                            StatDatabase.getDatabase(getApplicationContext()).statDao().changeStat(stats);
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                    }
                }
                new LoseTask().execute();
            } else {
                Snackbar snackbar1 = Snackbar.make(findViewById(R.id.main), "You lost! Press Timer", 2000);
                snackbar1.setTextColor(Color.parseColor("#FF0000"));
                snackbar1.setAnchorView(R.id.keyboard);
                TextView snackView1 = (TextView) snackbar1.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackView1.setTextSize(20);
                snackView1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar1.show();
                timer.stop();
            }
            disableButtons();
            return;
        }
        imageButtons[current_row].setImageResource(R.drawable.ic_baseline_check_24);
        current_row++;
    }

    private void checkCustomWord(String customWord) {
        boolean does_exist = false;
        switch (customWord.length()) {
            case 2:
                for (int i = 0; i < EnglishVoc.two_vocab.length; i++) {
                    if (EnglishVoc.two_vocab[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
            case 3:
                for (int i = 0; i < EnglishVoc.three_vocab.length; i++) {
                    if (EnglishVoc.three_vocab[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;

            case 4:
                for (int i = 0; i < EnglishVoc.four_vocab.length; i++) {
                    if (EnglishVoc.four_vocab[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;

            case 5:
                for (int i = 0; i < EnglishVoc.five_vocab.length; i++) {
                    if (EnglishVoc.five_vocab[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;
            case 6:
                if (customWord.charAt(0) > 'l') {
                    for (int i = 0; i < EnglishVoc.six_vocab_p2.length; i++) {
                        if (EnglishVoc.six_vocab_p2[i].equals(customWord)) {
                            does_exist = true;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < EnglishVoc.six_vocab_p1.length; i++) {
                        if (EnglishVoc.six_vocab_p1[i].equals(customWord)) {
                            does_exist = true;
                            break;
                        }
                    }
                }
                break;
            case 7:
                for (int i = 0; i < EnglishVoc.seven_vocab_p1.length; i++) {
                    if (EnglishVoc.seven_vocab_p1[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                for (int i = 0; i < EnglishVoc.seven_vocab_p2.length; i++) {
                    if (EnglishVoc.seven_vocab_p2[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                for (int i = 0; i < EnglishVoc.seven_vocab_p3.length; i++) {
                    if (EnglishVoc.seven_vocab_p3[i].equals(customWord)) {
                        does_exist = true;
                        break;
                    }
                }
                break;
        }
        if (!does_exist) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Not eligible word", 2000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(22);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            return;
        }

        if (customWordRow == 0) {
            customWordRow++;
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Type second word, press Enter", 1000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(20);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        } else if (customWordRow == 1) {
            button.setText("START");
            customWordRow++;
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Press START", 1000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(24);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            disableButtons();
            button.setEnabled(true);
        }
    }

    private void startCustomGame() {
        for (int i = 0; i < tvs.length; i++) {
            imageButtons[i].setImageResource(0);
            imageButtons[current_row].setBackground(getDrawable(R.drawable.square_yellow));
            for (int j = 0; j < tvs[i].length; j++) {
                tvs[i][j].setText("");
            }
        }
        current_row = 0;
        enableButtons();
        if (customWordRow == 0) {
            for (int i = 0; i < start_word.length; i++) {
                start_word[i].setText("");
            }
            for (int i = 0; i < end_word.length; i++) {
                end_word[i].setText("");
            }
            timer.setVisibility(View.GONE);
            button.setText("PLAY");
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Type first word, press Enter", 2000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(20);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
            return;
        }

        if (customWordRow == 1){
            Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Type second word, press Enter", 2000);
            snackbar.setTextColor(Color.parseColor("#FFFFFF"));
            snackbar.setAnchorView(R.id.keyboard);
            TextView snackView = (TextView) snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            snackView.setTextSize(20);
            snackView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            snackbar.show();
        }

        if (customWordRow == 2){
            timer.setVisibility(View.VISIBLE);
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            isEnded = false;
        }
    }

    private void disableButtons() {
        ImageButton erase = findViewById(R.id.letter_erase);
        ImageButton enter = findViewById(R.id.letter_enter);
        Button a = findViewById(R.id.letter_a);
        Button b = findViewById(R.id.letter_b);
        Button c = findViewById(R.id.letter_c);
        Button d = findViewById(R.id.letter_d);
        Button e = findViewById(R.id.letter_e);
        Button f = findViewById(R.id.letter_f);
        Button g = findViewById(R.id.letter_g);
        Button h = findViewById(R.id.letter_h);
        Button i = findViewById(R.id.letter_i);
        Button j = findViewById(R.id.letter_j);
        Button k = findViewById(R.id.letter_k);
        Button l = findViewById(R.id.letter_l);
        Button m = findViewById(R.id.letter_m);
        Button n = findViewById(R.id.letter_n);
        Button o = findViewById(R.id.letter_o);
        Button p = findViewById(R.id.letter_p);
        Button q = findViewById(R.id.letter_q);
        Button r = findViewById(R.id.letter_r);
        Button s = findViewById(R.id.letter_s);
        Button t = findViewById(R.id.letter_t);
        Button u = findViewById(R.id.letter_u);
        Button v = findViewById(R.id.letter_v);
        Button w = findViewById(R.id.letter_w);
        Button x = findViewById(R.id.letter_x);
        Button y = findViewById(R.id.letter_y);
        Button z = findViewById(R.id.letter_z);
        erase.setEnabled(false);
        enter.setEnabled(false);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
        g.setEnabled(false);
        h.setEnabled(false);
        i.setEnabled(false);
        j.setEnabled(false);
        k.setEnabled(false);
        l.setEnabled(false);
        m.setEnabled(false);
        n.setEnabled(false);
        o.setEnabled(false);
        p.setEnabled(false);
        q.setEnabled(false);
        r.setEnabled(false);
        s.setEnabled(false);
        t.setEnabled(false);
        u.setEnabled(false);
        v.setEnabled(false);
        w.setEnabled(false);
        x.setEnabled(false);
        y.setEnabled(false);
        z.setEnabled(false);
    }

    private void enableButtons() {
        ImageButton erase = findViewById(R.id.letter_erase);
        ImageButton enter = findViewById(R.id.letter_enter);
        Button a = findViewById(R.id.letter_a);
        Button b = findViewById(R.id.letter_b);
        Button c = findViewById(R.id.letter_c);
        Button d = findViewById(R.id.letter_d);
        Button e = findViewById(R.id.letter_e);
        Button f = findViewById(R.id.letter_f);
        Button g = findViewById(R.id.letter_g);
        Button h = findViewById(R.id.letter_h);
        Button i = findViewById(R.id.letter_i);
        Button j = findViewById(R.id.letter_j);
        Button k = findViewById(R.id.letter_k);
        Button l = findViewById(R.id.letter_l);
        Button m = findViewById(R.id.letter_m);
        Button n = findViewById(R.id.letter_n);
        Button o = findViewById(R.id.letter_o);
        Button p = findViewById(R.id.letter_p);
        Button q = findViewById(R.id.letter_q);
        Button r = findViewById(R.id.letter_r);
        Button s = findViewById(R.id.letter_s);
        Button t = findViewById(R.id.letter_t);
        Button u = findViewById(R.id.letter_u);
        Button v = findViewById(R.id.letter_v);
        Button w = findViewById(R.id.letter_w);
        Button x = findViewById(R.id.letter_x);
        Button y = findViewById(R.id.letter_y);
        Button z = findViewById(R.id.letter_z);
        erase.setEnabled(true);
        enter.setEnabled(true);
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
        g.setEnabled(true);
        h.setEnabled(true);
        i.setEnabled(true);
        j.setEnabled(true);
        k.setEnabled(true);
        l.setEnabled(true);
        m.setEnabled(true);
        n.setEnabled(true);
        o.setEnabled(true);
        p.setEnabled(true);
        q.setEnabled(true);
        r.setEnabled(true);
        s.setEnabled(true);
        t.setEnabled(true);
        u.setEnabled(true);
        v.setEnabled(true);
        w.setEnabled(true);
        x.setEnabled(true);
        y.setEnabled(true);
        z.setEnabled(true);
    }
}