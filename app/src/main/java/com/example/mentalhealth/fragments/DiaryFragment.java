package com.example.mentalhealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;
import com.example.mentalhealth.diary.AddActivity;
import com.example.mentalhealth.diary.ItemObject;
import com.example.mentalhealth.diary.SQLiteNote;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DiaryFragment extends Fragment implements View.OnClickListener {

    FloatingActionButton btn_add_note;
    RecyclerView lst_note;
    List<ItemObject> list;
    TextView empty;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_diary, null);

        empty = v.findViewById(R.id.empty_diary);

        lst_note = v.findViewById(R.id.lst_note);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        lst_note.setLayoutManager(gridLayoutManager);
        DataItem();

        btn_add_note = v.findViewById(R.id.btn_add_note);
        btn_add_note.setOnClickListener(this);

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        DataItem();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_note:
                Intent intent = new Intent(getContext(), AddActivity.class);
                startActivity(intent);
                break;
        }
    }


    public void DataItem() {
        SQLiteNote db_note = new SQLiteNote(getContext());
        list = db_note.getData();
        if (list.isEmpty()) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.GONE);
            BaseAdapter adapter = new BaseAdapter(getContext(), db_note.getData());
            lst_note.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }


}
