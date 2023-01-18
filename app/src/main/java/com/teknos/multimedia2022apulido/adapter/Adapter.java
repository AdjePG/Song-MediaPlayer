package com.teknos.multimedia2022apulido.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.teknos.multimedia2022apulido.R;
import com.teknos.multimedia2022apulido.SongMediaPlayer;
import com.teknos.multimedia2022apulido.entities.Song;
import com.teknos.multimedia2022apulido.singleton.Singleton;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Song> songs;
    private Context activity;

    public Adapter (List<Song> songs, Context activity) {
        this.songs = songs;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        final Song song = songs.get(position);

        vh.imgvAlbum.setImageResource(song.getImageResource());
        vh.tvTitle.setText(song.getTitle());
        vh.tvAuthor.setText(song.getAuthor());
        vh.tvYear.setText(String.valueOf(song.getYear()));
        vh.tvLength.setText(song.getLength());
        vh.tvType.setText(String.valueOf(song.getType()));

        vh.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton singleton = Singleton.getInstance();
                singleton.setPosition(holder.getAdapterPosition());

                Intent i = new Intent(activity, SongMediaPlayer.class);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout parent;
        private ImageView imgvAlbum;
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvYear;
        private TextView tvLength;
        private TextView tvType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parent = (ConstraintLayout) itemView.findViewById(R.id.parentLayout);

            this.imgvAlbum = (ImageView) itemView.findViewById(R.id.imgvAlbum);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            this.tvYear = (TextView) itemView.findViewById(R.id.tvYear);
            this.tvLength = (TextView) itemView.findViewById(R.id.tvLength);
            this.tvType = (TextView) itemView.findViewById(R.id.tvType);
        }
    }
}
