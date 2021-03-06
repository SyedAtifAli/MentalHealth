package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class WriteSomething extends AppCompatActivity {

    String def;
    String sad, pep, lonely, advice;
    int flag = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.write_something);

        String course = "";
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        TextView title = findViewById(R.id.write_title);
        TextView content = findViewById(R.id.write_content);
        EditText editText = findViewById(R.id.write_et);
        Button nxt = findViewById(R.id.write_nxt);


        if (course.equals("res")) {
            if (day == 1) {
                title.setText("What does resilience means to you?\nWe'd love to know!");
                content.setText("You could define reilience as:\n1. Overcoming problems\n2. Adapting to change\n3. Helping others in crisis\n4. Bouncing back from challenges");
                nxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText.getText().toString().trim().isEmpty()) {
                            Toast.makeText(WriteSomething.this, "You haven't answered the question.", Toast.LENGTH_SHORT).show();
                        } else {
                            def = editText.getText().toString().trim();
                            Intent intent = new Intent(WriteSomething.this, Whatwritten.class);
                            intent.putExtra("course", "res");
                            intent.putExtra("day", 1);
                            intent.putExtra("content", def);
                            startActivity(intent);
                        }
                    }

                });
            } else if (day == 3) {
                editText.setHint("who is that person?");
                if (flag == 1) {
                    title.setText("Who do you talk to when you feel sad or upset? ");
                    content.setText("Think about who this person is");
                    nxt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (editText.getText().toString().trim().isEmpty()) {
                                Toast.makeText(WriteSomething.this, "You haven't answered the question.", Toast.LENGTH_SHORT).show();
                            } else {
                                sad = editText.getText().toString().trim();
                                editText.getText().clear();
                                title.setText("Who gives you the best pep talks to boost your confidence? ");
                                content.setText("Think about who this person is");
                                nxt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (editText.getText().toString().trim().isEmpty()) {
                                            Toast.makeText(WriteSomething.this, "You haven't answered the question.", Toast.LENGTH_SHORT).show();
                                        } else {
                                            pep = editText.getText().toString().trim();
                                            editText.getText().clear();
                                            title.setText("Who reminds you that you're not alone when you feel lonely?");
                                            content.setText("Think about who this person is");
                                            nxt.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (editText.getText().toString().trim().isEmpty()) {
                                                        Toast.makeText(WriteSomething.this, "You haven't answered the question.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        lonely = editText.getText().toString().trim();
                                                        editText.getText().clear();
                                                        title.setText("Who do you always turn to for advice?");
                                                        content.setText("Think about who this person is");
                                                        nxt.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (editText.getText().toString().trim().isEmpty()) {
                                                                    Toast.makeText(WriteSomething.this, "You haven't answered the question.", Toast.LENGTH_SHORT).show();
                                                                } else {
                                                                    advice = editText.getText().toString().trim();
                                                                    editText.getText().clear();
                                                                    Intent intent = new Intent(WriteSomething.this, Whatwritten.class);
                                                                    intent.putExtra("course", "res");
                                                                    intent.putExtra("day", 3);
                                                                    intent.putExtra("sad", sad);
                                                                    intent.putExtra("pep", pep);
                                                                    intent.putExtra("lonely", lonely);
                                                                    intent.putExtra("advice", advice);
                                                                    startActivity(intent);
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }

            }
        }
    }
}
