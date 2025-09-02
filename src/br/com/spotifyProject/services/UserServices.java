package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.User;
import br.com.spotifyProject.exceptions.DuplicateEmailException;

import java.util.ArrayList;
import java.util.Scanner;

public class UserServices {
    public static void main(String[] args) {
    }

    public void listUsers(ArrayList<User> usuarios)
    {
        for (User u : usuarios){
            System.out.println(u.getId() + " | " +  u.getName());
        }
    }

    public void registerUser(Scanner sc, ArrayList<User> usuarios) {
        System.out.println("Nome de USUARIO: ");
        String userNameInput = sc.nextLine();

        boolean validEmail = false;
        User usuario = null;

        while(!validEmail){
            System.out.println("Email do USUARIO: ");
            String userEmailInput = sc.nextLine();
            try{
                validateEmail(userEmailInput, usuarios);
                usuario = new User(userNameInput, userEmailInput);
                usuarios.add(usuario);
                validEmail = true;
            } catch (DuplicateEmailException e) {
                System.out.println("⚠️ " + e.getMessage());
                System.out.println("Digite outro email: ");
            }
        }
        System.out.println("✅ USUARIO " + usuario.getName() + " criado com sucesso!");
    }

    public void validateEmail(String email, ArrayList<User> usuarios) throws DuplicateEmailException {
        for (User u : usuarios){
            if (u.getEmail().equalsIgnoreCase(email)){
                throw new DuplicateEmailException("Já existe um usuário com o email: " + email);
            }
        }
    }
}