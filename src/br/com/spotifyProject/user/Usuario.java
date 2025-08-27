package br.com.spotifyProject.user;

import java.util.UUID;

public class Usuario {
    private static int id = 0;
    private String userName;
    private String userEmail;

    public Usuario(String nameInput, String emailInput) {
        this.id += 1;
        this.userName = nameInput;
        this.userEmail = emailInput;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return userName;
    }

    public String getEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "Usuário: " + userName + " | Email: " + userEmail;
    }
}