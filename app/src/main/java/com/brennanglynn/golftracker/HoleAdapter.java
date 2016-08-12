package com.brennanglynn.golftracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.HoleViewHolder>{

    private Hole[] mCourse;
    private Context mContext;

    public HoleAdapter(Context context, Hole[] course) {
        mCourse = course;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public HoleAdapter.HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View holeView = inflater.inflate(R.layout.hole_list_item, parent, false);

        // Return a new holder instance
        HoleViewHolder viewHolder = new HoleViewHolder(holeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HoleAdapter.HoleViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Hole hole = mCourse[position];

        // Set item views based on views and data model
        TextView holeNumber = viewHolder.holeNumber;
        holeNumber.setText("Hole " + hole.getmHoleNumber() + ":");
        TextView holeScore = viewHolder.holeScore;
        holeScore.setText(hole.getmHoleScore() + "");
        Button addButton = viewHolder.add;
        addButton.setText("+");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.format("Adding a stroke to hole %d", position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        Button subtractButton = viewHolder.subtract;
        subtractButton.setText("-");
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.format("Subtracting a stroke from hole %d", position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourse.length;
    }

    public static class HoleViewHolder extends RecyclerView.ViewHolder {
        public TextView holeNumber;
        public TextView holeScore;
        public Button add;
        public Button subtract;

        public HoleViewHolder(View itemView) {
            super(itemView);
            holeNumber = (TextView) itemView.findViewById(R.id.holeNumber);
            holeScore = (TextView) itemView.findViewById(R.id.scoreTextView);
            add = (Button) itemView.findViewById(R.id.addButton);
            subtract = (Button) itemView.findViewById(R.id.subtractButton);
        }
    }
}
