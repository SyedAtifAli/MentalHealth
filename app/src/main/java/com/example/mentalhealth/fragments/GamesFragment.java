package com.example.mentalhealth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.Games.physical_adapter;
import com.example.mentalhealth.Games.relax_adapter;
import com.example.mentalhealth.R;
import com.example.mentalhealth.home.Activities.RA_Objects;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment  extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View v = inflater.inflate(R.layout.fragment_games, null);

        RecyclerView rv1 =  v.findViewById(R.id.games_rv_1);
        RecyclerView rv2 = v.findViewById(R.id.games_rv_2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv1.setLayoutManager(linearLayoutManager);

        List<RA_Objects> list1  = new ArrayList<>();
        list1.add(new RA_Objects("Deep Breathing"));
        list1.add(new RA_Objects("Guided Imagery"));
        list1.add(new RA_Objects("PMR"));
        list1.add(new RA_Objects("Guided Message"));
        list1.add(new RA_Objects("Mindful Walking"));
        list1.add(new RA_Objects("Thoughtful Defusion"));
        list1.add(new RA_Objects("Self-Compassion"));
        list1.add(new RA_Objects("Beach Visualisation"));

        relax_adapter ra_adapter = new relax_adapter(getContext() , list1);
        rv1.setAdapter(ra_adapter);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        rv2.setLayoutManager(linearLayoutManager1);

        List<RA_Objects> list2  = new ArrayList<>();
        list2.add(new RA_Objects("Walking"));
        list2.add(new RA_Objects("Climbing Stairs"));
        list2.add(new RA_Objects("Running"));
        list2.add(new RA_Objects("Cycling"));
        list2.add(new RA_Objects("Skipping Ropes"));

        physical_adapter adapter2 = new physical_adapter(getContext() , list2);
        rv2.setAdapter(adapter2);

        return v;

    }
}
