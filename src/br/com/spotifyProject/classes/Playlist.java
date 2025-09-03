package br.com.spotifyProject.classes;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    //private int id;

    private String name;
    private User user;
    private List<Content> mediaList;

    public Playlist(String name, User user) {
        this.name = name;
        this.user = user;
        this.mediaList = new ArrayList<>();
    }

    //public int getId() { return id; }

    public String getName() { return name; }
    public User getUser() { return user; }
    public List<Content> getMediaList() { return mediaList; }

    public void setName(String name) { this.name = name; }
    public void setUser(User user) { this.user = user; }
}