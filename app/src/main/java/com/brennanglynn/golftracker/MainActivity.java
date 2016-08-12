package com.brennanglynn.golftracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Hole[] mCourse;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCourse = new Hole[18];
        for(int i = 0; i < mCourse.length; i++ ) {
            Hole hole = new Hole(i);
            hole.setmHoleNumber(i + 1);
            hole.setmHoleScore(0);
            mCourse[i] = hole;
        }
        HoleAdapter adapter = new HoleAdapter(this, mCourse);
        mRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);



    }
}
