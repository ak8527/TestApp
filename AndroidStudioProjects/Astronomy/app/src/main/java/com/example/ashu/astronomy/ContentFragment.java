package com.example.ashu.astronomy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    Universe universe;

    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(Universe u) {
        Bundle bundle = new Bundle();
        if(!bundle.isEmpty()) {
            bundle.putParcelable("Astronomy", u);
            ContentFragment contentFragment = new ContentFragment();
            contentFragment.setArguments(bundle);
            Log.e("ContentefRAGMENT", "newInstance: Content Fragment");
            return contentFragment;
        }
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        universe = bundle.getParcelable("Astronomy");

        TextView detailCv,detailNv;
        ImageView detailIv;

        detailIv = view.findViewById(R.id.detailImageView);
        detailCv = view.findViewById(R.id.detailContentView);
        detailNv = view.findViewById(R.id.detailNameViw);
        Picasso.get()
                .load(universe.getmImageUrl())
                .noFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(detailIv);

        detailNv.setText(universe.getmName());
        detailCv.setText(universe.getmContent());
    }
}
