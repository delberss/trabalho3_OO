package futebol;

import java.util.ArrayList;
import java.util.List;

public class Clube {
    private String nome;
    private List<Jogador> jogadores;
    private List<Jogador> atacantes;
    private List<Jogador> defensores;
    private Medico medico;
    private Massagista massagista;
    private List<Campeonato> campeonatos;

    public Clube(String nome) {
        if (nome == null){
            throw new IllegalArgumentException("Nome de clube é obrigatório");
        }
        this.nome = nome;
        this.jogadores = new ArrayList<Jogador>();
        this.atacantes = new ArrayList<Jogador>();
        this.defensores = new ArrayList<Jogador>();
        this.campeonatos = new ArrayList<Campeonato>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null){
            throw new IllegalArgumentException("Nome de clube é obrigatório");
        }
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public List<Jogador> getAtacantes() {
        return atacantes;
    }
    public void setAtacantes(List<Jogador> atacantes) {
        this.atacantes = atacantes;
    }

    public List<Jogador> getDefensores() {
        return defensores;
    }
    public void setDefensores(List<Jogador> defensores) {
        this.defensores = defensores;
    }


    public Medico getMedico() {
        return medico;
    }

    public Massagista getMassagista() {
        return massagista;
    }

    public void adicionarJogador(Jogador jogador){
        if (!this.jogadores.contains(jogador)){
            this.jogadores.add(jogador);
            if (jogador.getPosicao().getNome().equals("Atacante")){
                this.atacantes.add(jogador);
            }
            if (jogador.getPosicao().getNome().equals("Defensor")){
                this.defensores.add(jogador);
            }
            jogador.adicionarClube(this);
        }
    }

    public void adicionarJogador(List<Jogador> jogadores){
        for (Jogador jogador: jogadores){
            if (!this.jogadores.contains(jogador)){
                this.jogadores.add(jogador);
                if (jogador.getPosicao().getNome().equals("Atacante")){
                    this.atacantes.add(jogador);
                }
                if (jogador.getPosicao().getNome().equals("Defensor")){
                    this.defensores.add(jogador);
                }
                jogador.adicionarClube(this);
            }
        }

    }

    public void removerJogador(Jogador jogador){
        if (this.jogadores.contains(jogador)){
            if (jogador.getPosicao().getNome().equals("Atacante")){
                this.atacantes.remove(jogador);
            }
            if (jogador.getPosicao().getNome().equals("Defensor")){
                this.defensores.remove(jogador);
            }
            this.jogadores.remove(jogador);
            jogador.removerClube();
        }
    }

    public void adicionarMedico(Medico medico){
        if (this.medico != medico){
            if (this.medico != null){
                this.removerMedico(medico);
            }
            this.medico = medico;
            medico.adicionarClube(this);
        }
    }

    public void removerMedico(Medico medico){
        if (this.medico == medico){
            this.medico = null;
            medico.removerClube(this);
        }
    }

    public void adicionarMassagista(Massagista massagista){
        if (this.massagista != massagista){
            if (this.massagista != null){
                this.massagista = null;
            }
            this.massagista = massagista;
            massagista.adicionarClube(this);
        }
    }


    public void removerMassagista(Massagista massagista){
        if (this.massagista == massagista){
            this.massagista = null;
            massagista.removerClube(this);
        }
    }


    public boolean verificaJogador(Jogador jogador){
        return this.jogadores.contains(jogador);
    }

    public List<Jogador> atacantes(){
        return this.atacantes;
    }

    public List<Jogador> defensores(){
        return this.defensores;
    }

    public void adicionarCampeonato(Campeonato campeonato) {
        if (campeonato == null) {
            throw new NullPointerException("Campeonato precisa ser informado");
        }
        if (!this.campeonatos.contains(campeonato)) {
            this.campeonatos.add(campeonato);
        }
        if (!campeonato.verificarClube(this)) {
            campeonato.adicionarClube(this);
        }
    }

    public void removerCampeonato(Campeonato campeonato) {
        if (campeonato == null) {
            throw new NullPointerException("Campeonato precisa ser informado");
        }
        if (this.campeonatos.contains(campeonato)) {
            this.campeonatos.remove(campeonato);
        }
        if (campeonato.verificarClube(this)) {
            campeonato.removerClube(this);
        }
    }

    public boolean verificarCampeonato(Campeonato campeonato) {
        return this.campeonatos.contains(campeonato);
    }
}