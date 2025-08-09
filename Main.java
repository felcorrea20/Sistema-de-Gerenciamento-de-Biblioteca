import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        String menu = """
                [1] Adicionar livro
                [2] Listar livros
                [3] Pesquisar livro
                [4] Realizar empréstimo
                [5] Finalizar empréstimo
                [6] Listar empréstimos
                [7] Sair
                """;
        int escolha;

        do {
            System.out.println();
            System.out.print(menu);
            System.out.print("Escolha: ");
            escolha = leitor.nextInt();

            System.out.println();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    leitor.nextLine();
                    String tituloLivro = leitor.nextLine();

                    System.out.print("Digite o autor de " + tituloLivro + ": ");
                    String autorLivro = leitor.nextLine();

                    System.out.print("Digite o ano de publicação: ");
                    String anoPublicacao = leitor.nextLine();

                    biblioteca.adicionarLivro(new Livro(tituloLivro, autorLivro, anoPublicacao));
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título de livro que deseja pesquisar: ");
                    leitor.nextLine();
                    String tituloRef = leitor.nextLine();

                    biblioteca.pesquisarLivro(tituloRef);
                    break;

                case 4:
                    System.out.print("Digite o ID do livro: ");
                    int idLivro1 = leitor.nextInt();

                    System.out.print("Digite o nome do usuário: ");
                    leitor.nextLine();
                    String usuario1 = leitor.nextLine();

                    System.out.println("======= Livros correspondentes =======");

                    biblioteca.realizarEmprestimo(idLivro1, usuario1);

                    break;

                case 5:
                    System.out.print("Digite o ID do livro: "); 
                    int idLivro2 = leitor.nextInt();

                    biblioteca.finalizarEmprestimo(idLivro2);

                    break;

                case 6:
                    biblioteca.listarEmprestimos();
                    break;

                case 7:
                    System.out.println("Até mais...");
                    break;
            }

        } while (escolha != 7);

    }
}
