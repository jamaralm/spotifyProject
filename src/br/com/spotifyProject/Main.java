package br.com.spotifyProject;

import br.com.spotifyProject.classes.*;
import br.com.spotifyProject.services.MediaServices;
import br.com.spotifyProject.services.PlaylistServices;
import br.com.spotifyProject.services.UserServices;
import br.com.spotifyProject.services.UserSessionService;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    private static PlaylistServices playlistServices = new PlaylistServices();
    private static UserSessionService userSessionService = new UserSessionService();
    private static MediaServices mediaServices = new MediaServices();
    private static User currentUser = null;

    public static void main(String[] args) {
        boolean running = true;

        ArrayList<Content> mediaList = new ArrayList<>();
        ArrayList<Playlist> playlists = new ArrayList<>();

        //MÚSICAS
        mediaList.add(new Content("Baile de Favela", "MC João", 4.3, SongGenre.FUNK));
        mediaList.add(new Content("Bum Bum Tam Tam", "MC Fioti", 3.5, SongGenre.FUNK));

        mediaList.add(new Content("AmarElo", "Emicida", 5.0, SongGenre.RAP));
        mediaList.add(new Content("Rap God", "Eminem", 6.1, SongGenre.RAP));

        mediaList.add(new Content("Águas de Março", "Tom Jobim", 3.6, SongGenre.MPB));
        mediaList.add(new Content("Trem-Bala", "Ana Vilela", 4.0, SongGenre.MPB));

        mediaList.add(new Content("Ainda Gosto Dela", "Exaltasamba", 4.2, SongGenre.PAGODE));
        mediaList.add(new Content("Cheia de Manias", "Raça Negra", 5.1, SongGenre.PAGODE));

        mediaList.add(new Content("Coração", "Aviões do Forró", 4.0, SongGenre.FORRO));
        mediaList.add(new Content("Anjo Querubim", "Calcinha Preta", 3.8, SongGenre.FORRO));

        mediaList.add(new Content("Shape of You", "Ed Sheeran", 4.2, SongGenre.POP));
        mediaList.add(new Content("Blinding Lights", "The Weeknd", 3.5, SongGenre.POP));

        //PODCASTS
        mediaList.add(new Podcast("Flow Podcast #1", "Monark & Igor", 120));
        mediaList.add(new Podcast("Inteligência Ltda", "Rogério Vilela", 90));
        mediaList.add(new Podcast("Café da Manhã", "Folha de SP", 25));


        //AUDIOBOOKS
        mediaList.add(new Audiobooks("O Hobbit", "J.R.R. Tolkien", 720));
        mediaList.add(new Audiobooks("1984", "George Orwell", 660));
        mediaList.add(new Audiobooks("Dom Casmurro", "Machado de Assis", 480));

        while (running) {
            if (currentUser == null) {
                System.out.println(" Menu do usuário ");
                System.out.println("1. Cadastrar usuário");
                System.out.println("2. Login");
                System.out.println("3. Sair");
                System.out.print("Escolha: ");
                int option;
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    continue;
                }

                switch (option) {
                    case 1:
                        userServices.registerUser(scanner);
                        break;
                    case 2:
                        System.out.print("Insira seu email: ");
                        String email = scanner.nextLine();
                        currentUser = userSessionService.login(currentUser, email, userServices.getAllUsers());
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("\n Menu do spotify " +
                        "\n1. Listar mídias" +
                        "\n2. Buscar mídia" +
                        "\n3. Criar playlist" +
                        "\n4. Adicionar mídia da playlist" +
                        "\n5  Remover mídia da playlist" +
                        "\n6. Mostrar playlist e duração" +
                        "\n7. Logout");
                System.out.print("Escolha: ");
                int option;
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    continue;
                }

                switch (option) {
                    case 1:
                        mediaServices.listMedia(mediaList);
                        break;
                    case 2:
                        mediaServices.searchMedia(scanner, mediaList);
                        break;
                    case 3:
                        System.out.println("Digite o nome da Playlist: ");
                        String playlistInputName = scanner.nextLine();

                        Playlist newPlaylist = new Playlist(
                                playlistInputName,
                                currentUser
                        );
                        playlists.add(newPlaylist);

                        System.out.println("✅ Playlist criada com sucesso!");
                        break;
                    case 4:
                        if (playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada ainda.");
                            break;
                        }

                        System.out.println("Escolha a playlist:");
                        for (int i = 0; i < playlists.size(); i++) {
                            System.out.println((i + 1) + " - " + playlists.get(i).getName());
                        }
                        int playlistIndexAdd;
                        try {
                            playlistIndexAdd = Integer.parseInt(scanner.nextLine()) - 1;
                            if (playlistIndexAdd < 0 || playlistIndexAdd >= playlists.size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                            break;
                        }
                        Playlist playlistToAdd = playlists.get(playlistIndexAdd);

                        mediaServices.listMedia(mediaList);
                        System.out.println("Digite o índice da mídia para adicionar:");
                        int mediaIndex;
                        try {
                            mediaIndex = Integer.parseInt(scanner.nextLine()) - 1;
                            if (mediaIndex < 0 || mediaIndex >= mediaList.size()) {
                                System.out.println("Índice de mídia inválido.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                            break;
                        }
                        Content mediaToAdd = mediaList.get(mediaIndex);

                        playlistServices.addMedia(playlistToAdd, mediaToAdd);
                        System.out.println("✅ Mídia adicionada à playlist!");


                    case 5:
                        if (playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada ainda.");
                            break;
                        }

                        System.out.println("Escolha a playlist:");
                        for (int i = 0; i < playlists.size(); i++) {
                            System.out.println((i + 1) + " - " + playlists.get(i).getName());
                        }
                        int playlistIndexRemove;
                        try {
                            playlistIndexRemove = Integer.parseInt(scanner.nextLine()) - 1;
                            if (playlistIndexRemove < 0 || playlistIndexRemove >= playlists.size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                            break;
                        }
                        Playlist playlistToRemove = playlists.get(playlistIndexRemove);

                        if (playlistToRemove.getMediaList().isEmpty()) {
                            System.out.println("Essa playlist não tem mídias.");
                            break;
                        }
                        for (int i = 0; i < playlistToRemove.getMediaList().size(); i++) {
                            System.out.println((i + 1) + " - " + playlistToRemove.getMediaList().get(i).getTitle());
                        }
                        System.out.println("Digite o índice da mídia para remover:");
                        int mediaIndexRemove;
                        try {
                            mediaIndexRemove = Integer.parseInt(scanner.nextLine()) - 1;
                            if (mediaIndexRemove < 0 || mediaIndexRemove >= playlistToRemove.getMediaList().size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                            break;
                        }
                        Content mediaToRemove = playlistToRemove.getMediaList().get(mediaIndexRemove);

                        playlistServices.removeMedia(playlistToRemove, mediaToRemove);
                        System.out.println("✅ Mídia removida da playlist!");

                    case 6:
                        if (playlists.isEmpty()) {
                            System.out.println("⚠Nenhuma playlist criada ainda.");
                            break;
                        }

                        System.out.println("Escolha a playlist:");
                        for (int i = 0; i < playlists.size(); i++) {
                            System.out.println((i + 1) + " - " + playlists.get(i).getName());
                        }
                        int playlistIndexPrint;
                        try {
                            playlistIndexPrint = Integer.parseInt(scanner.nextLine()) - 1;
                            if (playlistIndexPrint < 0 || playlistIndexPrint >= playlists.size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                            break;
                        }
                        Playlist playlistToPrint = playlists.get(playlistIndexPrint);
                        playlistServices.printPlaylist(playlistToPrint);

                    case 7:
                        currentUser = null;
                        System.out.println("Você saiu da conta! Agradecemos o acesso.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

        System.out.println("Encerrando o spotify...");
    }
}
