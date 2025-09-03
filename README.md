# spotifyProject# Mini Spotify — Sistema de Streaming de Mídias Sonoras

## 📌 Sobre o projeto
Este projeto é uma implementação simplificada de um sistema de **streaming de mídias sonoras**, inspirado em plataformas como o Spotify. Ele foi desenvolvido em **Java** utilizando os princípios de **Programação Orientada a Objetos (POO)**: encapsulamento, herança e polimorfismo. Além disso, faz uso de **estruturas de dados (List, Set, Map)** e **tratamento de exceções** para garantir robustez.

O sistema roda em console e permite cadastro de usuários, gerenciamento de playlists e busca em um catálogo de mídias (músicas, podcasts e audiobooks).

---

## 🎯 Funcionalidades

### Usuário
- Cadastro de usuário (nome e e-mail).
- Login por e-mail.
- Criação e gerenciamento de playlists.

### Mídias
- Cada mídia possui: título, artista/autor/host, duração e gênero.
- Tipos suportados:
  - 🎵 Música
  - 🎙️ Podcast
  - 📚 Audiobook
- Armazenamento centralizado em um catálogo geral.

### Playlist
- Pertence a um único usuário.
- Contém uma lista de mídias.
- Permite adicionar/remover mídias.
- Calcula duração total automaticamente.

### Catálogo
- Armazena todas as mídias cadastradas.
- Permite busca por título, artista ou gênero.
- Exibe todo o catálogo disponível.

### Gêneros
- Enumeração `Genero` com valores como: `ROCK`, `POP`, `MPB`, `JAZZ`, `CLASSICA`, entre outros.

---

## 🗂 Estrutura do projeto
```
src/
└── br/com/minispotify/
    ├── Main.java
    ├── model/
    │   ├── Genero.java
    │   ├── Midia.java
    │   ├── Musica.java
    │   ├── Podcast.java
    │   ├── Audiobook.java
    │   ├── Playlist.java
    │   └── Usuario.java
    ├── repo/
    │   └── Catalogo.java
    ├── service/
    │   ├── CatalogoService.java
    │   ├── PlaylistService.java
    │   └── UsuarioService.java
    └── exception/
        ├── DuplicateEmailException.java
        ├── EntidadeNaoEncontradaException.java
        ├── MediaNaoEncontradaException.java
        ├── PlaylistNaoEncontradaException.java
        └── OperacaoInvalidaException.java
```

---

## ⚙️ Tecnologias utilizadas
- Java 17+ (ou compatível)
- Paradigma **Orientado a Objetos**
- Estruturas de dados: `List`, `Set`, `Map`
- **Exceções personalizadas** para tratar erros

---

## ▶️ Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/minispotify.git
   ```
2. Compile o projeto:
   ```bash
   javac -d bin src/br/com/minispotify/**/*.java
   ```
3. Execute a aplicação:
   ```bash
   java -cp bin br.com.minispotify.Main
   ```

---

## 🚀 Exemplos de uso
- Criar usuário e fazer login.
- Listar catálogo de músicas, podcasts e audiobooks.
- Criar playlists e adicionar mídias do catálogo.
- Buscar mídias por **título**, **artista** ou **gênero**.

---

## 👨‍💻 Autores
Projeto desenvolvido para fins acadêmicos. 

Grupo de até 5 integrantes.

---

## 📊 Comparação com ChatGPT
Além da implementação, é esperado que seja feita uma **análise crítica** comparando:
- Similaridades entre a solução própria e a gerada pelo ChatGPT.
- Diferenças de implementação (organização de pacotes, nomes de classes, lógica de menus, etc).
- Pontos fortes e fracos de cada versão.
