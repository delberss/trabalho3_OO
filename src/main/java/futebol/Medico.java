package futebol;


public class Medico extends Pessoa implements Funcionario{
    private float salario;
    private Clube clube;
    private int tempoDeContratoEmAno;

    public Medico(String nome) {
        super(nome);
        this.salario = 0f;
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

    public Clube getClube() {
        return clube;
    }
    public void adicionarClube(Clube clube){
        if (this.clube != clube){
            if (this.clube != null){
                this.removerClube(clube);
            }
            this.clube = clube;
            this.salario = 5000f;
            clube.adicionarMedico(this);
        }
    }

    public void removerClube(Clube clube){
        if (this.clube == clube){
            this.clube = null;
            this.salario = 0f;
            this.tempoDeContratoEmAno = 0;
            clube.removerMedico(this);
        }
    }



    @Override
    public void calcularSalario() {
        if (this.clube != null)
            this.salario +=  100 * clube.getJogadores().size();
        else{
            throw new IllegalArgumentException("O Médico precisa de um clube");
        }
    }

    @Override
    public void renovarContrato(){
        if (this.clube != null){
            if (this.getTempoDeContratoEmAno() < 1){
                this.setTempoDeContratoEmAno(this.getTempoDeContratoEmAno() + 1);
            }
            else{
                throw new IllegalArgumentException("O médico já possui contrato maior ou igual 1 ano.");
            }
        }
        else{
            throw new IllegalArgumentException("O Médico precisa de um clube");
        }
    }
}