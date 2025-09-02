package br.com.spotifyProject.app;

import br.com.spotifyProject.classes.*;
import br.com.spotifyProject.services.MediaServices;
import br.com.spotifyProject.services.PlaylistServices;
import br.com.spotifyProject.services.UserServices;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserServices userServices = new UserServices();
    private static PlaylistServices playlistServices = new PlaylistServices();
    private static MediaServic1es mediaServices = new MediaServices();
    private static User currentUser = null;

    public static void main(String[] args) {
        boolean running = true;

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
                        userServices.registerUser(scanner, userList);
                        break;
                    case 2:
                        loginUser();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("\n Menu do spotify " +
                        "\n1. Listar catálogo" +
                        "\n2. Buscar mídia" +
                        "\n3. Criar playlist" +
                        "\n4. Adicionar/remover mídia da playlist" +
                        "\n5. Mostrar playlist e duração" +
                        "\n6. Logout");
                System.out.print("Escolha: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        listCatalog();
                        break;
                    case 2:
                        searchMedia();
                        break;
                    case 3:
                        createPlaylist();
                        break;
                    case 4:
                        modifyPlaylist();
                        break;
                    case 5:
                        showPlaylist();
                        break;
                    case 6:
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