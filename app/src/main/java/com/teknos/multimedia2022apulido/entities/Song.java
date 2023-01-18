package com.teknos.multimedia2022apulido.entities;

import android.net.Uri;

public class Song {
    private int imageResource;
    private String title;
    private String author;
    private String length;
    private int year;
    private char type;
    private Uri source;

    public Song(int imageResource, String title, String authors, String length, int year, char type, Uri source) {
        this.imageResource = imageResource;
        this.title = title;
        this.author = authors;
        this.length = length;
        this.year = year;
        this.type = type;
        this.source = source;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Uri getSource() {
        return source;
    }

    public void setSource(Uri source) {
        this.source = source;
    }
}