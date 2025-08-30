package br.com.spotifyProject.classes;

public enum SongGenre {
    FUNK(1), RAP(2), MPB(3), PAGODE(4), FORRO(5), POP(6);

    private final int id;

    SongGenre(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static SongGenre getById(int id) {
        for (SongGenre genero : values()) {
            if (genero.getId() == id) {
                return genero;
            }
        }
        return null;
    }
}
