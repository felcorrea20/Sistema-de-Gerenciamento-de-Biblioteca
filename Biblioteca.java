import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    List<Livro> livros = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();
    private double multaPorAtraso;

    void adicionarLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("O livro já existe na biblioteca...");
        }
    }

    void listarLivros() {
        for (Livro l : livros) {
            System.out.println(l);
        }

        if (livros.isEmpty()) {
            System.out.println("Não há livros...");
        }
    }

    void pesquisarLivro(String tituloRef) {
        boolean existeLivro = false;

        for (Livro l : livros) {
            if (l.getTitulo().equals(tituloRef)) {
                System.out.println("Livro encontrado!");
                System.out.println(l);
                existeLivro = true;
                break;
            }
        }
        if (!existeLivro) {
            System.out.println("Livro não encontrado...");
        }
    }

    void realizarEmprestimo(int idLivro, String usuario) {
        boolean existeLivro = false;
        boolean livroDisponivel = false;

        for (Livro l : livros) {
            if (l.getId() == idLivro && l.isDisponivel()) {
                livroDisponivel = true;
                Emprestimo emp = new Emprestimo(idLivro, usuario);
                emprestimos.add(emp);
                System.out.println("Empréstimo realizado com sucesso!");
                System.out.println("Data de devolução: " + emp.getDataDevolucaoFormatada());
                l.setDisponivel(false);
                existeLivro = true;
                break;
            }
        }

        if (!existeLivro) {
            System.out.println("Não foi possível encontrar o livro...");
        }

        if (!livroDisponivel) {
            System.out.println("O livro não está disponível para empréstimo...");
        }
    }

    void finalizarEmprestimo(int idLivro) {
        boolean existeEmprestimo = false;

        for (int i=0; i<emprestimos.size();i++) {
            if (emprestimos.get(i).getIdLivro() == idLivro) {
                emprestimos.remove(i);
                long diasDeAtraso = ChronoUnit.DAYS.between(emprestimos.get(i).getDataDevolucao(), emprestimos.get(i).getDataEmprestimo() );
                System.out.println("Empréstimo finalizado com sucesso!");
                existeEmprestimo = true;

                if (diasDeAtraso > 0) {
                    multaPorAtraso *= diasDeAtraso;
                    System.out.printf("Multa por atraso de %d dias: %.2f", diasDeAtraso, multaPorAtraso);
                }

                for (Livro livro : livros) {
                    if (livro.getId() == idLivro) {
                        livro.setDisponivel(true);
                        break;
                    }
                }
                break;
            }
        }

        if (!existeEmprestimo) {
            System.out.println("Não foi possível encontrar esse empréstimo...");
        }


    }

    void listarEmprestimos(){
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }

        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos...");
        }
    }
}
