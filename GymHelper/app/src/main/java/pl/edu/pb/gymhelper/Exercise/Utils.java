package pl.edu.pb.gymhelper.Exercise;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Exercise> allExercises;

    private Utils(){
        if (null == allExercises) {
            allExercises = new ArrayList<>();
            initData();
        }
    }

    private void initData() {

        allExercises.add(new Exercise(1, "Martwy Ciąg", 400, "https://upload.wikimedia.org/wikipedia/commons/2/2e/Deadlift_illustration.jpg", "https://www.youtube.com/watch?v=op9kVnSso6Q", "Opis"));
        allExercises.add(new Exercise(2, "Przysiad", 350, "https://myfamilychiropractor.com.au/wp-content/uploads/2015/04/squats.png", "https://www.youtube.com/watch?v=ultWZbUMPL8", "Opis"));

    }


    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        }
        else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Exercise> getAllExercises() {
        return allExercises;
    }

    public Exercise getExerciseById(int id) {
        for (Exercise e: allExercises) {
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

}
