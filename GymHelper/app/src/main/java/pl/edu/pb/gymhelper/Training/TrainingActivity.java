package pl.edu.pb.gymhelper.Training;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import pl.edu.pb.gymhelper.Database.entity.Training;
import pl.edu.pb.gymhelper.R;


public class TrainingActivity extends AppCompatActivity {

    private TrainingViewModel trainingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainings);

        RecyclerView recyclerView = findViewById(R.id.lv_trainingList);
        final TrainingAdapter adapter = new TrainingAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        trainingViewModel = ViewModelProviders.of(this).get(TrainingViewModel.class);
        trainingViewModel.findAll().observe(this, adapter::setTrainings);

        FloatingActionButton addTrainingButton = findViewById(R.id.btn_trainingAdd);
        addTrainingButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrainingActivity.this, EditTrainingActivity.class);
            startActivity(intent);
        });
    }


        private class TrainingAdapter extends RecyclerView.Adapter<TrainingHolder> {
        private List<Training> trainings;

        @NonNull
        @Override
        public TrainingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TrainingHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(TrainingHolder holder, int position) {
            if (trainings != null) {
                Training training = trainings.get(position);
                holder.bind(training);
            } else {
                Log.d("TrainingActivity", "No trainings");
            }
        }

        public int getItemCount() {
            if (trainings != null) {
                return trainings.size();
            } else {
                return 0;
            }
        }

        void setTrainings(List<Training> trainings) {
            this.trainings = trainings;
            notifyDataSetChanged();
        }
    }

    private class TrainingHolder extends RecyclerView.ViewHolder {
        private final TextView trainingNameTextView;
        private final TextView trainingLengthTextView;
        private Training training;

        public TrainingHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_training, parent, false));

            trainingNameTextView = itemView.findViewById(R.id.txtTrainingName);
            trainingLengthTextView = itemView.findViewById(R.id.txtTrainingLength);
            View trainingItem = itemView.findViewById(R.id.item_training);
            trainingItem.setOnLongClickListener(v -> {
                trainingViewModel.delete(training);
                return true;
            });
        }

        public void bind(Training training) {
            trainingNameTextView.setText(training.getName());
            trainingLengthTextView.setText(training.getLength());
            this.training = training;
        }
    }

}