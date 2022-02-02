package pl.edu.pb.gymhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import pl.edu.pb.gymhelper.BMI.BmiCalculatorActivity;
import pl.edu.pb.gymhelper.Exercise.AllExercisesActivity;
import pl.edu.pb.gymhelper.Training.TrainingActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAllExercises;
    private Button btnAllTrainings;
    private Button btnBmi;
    private Button btnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllExercises.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AllExercisesActivity.class);
            startActivity(intent);
        });

        btnAllTrainings.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
            startActivity(intent);
        });

        btnBmi.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BmiCalculatorActivity.class);
            startActivity(intent);
        });

        btnCalendar.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Niedostępne", Toast.LENGTH_SHORT).show();
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId()){
            case R.id.change_theme:
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                else
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        btnAllExercises = findViewById(R.id.btnAllExercise);
        btnAllTrainings = findViewById(R.id.btnAllTrainings);
        btnBmi = findViewById(R.id.btnBmi);
        btnCalendar = findViewById(R.id.btnCalendar);

    }
}