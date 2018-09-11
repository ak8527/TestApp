package com.example.ashu.astronomy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StarFragment extends Fragment {


    public StarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet, container, false);
    }

    ArrayList<Universe> universeArrayList = new ArrayList<>();

    public ArrayList<Universe> getUniverseArrayList() {

        universeArrayList.add(new Universe("Mars","Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury."
                ,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/OSIRIS_Mars_true_color.jpg/275px-OSIRIS_Mars_true_color.jpg"));
        universeArrayList.add(new Universe("Mars","Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury."
                ,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/OSIRIS_Mars_true_color.jpg/275px-OSIRIS_Mars_true_color.jpg"));
        return universeArrayList;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = view.findViewById(R.id.rvView);
        Communicator communicator = (Communicator)getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AstronomyAdapter(getContext(),getUniverseArrayList(),communicator));
    }

}
