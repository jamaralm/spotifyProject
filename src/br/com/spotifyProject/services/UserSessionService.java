package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.User;
import java.util.Optional;

public class UserSessionService {
    private static User loggedUser = null;

    public void login(String email, java.util.List<User> users) {
        Optional<User> user = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();

        if (user.isPresent()) {
            loggedUser = user.get();
            System.out.println("✅ Usuário " + loggedUser.getName() + " logado com sucesso!");
        } else {
            System.out.println("❌ Usuário com email " + email + " não encontrado.");
        }
    }

    public void logout() {
        if (loggedUser != null) {
            System.out.println("👋 Usuário " + loggedUser.getName() + " deslogado.");
            loggedUser = null;
        } else {
            System.out.println("⚠️ Nenhum usuário está logado.");
        }
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}