package pl.edu.pb.gymhelper.Database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "training")
public class Training {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String length;

    public Training(String name, String length) {
        this.name = name;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
