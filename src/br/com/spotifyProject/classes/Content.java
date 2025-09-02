package br.com.spotifyProject.classes;

public class Content {
    private String title;
    private String artist;
    private double duration;
    private SongGenre genre;

    public Content(String title, String artist, double duration, SongGenre genre){
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

    public void setTitle(String title){
        this.title = title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setGenre(SongGenre genre){
        this.genre = genre;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Artist: " + artist + ", Duration: " + duration;
    }
}
