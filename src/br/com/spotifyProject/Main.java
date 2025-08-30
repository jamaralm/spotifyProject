package br.com.spotifyProject;

import br.com.spotifyProject.classes.Content;
import br.com.spotifyProject.classes.UserClass;
import br.com.spotifyProject.services.MediaServices;
import br.com.spotifyProject.services.UserServices;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServices userServices = new UserServices();
        MediaServices mediaServices = new MediaServices();
        Scanner sc = new Scanner(System.in);
        ArrayList<UserClass> users = new ArrayList<>();
        ArrayList<Content> songList = new ArrayList<>();

        userServices.registerUser(sc, users);
        mediaServices.createMedia(sc, songList);
        mediaServices.createMedia(sc, songList);
        mediaServices.createMedia(sc, songList);

        mediaServices.listMedia(songList);
        userServices.listUsers(users);
    }
}
