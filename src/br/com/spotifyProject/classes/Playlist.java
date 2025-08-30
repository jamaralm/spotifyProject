package br.com.spotifyProject.classes;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String nome;
    private UserClass dono;
    private List<Content> midias;

    public Playlist(int id, String nome, UserClass dono) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.midias = new ArrayList<>();
    }

    public void addMidia(Content midia) {
        midias.add(midia);
    }

    public void removeMidia(Content midia) {
        midias.remove(midia);
    }

    public String calcularDuracaoTotal() {
        double totalMinutos = 0;
        for (Content m : midias) {
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
    public String getNome() { return nome; }
    public UserClass getDono() { return dono; }
    public List<Content> getMidias() { return midias; }

    @Override
    public String toString() {
        return "Playlist{id=" + id +
                ", nome='" + nome + '\'' +
                ", dono=" + dono.getName() +
                ", midias=" + midias.size() +
                ", duração total=" + calcularDuracaoTotal() +
                "}";
    }
}
//a
