package futebol;

public class Massagista extends Pessoa implements Funcionario {
    private float salario;
    private Clube clube;
    private int jogosPresentes;
    private int tempoDeContratoEmAno;


    public Massagista(String nome) {
        super(nome);
        this.salario = 0f;
        this.jogosPresentes = 0;
        this.tempoDeContratoEmAno = 0;
    }

    public float getSalario() {
        return salario;
    }

    public int getTempoDeContratoEmAno() {
        return tempoDeContratoEmAno;
    }
    public void setTempoDeContratoEmAno(int tempoDeContratoEmAno) {
        this.tempoDeContratoEmAno = tempoDeContratoEmAno;
    }


    public int getJogosPresentes() {
        return jogosPresentes;
    }
    public void setJogosPresentes(int jogosPresentes) {
        if (jogosPresentes < 0){
            throw new IllegalArgumentException("Jogos precisam ser maior ou igual a 0");
        }
        this.jogosPresentes = jogosPresentes;
    }

    public Clube getClube() {
        return clube;
    }
    public void adicionarClube(Clube clube){
        if (this.clube != clube){
            if (this.clube != null){
                this.removerClube(clube);
            }
            this.clube = clube;
            this.salario = 1000f;
            clube.adicionarMassagista(this);
        }
    }

    public void removerClube(Clube clube){
        if (this.clube == clube){
            this.clube = null;
            this.salario = 0f;
            this.tempoDeContratoEmAno = 0;
            clube.removerMassagista(this);
        }
    }



    @Override
    public void calcularSalario() {
        if (this.clube != null)
            this.salario += 10 * this.jogosPresentes;
        else{
            throw new IllegalArgumentException("O Massagista precisa de um clube");
        }
    }

    @Override
    public void renovarContrato(){
        if (this.clube != null){
            if (this.getTempoDeContratoEmAno() < 2 &&  this.getJogosPresentes() > 20){
                this.setTempoDeContratoEmAno(this.getTempoDeContratoEmAno() + 1);
            }
            else{
                throw new IllegalArgumentException("O massagista não está apto para renovação");
            }
        }
        else{
            throw new IllegalArgumentException("O Massagista precisa de um clube");
        }
    }
}