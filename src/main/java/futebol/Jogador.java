package futebol;

public class Jogador extends Pessoa implements Funcionario{
    private Clube clube;
    private Posicao posicao;
    private float salario;
    private int quantidadeJogos;
    private int quantidadeGols;
    private int quantidadeTitulos;
    private int tempoDeContratoEmAno;
    private boolean jogando;


    public Jogador(String nome,Posicao posicao) {
        super(nome);
        if (posicao == null)
            throw new IllegalArgumentException("Posição é obrigatório");
        this.salario = 0.0f;
        this.posicao = posicao;
        this.quantidadeJogos = 0;
        this.quantidadeGols = 0;
        this.quantidadeTitulos = 0;
        this.tempoDeContratoEmAno = 0;
        this.jogando = false;
    }


    public Clube getClube() {
        return clube;
    }

    public Posicao getPosicao() {
        return posicao;
    }
    public void setPosicao(Posicao posicao) {
        if (posicao == null)
            throw new IllegalArgumentException("Posição é obrigatório");
        this.posicao = posicao;
    }

    public float getSalario() {
        this.calcularSalario();
        return salario;
    }

    public int getQuantidadeJogos() {
        return quantidadeJogos;
    }
    public void setQuantidadeJogos(int quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }

    public int getQuantidadeGols() {
        return quantidadeGols;
    }
    public void setQuantidadeGols(int quantidadeGols) {
        this.quantidadeGols = quantidadeGols;
    }

    public int getQuantidadeTitulos() {
        return quantidadeTitulos;
    }
    public void setQuantidadeTitulos(int quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public boolean isJogando() {
        return jogando;
    }
    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public int getTempoDeContratoEmAno() {
        return tempoDeContratoEmAno;
    }
    public void setTempoDeContratoEmAno(int tempoDeContratoEmAno) {
        this.tempoDeContratoEmAno = tempoDeContratoEmAno;
    }

    public void adicionarClube(Clube clube){
        if (this.clube != clube){
            if (this.clube != null){
                this.clube.removerJogador(this);
            }
            this.clube = clube;
            if (this.clube != null) {
                this.salario = 10000f;
                clube.adicionarJogador(this);
            }
        }
    }

    public void removerClube(){
        this.clube.removerJogador(this);
        this.clube = null;
        this.salario = 0.0f;
        this.tempoDeContratoEmAno = 0;
    }

    public boolean verificaClube(Clube clube){
        return this.clube == clube;
    }


    public void jogar() {
        if (this.clube != null){
            this.setQuantidadeJogos(this.getQuantidadeJogos() + 1);
            this.jogando = true;
        }

        else{
            throw new IllegalArgumentException("O jogador precisa estar em algum clube");
        }
    }


    public void marcarGol() {
        if (this.clube != null){
            if (this.jogando){
                this.setQuantidadeGols(this.getQuantidadeGols() + 1);
            }
            else{
                throw new IllegalArgumentException("O jogador precisa estar atuando");
            }
        }
        else{
            throw new IllegalArgumentException("O jogador precisa estar em algum clube");
        }
    }

    public void contabilizarTitulo(){
        if (this.clube != null)
            this.setQuantidadeTitulos(this.getQuantidadeTitulos() + 1);
        else{
            throw new IllegalArgumentException("O jogador precisa estar em algum clube");
        }
    }

    @Override
    public void calcularSalario() {
        if (this.clube != null) {
            float bonus = 0.0f;

            if (this.posicao.getNome().equals("Atacante")) {
                bonus += 1000 * this.getQuantidadeGols();
            } else {
                if (this.posicao.getNome().equals("Defensor")) {
                    bonus += 500 * this.getQuantidadeJogos();
                }
            }
            this.salario += + bonus;
        }
        else{
            throw new IllegalArgumentException("O jogador precisa estar em algum clube");
        }
    }

    @Override
    public void renovarContrato(){
        if (this.clube != null){
            if (this.getQuantidadeJogos() > 100){
                this.setTempoDeContratoEmAno(this.getTempoDeContratoEmAno() + 1);
            }
            else{
                throw new IllegalArgumentException("O jogador não atingiu o limite de jogos para renovação");
            }
        }
        else{
            throw new IllegalArgumentException("O jogador precisa estar em algum clube");
        }
    }
}