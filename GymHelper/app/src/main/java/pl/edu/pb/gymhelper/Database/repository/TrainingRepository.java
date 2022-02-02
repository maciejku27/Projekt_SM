package pl.edu.pb.gymhelper.Database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.edu.pb.gymhelper.Database.TrainingDatabase;
import pl.edu.pb.gymhelper.Database.dao.TrainingDao;
import pl.edu.pb.gymhelper.Database.entity.Training;

public class TrainingRepository {
    private final TrainingDao trainingDao;
    private final LiveData<List<Training>> trainings;

    public TrainingRepository(Application application) {
        TrainingDatabase database = TrainingDatabase.getDatabase(application);
        trainingDao = database.trainingDao();
        trainings = trainingDao.findAll();
    }

    public LiveData<List<Training>> findAllTrainings() {
        return trainings;
    }

    public void insert(Training training) {
        TrainingDatabase.databaseWriterExecutor.execute(() -> {
            trainingDao.insert(training);
        });
    }

    public void update(Training training) {
        TrainingDatabase.databaseWriterExecutor.execute(() -> {
            trainingDao.update(training);
        });
    }

    public void delete(Training training) {
        TrainingDatabase.databaseWriterExecutor.execute(() -> {
            trainingDao.delete(training);
        });
    }
}
