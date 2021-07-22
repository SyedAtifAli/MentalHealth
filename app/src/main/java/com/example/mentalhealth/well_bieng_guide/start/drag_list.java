package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

import java.util.ArrayList;

public class drag_list extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draglist);

        ImageView back = findViewById(R.id.drag_back);
        TextView title = findViewById(R.id.drag_title);
        ListView listView = findViewById(R.id.drag_list);
        Button next = findViewById(R.id.drag_next);

        String course;
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        if(course.equals("res")){
            if(day == 2){
                title.setText("Select the strength based on how frequently you use them");
                ArrayList arrayList = new ArrayList();
                arrayList.add("kindness");
                arrayList.add("Empathy");
                arrayList.add("Gratefulness");
                arrayList.add("Creativity");
                arrayList.add("Curiosity");
                arrayList.add("Open-mindedness");
                arrayList.add("Humility");
                arrayList.add("Preseverance");
                arrayList.add("Diligence");
                arrayList.add("Forgiveness");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String value = adapter.getItem(position);
                        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(drag_list.this,drag_select.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",2);
                        intent.putExtra("strength",value);
                        startActivity(intent);

                    }
                });
            }
        }
    }
}
