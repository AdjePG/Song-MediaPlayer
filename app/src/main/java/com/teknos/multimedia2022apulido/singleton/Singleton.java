package com.teknos.multimedia2022apulido.singleton;

import com.teknos.multimedia2022apulido.entities.Song;

import java.util.ArrayList;

public class Singleton {
    private ArrayList<Song> songs;
    private int position;

    private static class SingletonInstance {
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public Singleton() {
        //Constructor Singleton
    }

    public Song getSong() {
        return songs.get(position);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}