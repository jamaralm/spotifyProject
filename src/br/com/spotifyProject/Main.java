package br.com.spotifyProject;

import br.com.spotifyProject.classes.UserClass;
import br.com.spotifyProject.services.UserServices;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServices userServices = new UserServices();
        Scanner sc = new Scanner(System.in);
        ArrayList<UserClass> users = new ArrayList<>();

        userServices.registerUser(sc, users);
        userServices.registerUser(sc, users);
        userServices.listUsers(users);
    }
}
