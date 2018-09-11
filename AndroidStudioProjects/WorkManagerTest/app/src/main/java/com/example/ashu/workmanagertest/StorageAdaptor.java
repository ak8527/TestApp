package com.example.ashu.workmanagertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StorageAdaptor extends RecyclerView.Adapter<StorageAdaptor.StorageHolder> {
    Context context;
    ArrayList<Storage> storageArrayList;

    public StorageAdaptor(Context context, ArrayList<Storage> storageArrayList) {
        this.context = context;
        this.storageArrayList = storageArrayList;
    }

    @NonNull
    @Override
    public StorageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.storage_list_item,parent,false);
        return (new StorageHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull StorageHolder holder, int position) {
        Storage storage = storageArrayList.get(position);
        holder.textView.setText(storage.getFileName());

    }

    @Override
    public int getItemCount() {
        if (storageArrayList.size() > 4)
            return 4;
        else
        return storageArrayList.size();
    }

    class StorageHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public StorageHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.storageImageView);
            textView = itemView.findViewById(R.id.searchStorageTv);
        }
    }
}
