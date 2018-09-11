package com.example.ashu.astronomy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AstronomyAdapter extends RecyclerView.Adapter<AstronomyAdapter.AstronomyHolder> {
   public Context ctx;
    public ArrayList<Universe> universeArrayList = new ArrayList<Universe>();
    public Communicator communicator;

    public AstronomyAdapter(Context ctx, ArrayList<Universe> universeArrayList, Communicator communicator) {
        this.ctx = ctx;
        this.universeArrayList = universeArrayList;
        this.communicator = communicator;
    }


    @Override
    public AstronomyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false);

        return new AstronomyHolder(view);
    }

    @Override
    public void onBindViewHolder(AstronomyHolder holder, int position) {
        Universe universe = universeArrayList.get(position);
        Picasso.get()
                .load(universe.getmImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.titleImageView);
        holder.titleTextView.setText(universe.getmName());
        holder.contentTextView.setText(universe.getmContent());

    }

    @Override
    public int getItemCount() {
        return universeArrayList.size();
    }


    class AstronomyHolder extends RecyclerView.ViewHolder{

        ImageView titleImageView;
        TextView  titleTextView,contentTextView;

        public AstronomyHolder(View itemView) {
            super(itemView);
             titleImageView = itemView.findViewById(R.id.planetImageView);
             titleTextView = itemView.findViewById(R.id.planetNameView);
             contentTextView = itemView.findViewById(R.id.planetContentView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Astronomy Adapter", "onClick:Astronomy Adapter ");
                    Universe currentUniverse = universeArrayList.get(getAdapterPosition());
                    ContentFragment contentFragment = ContentFragment.newInstance(currentUniverse);
                    communicator.startContentFragment(contentFragment);

                }
            });


        }
    }
}
