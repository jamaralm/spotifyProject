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

        while (running) {
            if (currentUser == null) {
                System.out.println(" Menu do usuário ");
                System.out.println("1. Cadastrar usuário");
                System.out.println("2. Login");
                System.out.println("3. Sair");
                System.out.print("Escolha: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        userServices.registerUser(scanner);
                        break;
                    case 2:
                        System.out.print("Insira seu email: ");
                        String email = scanner.nextLine();
                        userSessionService.login(email, userServices.getAllUsers());
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
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        mediaServices.listMedia(mediaList);
                        break;
                    case 2:
                        mediaServices.searchMedia(scanner, mediaList);
                        break;
                    case 3:
                        playlistServices.createPlaylist(currentUser, scanner);
                        break;
                    case 4:
                        playlistServices.addMedia(currentUser, mediaList);
                        break;
                    case 5:
                        playlistServices.removeMedia(currentUser, mediaList);
                        break;
                    case 6:
                        playlistServices.printPlaylist(currentUser);
                        break;
                    case 7:
                        currentUser = null;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

        System.out.println("Encerrando o spotify");
    }
}
