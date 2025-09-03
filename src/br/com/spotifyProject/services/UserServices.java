package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.User;
import br.com.spotifyProject.exceptions.DuplicateEmailException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {

    private List<User> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        UserServices userServices = new UserServices();
        Scanner sc = new Scanner(System.in);

        userServices.registerUser(sc);
        userServices.listUsers();
    }

    public void listUsers() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (User u : usuarios) {
            System.out.println(u.getId() + " | " + u.getName());
        }
    }

    public void registerUser(Scanner sc) {
        System.out.println("Nome de USUARIO: ");
        String userNameInput = sc.nextLine();

        boolean validEmail = false;
        User usuario = null;

        while (!validEmail) {
            System.out.println("Email do USUARIO: ");
            String userEmailInput = sc.nextLine();
            try {
                validateEmail(userEmailInput);
                usuario = new User(userNameInput, userEmailInput);
                add(usuario);
                validEmail = true;
            } catch (DuplicateEmailException e) {
                System.out.println("⚠️ " + e.getMessage());
                System.out.println("Digite outro email: ");
            }
        }
        System.out.println("✅ USUARIO " + usuario.getName() + " criado com sucesso!");
    }

    private void add(User usuario) {
        usuarios.add(usuario);
    }

    public void validateEmail(String email) throws DuplicateEmailException {
        for (User u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                throw new DuplicateEmailException("Já existe um usuário com o email: " + email);
            }
        }
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(usuarios);
    }
}
