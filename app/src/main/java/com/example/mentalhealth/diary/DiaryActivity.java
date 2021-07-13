package com.example.mentalhealth.diary;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.MainActivity;
import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiaryActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_add_note)
    FloatingActionButton btn_add_note;
    @BindView(R.id.lst_note)
    RecyclerView lst_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        ButterKnife.bind(this);

        lst_note = findViewById(R.id.lst_note);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lst_note.setLayoutManager(linearLayoutManager);

        DataItem();

        btn_add_note = findViewById(R.id.btn_add_note);
        btn_add_note.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_note:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void DataItem() {
        SQLiteNote db_note = new SQLiteNote(this);
        BaseAdapter adapter = new BaseAdapter(this, db_note.getData());
        lst_note.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);
        finish();
    }
}
