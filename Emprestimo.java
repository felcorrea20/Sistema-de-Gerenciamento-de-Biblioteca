import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int idLivro;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucao;
    private final String usuario;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Emprestimo(int idLivro, String usuario) {
        this.idLivro = idLivro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(30);
        this.usuario = usuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataEmprestimoFormatada() {
        return dataEmprestimo.format(formatter);
    }

    public String getDataDevolucaoFormatada() {
        return dataDevolucao.format(formatter);
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "ID do Livro: " + idLivro + " | Usuário: " + usuario  + " | Data do empréstimo: " + getDataEmprestimoFormatada() + " | Data da devolução: " + getDataDevolucaoFormatada();
    }
}
