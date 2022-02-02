package pl.edu.pb.gymhelper.Exercise;

import static pl.edu.pb.gymhelper.Exercise.ExerciseActivity.EXERCISE_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pl.edu.pb.gymhelper.R;

public class ExercisesRecViewAdapter extends RecyclerView.Adapter<ExercisesRecViewAdapter.ViewHolder> {
    private static final String TAG = "ExercisesRecViewAdapter";

    private ArrayList<Exercise> exercises = new ArrayList<>();
    private Context mContext;

    public ExercisesRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtName.setText(exercises.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(exercises.get(position).getImageUrl())
                .into(holder.imgExercise);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mContext, ExerciseActivity.class);
                intent.putExtra(EXERCISE_ID_KEY, exercises.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgExercise;
        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgExercise = itemView.findViewById(R.id.imgEx);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }

}
