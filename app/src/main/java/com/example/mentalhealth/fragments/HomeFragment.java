package com.example.mentalhealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.home.AP.AP_Adapter;
import com.example.mentalhealth.home.AP.AP_Objects;
import com.example.mentalhealth.home.Activities.RA_Adapter;
import com.example.mentalhealth.home.Activities.RA_Objects;
import com.example.mentalhealth.well_bieng_guide.Well_Being_Activity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView AP;  //Additional Plan
    RecyclerView RA;  //Recommended Activities
    FloatingActionButton WB_fab;
    WebView mood_wv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, null);

        AP = v.findViewById(R.id.additional_plans_rv);
        AP.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<AP_Objects> list = new ArrayList<>();
        list.add(new AP_Objects("Foundation Course for Anxity", "6 days"));
        list.add(new AP_Objects("Stress\nManagement", "6 days"));
        list.add(new AP_Objects("Foundation of Anger\nManagement", "6 days"));
        list.add(new AP_Objects("Overcome\nOverThinking", "6 days"));
        list.add(new AP_Objects("Cognitive Dissonance? No More", "6 days"));
        AP_Adapter ap_adapter = new AP_Adapter(getContext(), list);
        AP.setAdapter(ap_adapter);

        RA = v.findViewById(R.id.recomended_act_rv);
        RA.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<RA_Objects> list1 = new ArrayList<>();
        list1.add(new RA_Objects("Deep Breathing"));
        list1.add(new RA_Objects("Guided Imagery"));
        list1.add(new RA_Objects("PMR"));
        list1.add(new RA_Objects("Guided Message"));
        list1.add(new RA_Objects("Mindful Walking"));
        list1.add(new RA_Objects("Thoughtful Defusion"));
        list1.add(new RA_Objects("Self-Compassion"));
        list1.add(new RA_Objects("Beach Visualisation"));
        list1.add(new RA_Objects("Walking"));
        list1.add(new RA_Objects("Climbing Stairs"));
        list1.add(new RA_Objects("Running"));
        list1.add(new RA_Objects("Cycling"));
        list1.add(new RA_Objects("Skipping Ropes"));
        RA_Adapter ra_adapter = new RA_Adapter(getContext(), list1);
        RA.setAdapter(ra_adapter);

        MaterialButton allAct = v.findViewById(R.id.view_all_act);
        allAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new GamesFragment(), "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        SmileRating smileRating = (SmileRating) v.findViewById(R.id.smiley);
        smileRating.setSelectedSmile(BaseRating.GOOD);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(getContext(), "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getContext(), "GOOD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getContext(), "GREAT", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getContext(), "OKAY", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getContext(), "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        WB_fab = v.findViewById(R.id.well_being_arrow);
        WB_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Well_Being_Activity.class);
                startActivity(intent);
            }
        });

        mood_wv = v.findViewById(R.id.mood_wv);
        mood_wv.loadUrl("file:///android_asset/html_css/arrow.html");


        return v;
    }
}
