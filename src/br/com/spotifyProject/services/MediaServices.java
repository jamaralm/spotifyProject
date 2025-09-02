package br.com.spotifyProject.services;

import br.com.spotifyProject.classes.Content;
import br.com.spotifyProject.classes.SongGenre;

import java.util.ArrayList;
import java.util.Scanner;

public class MediaServices {

    public static void main(String[] args){

    }

    public void listMedia(ArrayList<Content> list){
        for (Content content : list){
            System.out.println(content);
        }
    }

    public void createMedia(Scanner sc, ArrayList<Content> mediaList){
        System.out.println("Nome: ");
        String mediaNameInput = sc.nextLine();
        System.out.println("Artista: ");
        String artistInput = sc.nextLine();
        System.out.println("Duração: ");
        int durationInput = sc.nextInt();

        double mediaDurationInMinutes = durationInput / 60;

        for(SongGenre genre : SongGenre.values()){
            System.out.println(genre.getId() + " - " + genre.name());
        }

        System.out.println("Genero (DIGITE O ID): ");
        int genreInput = sc.nextInt();
        sc.nextLine();

        SongGenre choosedGenre = SongGenre.getById(genreInput);
        if (choosedGenre == null) {
            System.out.println("Opção inválida ❌");
            return;
        }

        Content newContent = new Content(mediaNameInput, artistInput, mediaDurationInMinutes, choosedGenre);
        mediaList.add(newContent);
    }
}
