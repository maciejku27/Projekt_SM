package pl.edu.pb.gymhelper.Database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pl.edu.pb.gymhelper.Database.entity.Training;

@Dao
public interface TrainingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Training training);

    @Update
    public void update(Training training);

    @Delete
    public void delete(Training training);

    @Query("DELETE FROM Training")
    public void deleteAll();

    @Query("SELECT * FROM Training ORDER BY name")
    public LiveData<List<Training>> findAll();

    @Query("SELECT * FROM Training WHERE name LIKE :name")
    public LiveData<List<Training>> findByName(String name);

}
