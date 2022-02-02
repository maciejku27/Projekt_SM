package pl.edu.pb.gymhelper.Exercise;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercise")
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int kcal;
    private String imageUrl;
    private String videoUrl;
    private String desc;

    public Exercise(int id, String name, int kcal, String imageUrl, String videoUrl, String desc) {
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.desc = desc;
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

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kcal=" + kcal +
                ", imageUrl=" + imageUrl + '\'' +
                ", videoUrl=" + videoUrl + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
