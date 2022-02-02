package pl.edu.pb.gymhelper.Training;

import androidx.appcompat.app.AppCompatActivity;

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

    public static final String EXTRA_EDIT_TRAINING_NAME = "pb.edu.pl.EDIT_TRAINING_NAME";
    public static final String EXTRA_EDIT_TRAINING_LENGTH = "pb.edu.pl.EDIT_TRAINING_LENGTH";

    private Button btn_ok;
    private Button btn_cancel;
    private EditText et_trainingName;
    private EditText et_trainingLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_trainingName = findViewById(R.id.et_trainingName);
        et_trainingLength = findViewById(R.id.et_trainingLength);

        if (getIntent().hasExtra(EXTRA_EDIT_TRAINING_NAME)) {
            et_trainingName.setText(getIntent().getStringExtra(EXTRA_EDIT_TRAINING_NAME));
            et_trainingLength.setText(getIntent().getStringExtra(EXTRA_EDIT_TRAINING_LENGTH));
        }

        btn_ok.setOnClickListener(view -> {

            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(et_trainingName.getText())
                    || TextUtils.isEmpty(et_trainingLength.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String name = et_trainingName.getText().toString();
                replyIntent.putExtra(EXTRA_EDIT_TRAINING_NAME, name);
                String length = et_trainingLength.getText().toString();
                replyIntent.putExtra(EXTRA_EDIT_TRAINING_LENGTH, length);
                setResult(RESULT_OK, replyIntent);
            }
            finish();

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