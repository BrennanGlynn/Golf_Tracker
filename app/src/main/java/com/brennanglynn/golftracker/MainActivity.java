package com.brennanglynn.golftracker;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    private static final String PREFS_FILE = "com.brennanglynn.golftracker.preferences";
    private static final String KEY_STROKECOUNT = "key_strokecount";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private HoleAdapter mHoleAdapter;
    private Hole[] mCourse = new Hole[18];

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        int strokes = 0;
        for(int i = 0; i < mCourse.length; i++ ) {
            strokes = mSharedPreferences.getInt(KEY_STROKECOUNT + i, 0);
            mCourse[i] = new Hole(i + 1, strokes);
        }
        mHoleAdapter = new HoleAdapter(this, mCourse);
        mRecyclerView.setAdapter(mHoleAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_strokes) {
            mEditor.clear();
            mEditor.apply();

            for (Hole hole : mCourse) {
                hole.setmHoleScore(0);
            }
            mHoleAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (int i = 0; i < mCourse.length; i++) {
            mEditor.putInt(KEY_STROKECOUNT + i, mCourse[i].getmHoleScore());
        }
        mEditor.apply();
    }
}
