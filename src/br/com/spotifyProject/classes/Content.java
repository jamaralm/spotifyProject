package br.com.spotifyProject.classes;

public class Content {
    private String title;
    private String artist;
    private int duration;
    private SongGenre genre;

    public Content(String title, String artist, int duration, SongGenre genre){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public SongGenre getGenre(){
        return genre;
    }

    public double getDuration(){
        return duration;
    }
}
