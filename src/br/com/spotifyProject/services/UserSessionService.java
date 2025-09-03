package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.User;
import java.util.Optional;

public class UserSessionService {

    public User login(User loggedUser, String email, java.util.List<User> users) {
        Optional<User> user = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();

        if (user.isPresent()) {
            loggedUser = user.get();
            System.out.println("✅ Usuário " + loggedUser.getName() + " logado com sucesso!");
            return loggedUser;
        } else {
            System.out.println("❌ Usuário com email " + email + " não encontrado.");
        }

        return null;
    }

    public void logout(User loggedUser) {
        if (loggedUser != null) {
            System.out.println("👋 Usuário " + loggedUser.getName() + " deslogado.");
            loggedUser = null;
        } else {
            System.out.println("⚠️ Nenhum usuário está logado.");
        }
    }

    public boolean isLoggedIn(User loggedUser) {
        return loggedUser != null;
    }

    public User getLoggedUser(User loggedUser) {
        return loggedUser;
    }
}