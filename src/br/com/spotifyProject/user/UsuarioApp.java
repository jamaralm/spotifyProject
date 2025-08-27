package br.com.spotifyProject.user;

import br.com.spotifyProject.user.exceptions.DuplicateEmailException;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioApp {
    public static void main(String[] args) {
    }

    public void listUsers(ArrayList<Usuario> usuarios)
    {
        for (Usuario u : usuarios){
            System.out.println(u.getId() + " | " +  u.getNome());
        }
    }

    public void registerUser(Scanner sc, ArrayList<Usuario> usuarios) {
        System.out.println("Nome de USUARIO: ");
        String userNameInput = sc.nextLine();

        boolean validEmail = false;
        Usuario usuario = null;

        while(!validEmail){
            System.out.println("Email do USUARIO: ");
            String userEmailInput = sc.nextLine();
            try{
                validateEmail(userEmailInput, usuarios);
                usuario = new Usuario(userNameInput, userEmailInput);
                usuarios.add(usuario);
                validEmail = true;
            } catch (DuplicateEmailException e) {
                System.out.println("⚠️ " + e.getMessage());
                System.out.println("Digite outro email: ");
            }
        }
        System.out.println("✅ USUARIO " + usuario.getNome() + " criado com sucesso!");
    }

    public void validateEmail(String email, ArrayList<Usuario> usuarios) throws DuplicateEmailException {
        for (Usuario u : usuarios){
            if (u.getEmail().equalsIgnoreCase(email)){
                throw new DuplicateEmailException("Já existe um usuário com o email: " + email);
            }
        }
    }
}