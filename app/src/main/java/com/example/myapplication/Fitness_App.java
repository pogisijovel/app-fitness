package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Fitness_App extends AppCompatActivity {

    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.startexercise);
        button2 = findViewById(R.id.startexercise2);
        button3 = findViewById(R.id.gotoBMII);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fitness_App.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fitness_App.this, SecondActivity2.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fitness_App.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });
    }



    public void openBMICalculatorActivity(View view) {
        Intent intent = new Intent(Fitness_App.this, BMICalculatorActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.termsfeed.com/blog/privacy-guidelines-health-apps/"));
            startActivity(intent);
            return true;
        } else if (id == R.id.id_term) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dailyworkoutapps.com/terms-of-use.html"));
            startActivity(intent);
            return true;
        } else if (id == R.id.rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            } catch (Exception ex) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.som/store/apps/details?id=" + getPackageName())));
            }
            return true;
        } else if (id == R.id.more) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group&hl=en"));
            startActivity(intent);
            return true;
        } else if (id == R.id.share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is best for fitness \n By this app you can gain muscle \n this is free app download now \n" + "https://google.som/store/apps/details?id=com.example.myapplication&hl=en";
            String sharehub = "Fitness app";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
            startActivity(Intent.createChooser(myIntent, "share using"));
            return true;
        } else if (id == R.id.logout) {
            Intent intent = new Intent(Fitness_App.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void StartBMI(View view) {
        Intent intent = new Intent(Fitness_App.this, BMICalculatorActivity.class);
        startActivity(intent);
    }
        public void beforeage18(View view) {
        Intent intent = new Intent(Fitness_App.this, SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(Fitness_App.this, SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(Fitness_App.this, FoodActivity.class);
        startActivity(intent);


    }

    private boolean backPressedOnce = false; // Keep track of back button press

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed(); // Close the app
            return;
        }

        this.backPressedOnce = true;
        Toast.makeText(this, "Click again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressedOnce = false;
            }
        }, 2000);
    }
}