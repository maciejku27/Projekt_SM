package pl.edu.pb.gymhelper.Training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import pl.edu.pb.gymhelper.Database.entity.Training;
import pl.edu.pb.gymhelper.R;

public class EditTrainingActivity extends AppCompatActivity {


    private Button btn_cancel;
    private EditText et_trainingName;
    private EditText et_trainingLength;

    private TrainingViewModel trainingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        btn_cancel = findViewById(R.id.btn_cancel);
        et_trainingName = findViewById(R.id.et_trainingName);
        et_trainingLength = findViewById(R.id.et_trainingLength);

        trainingViewModel = ViewModelProviders.of(this).get(TrainingViewModel.class);

        final Button btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(e -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(et_trainingName.getText())
                    || TextUtils.isEmpty(et_trainingLength.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                Training training = new Training(et_trainingName.getText().toString(),
                        et_trainingLength.getText().toString());
                trainingViewModel.insert(training);
            }


            Intent intent = new Intent(EditTrainingActivity.this, TrainingActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Dodano trening  ", Toast.LENGTH_SHORT).show();
        });

        btn_cancel.setOnClickListener(view -> {
            Intent intent = new Intent(EditTrainingActivity.this, TrainingActivity.class);
            startActivity(intent);
        });
    }
}