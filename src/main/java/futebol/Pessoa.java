package futebol;

public abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Nome é obrigatório");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Nome é obrigatório");
        this.nome = nome;
    }
}