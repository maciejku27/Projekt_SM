package pl.edu.pb.gymhelper.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.edu.pb.gymhelper.Database.dao.TrainingDao;
import pl.edu.pb.gymhelper.Database.entity.Training;

@Database(entities = {Training.class}, version = 1, exportSchema = false)
public abstract class TrainingDatabase extends RoomDatabase {

    public abstract TrainingDao trainingDao();

    private static volatile TrainingDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriterExecutor.execute(() -> {
                TrainingDao dao = INSTANCE.trainingDao();
                dao.deleteAll();

                Training training = new Training("Nogi", "2h 30 min");
                dao.insert(training);
            });
        }
    };

    public static TrainingDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TrainingDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TrainingDatabase.class, "training_db2")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
