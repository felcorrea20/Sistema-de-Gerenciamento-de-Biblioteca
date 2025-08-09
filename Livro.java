public class Livro {
    private int id;
    private static int proximoID = 1;  //variavel somente para ajudar no id
    private final String titulo;
    private final String autor;
    private final String anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, String anoPublicacao) {
        this.id = proximoID;
        proximoID++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String status() {
        if (isDisponivel()) {
            return "Disponível";
        } else {
            return "Indisponível";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Ano de publicação: " + anoPublicacao + " | Status: " + status();
    }
}
