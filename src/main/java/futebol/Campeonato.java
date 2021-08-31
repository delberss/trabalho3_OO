package futebol;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    private String nome;
    private List<Clube> clubes;

    public Campeonato(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Nome do campeonato é obrigatório");
        this.nome = nome;
        this.clubes = new ArrayList<Clube>();
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null)
            throw new IllegalArgumentException("Nome do campeonato é obrigatório");
        this.nome = nome;
    }

    public List<Clube> getClubes() {
        return clubes;
    }
    public void setClubes(List<Clube> clubes) {
        this.clubes = clubes;
    }


    public void adicionarClube(Clube clube) {
        if (clube == null) {
            throw new IllegalArgumentException("Clube precisa ser informado");
        }
        if (!this.clubes.contains(clube)) {
            this.clubes.add(clube);
        }
        if (!clube.verificarCampeonato(this)) {
            clube.adicionarCampeonato(this);
        }
    }

    public void removerClube(Clube clube) {
        if (clube == null) {
            throw new IllegalArgumentException("Clube precisa ser informado");
        }
        if (this.clubes.contains(clube)) {
            this.clubes.remove(clube);
        }
        if (clube.verificarCampeonato(this)) {
            clube.removerCampeonato(this);
        }
    }

    public boolean verificarClube(Clube clube) {
        return this.clubes.contains(clube);
    }
}