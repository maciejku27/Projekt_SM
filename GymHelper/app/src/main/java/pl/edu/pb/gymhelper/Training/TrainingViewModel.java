package pl.edu.pb.gymhelper.Training;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.edu.pb.gymhelper.Database.repository.TrainingRepository;
import pl.edu.pb.gymhelper.Database.entity.Training;

public class TrainingViewModel extends AndroidViewModel {
    private final TrainingRepository trainingRepository;
    private final LiveData<List<Training>> trainings;

    public TrainingViewModel(@NonNull Application application) {
        super(application);
        trainingRepository = new TrainingRepository(application);
        trainings = trainingRepository.findAllTrainings();
    }

    public LiveData<List<Training>> findAll() {
        return trainings;
    }

    public void insert(Training training) {
        trainingRepository.insert(training);
    }

    public void update(Training training) {
        trainingRepository.update(training);
    }

    public void delete(Training training) {
        trainingRepository.delete(training);
    }
}

