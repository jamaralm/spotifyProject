package br.com.spotifyProject.classes;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private UserClass owner;
    private List<Content> medias;

    public Playlist(int id, String name, UserClass owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.medias = new ArrayList<>();
    }

    public void addMidia(Content midia) {
        medias.add(midia);
    }

    public void removeMidia(Content midia) {
        medias.remove(midia);
    }

    public String calcularDuracaoTotal() {
        double totalMinutos = 0;
        for (Content m : medias) {
            totalMinutos += m.getDuration();
        }

        int horas = (int) totalMinutos / 60;
        int minutos = (int) totalMinutos % 60;

        if (horas > 0) {
            return horas + "h " + minutos + "min";
        } else {
            return minutos + "min";
        }
    }

    public int getId() { return id; }
    public String getNome() { return name; }
    public UserClass getDono() { return owner; }
    public List<Content> getMidias() { return medias; }

    @Override
    public String toString() {
        return "Playlist{id=" + id +
                ", Nome='" + name + '\'' +
                ", Dono=" + owner.getName() +
                ", Midias=" + medias.size() +
                ", Duração total=" + calcularDuracaoTotal() +
                "}";
    }
}
//ab
