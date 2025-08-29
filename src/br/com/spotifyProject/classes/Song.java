package br.com.spotifyProject.classes;

public class Song extends Content{
    public Song(String title, String artist, SongGenre genre, int duration){
        super(title, artist, duration, genre);
    }
}
