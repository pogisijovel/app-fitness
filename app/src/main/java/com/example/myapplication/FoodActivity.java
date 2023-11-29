package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        String[] titleArray = getResources().getStringArray(R.array.title_storyy);
        final String[] detailsArray = getResources().getStringArray(R.array.details_storyy);

        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, R.id.rowtxt, titleArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String details = detailsArray[position];
                Intent intent = new Intent(FoodActivity.this, FoodActivityDetails.class);
                intent.putExtra("story", details);
                startActivity(intent);
            }
        });
    }

    public void foodgoback(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FoodActivity.this, Fitness_App.class);
        startActivity(intent);
        finishAffinity();
    }
}
