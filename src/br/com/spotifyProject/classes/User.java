package br.com.spotifyProject.classes;

public class User {
    private static int id = 0;
    private String userName;
    private String userEmail;

    public User(String nameInput, String emailInput) {
        this.id += 1;
        this.userName = nameInput;
        this.userEmail = emailInput;
    }

    public int getId() {
        return id;
    }

    public String getName() {
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