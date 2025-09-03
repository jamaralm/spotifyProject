package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.Content;
import br.com.spotifyProject.classes.Playlist;
import br.com.spotifyProject.classes.User;

import java.util.Collections;

public class PlaylistServices {

    public void createPlaylist(String name, User user) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome da playlist não pode ser vazio.");
        }
        if (user == null) {
            throw new IllegalArgumentException("Usuário dono da playlist não pode ser nulo.");
        }

    }

    public void addMedia(Playlist playlist, Content media) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser nula.");
        }
        if (media == null) {
            throw new IllegalArgumentException("Mídia não pode ser nula.");
        }
        playlist.getMediaList().add(media);
    }

    public void removeMedia(Playlist playlist, Content media) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser nula.");
        }
        if (media == null) {
            throw new IllegalArgumentException("Mídia não pode ser nula.");
        }
        if (!playlist.getMediaList().remove(media)) {
            System.out.println("⚠️ A mídia não foi encontrada na playlist.");
        }
    }

    public String calculateTotalDuration(Playlist playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser nula.");
        }

        double totalMinutes = 0;
        for (Content m : playlist.getMediaList()) {
            if (m != null && m.getDuration() >= 0) {
                totalMinutes += m.getDuration();
            }
        }

        int hours = (int) totalMinutes / 60;
        int minutes = (int) totalMinutes % 60;

        return (hours > 0) ? hours + "h " + minutes + "min" : minutes + "min";
    }

    public void printPlaylist(Playlist playlist ) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser nula.");
        }

        System.out.println("🎶 Playlist '" + playlist.getName() + "' 🎶");
        System.out.println("Dono: " + (playlist.getUser() != null ? playlist.getUser().getName() : "Desconhecido"));
        System.out.println("Mídias (" + playlist.getMediaList().size() + "):");

        int index = 1;
        getMediaListReadOnly(playlist);

        System.out.println("Duração total: " + calculateTotalDuration(playlist));
    }

    public java.util.List<Content> getMediaListReadOnly(Playlist playlist) {
        return Collections.unmodifiableList(playlist.getMediaList());
    }
}