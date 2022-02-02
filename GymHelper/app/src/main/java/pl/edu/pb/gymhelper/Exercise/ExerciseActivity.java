package pl.edu.pb.gymhelper.Exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.edu.pb.gymhelper.R;

public class ExerciseActivity extends AppCompatActivity {

    public static final String EXERCISE_ID_KEY = "exerciseId";

    private TextView txtExeName, txtExeKcal, txtExeDesc;
    private Button buttonVid;
    private ImageView imgExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        initViews();

        Intent intent = getIntent();
        if (null != intent) {
            int exerciseId = intent.getIntExtra(EXERCISE_ID_KEY, -1);
            if (exerciseId != -1){
                Exercise tolearnExercise = Utils.getInstance().getExerciseById(exerciseId);
                if (null != tolearnExercise) {
                    setData(tolearnExercise);
                }
            }
        }
    }

    private void setData(Exercise exercise) {
        txtExeName.setText(exercise.getName());
        txtExeKcal.setText(String.valueOf(exercise.getKcal()));
        txtExeDesc.setText(exercise.getDesc());
        buttonVid.setText(exercise.getVideoUrl());
        Glide.with(this)
                .asBitmap().load(exercise.getImageUrl())
                .into(imgExercise);
    }

    private void initViews() {
         txtExeName = findViewById(R.id.txtExName2);
         txtExeKcal = findViewById(R.id.txtExKcal2);
         txtExeDesc = findViewById(R.id.txtExDesc2);

         buttonVid = findViewById(R.id.btn_vid);

         imgExercise = findViewById(R.id.imgEx);
    }
}