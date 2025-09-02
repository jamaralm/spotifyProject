package br.com.spotifyProject.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private User user;
    private List<Content> mediaList;

    public Playlist(int id, String name, User user) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID da playlist deve ser positivo.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome da playlist não pode ser vazio.");
        }
        if (user == null) {
            throw new IllegalArgumentException("Usuário dono da playlist não pode ser nulo.");
        }

        this.id = id;
        this.name = name;
        this.user = user;
        this.mediaList = new ArrayList<>();
    }

    public void addMedia(Content media) {
        if (media == null) {
            throw new IllegalArgumentException("Mídia não pode ser nula.");
        }
        mediaList.add(media);
    }

    public void removeMedia(Content media) {
        if (media == null) {
            throw new IllegalArgumentException("Mídia não pode ser nula.");
        }
        if (!mediaList.remove(media)) {
            System.out.println("⚠️ A mídia não foi encontrada na playlist.");
        }
    }

    public String calculateTotalDuration() {
        double totalMinutes = 0;
        for (Content m : mediaList) {
            if (m != null && m.getDuration() >= 0) {
                totalMinutes += m.getDuration();
            }
        }

        int hours = (int) totalMinutes / 60;
        int minutes = (int) totalMinutes % 60;

        if (hours > 0) {
            return hours + "h " + minutes + "min";
        } else {
            return minutes + "min";
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public User getUser() { return user; }
    public List<Content> getMediaList() { return Collections.unmodifiableList(mediaList); }

    @Override
    public String toString() {
        return String.format(
                "🎶 Playlist '%s' 🎶\nDono: %s\nMídias: %d\nDuração total: %s",
                name,
                (user != null ? user.getName() : "Desconhecido"),
                mediaList.size(),
                calculateTotalDuration()
        );
    }
}