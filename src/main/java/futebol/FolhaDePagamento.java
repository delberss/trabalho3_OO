package futebol;

public class FolhaDePagamento {
    private float folhaSalarial;

    public FolhaDePagamento() {
        this.folhaSalarial = 0.0f;
    }

    public float calculaFolhaSalarial(Clube clube) {
        this.calculaSalarioJogadores(clube);
        this.calcularSalarioMedico(clube);
        this.calcularSalarioMassagista(clube);

        return this.folhaSalarial;
    }

    public void calculaSalarioJogadores(Clube clube){
        if (clube.getJogadores() != null)
            for (Jogador jogador: clube.getJogadores()){
                this.folhaSalarial += jogador.getSalario();
            }
    }

    public void calcularSalarioMedico(Clube clube){
        if (clube.getMedico() != null)
            this.folhaSalarial += clube.getMedico().getSalario();
    }

    public void calcularSalarioMassagista(Clube clube){
        if (clube.getMassagista() != null)
            this.folhaSalarial += clube.getMassagista().getSalario();
    }
}