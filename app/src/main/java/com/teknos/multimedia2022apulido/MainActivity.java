package com.teknos.multimedia2022apulido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import com.teknos.multimedia2022apulido.adapter.Adapter;
import com.teknos.multimedia2022apulido.entities.Song;
import com.teknos.multimedia2022apulido.singleton.Singleton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.sospng, "SOS", "Avicci", "02:38", 2019, 'A', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sos)));
        songs.add(new Song(R.drawable.handclappng, "HandClap", "Fitz and The Tantrums", "03:11", 2016, 'V', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.handclap)));
        songs.add(new Song(R.drawable.halopng, "Halo", "LUM!X", "02:39", 2022, 'A', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.halo)));
        songs.add(new Song(R.drawable.comepng, "Come", "Jain", "02:40", 2015, 'V', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.come)));
        songs.add(new Song(R.drawable.leanonpng, "Lean On", "Major Lazer", "02:58", 2015, 'V', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.leanon)));
        songs.add(new Song(R.drawable.nevergoinghomepng, "Never Going Home", "Kungs", "02:50", 2021, 'A', Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nevergoinghome)));

        Singleton singleton = Singleton.getInstance();
        singleton.setSongs(songs);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llManager);
        Adapter adapter = new Adapter(songs, this);
        recyclerView.setAdapter(adapter);
    }
}