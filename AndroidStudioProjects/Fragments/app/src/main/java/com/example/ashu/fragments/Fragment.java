package com.example.ashu.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_a,container,false);

        Button button = view.findViewById(R.id.idBtn);
        final EditText editText = view.findViewById(R.id.editView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
