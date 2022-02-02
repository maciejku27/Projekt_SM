package pl.edu.pb.gymhelper.Exercise;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pl.edu.pb.gymhelper.R;

public class AllExercisesActivity extends AppCompatActivity {

    private RecyclerView exercisesRecView;
    private ExercisesRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);

        adapter = new ExercisesRecViewAdapter(this);
        exercisesRecView = findViewById(R.id.exercisesRecView);

        exercisesRecView.setAdapter(adapter);
        exercisesRecView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setExercises(Utils.getInstance().getAllExercises());
    }
}
