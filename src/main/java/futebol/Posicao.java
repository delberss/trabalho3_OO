package futebol;

public class Posicao {
    private String nome;

    public Posicao(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Posição é obrigatória");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Posição é obrigatória");
        this.nome = nome;
    }
}
